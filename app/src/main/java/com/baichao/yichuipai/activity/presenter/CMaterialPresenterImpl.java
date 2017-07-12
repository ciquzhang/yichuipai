package com.baichao.yichuipai.activity.presenter;

import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.ImageView;

import com.baichao.yichuipai.activity.module.NetForPictureBean;
import com.baichao.yichuipai.activity.view.CMaterialView;
import com.baichao.yichuipai.utils.ACache;
import com.baichao.yichuipai.utils.Constant;
import com.baichao.yichuipai.utils.NetUtils;
import com.baichao.yichuipai.view.ImageTools;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;

import static com.baichao.yichuipai.utils.Constant.CHOOSE_PICTURE_FRONT;
import static com.baichao.yichuipai.utils.Constant.TAKE_PICTURE_FRONT;

/**
 * Created by pll on 2017/5/18.
 */

public class CMaterialPresenterImpl implements CMaterialPresenter {

    private Context context;
    private CMaterialView cMaterialView;
    private File file_card_business = null;//营业执照图片文件
    private File file_card_front = null;//身份证正面图片文件
    private File file_card_contrary = null;//身份证反面图片文件
    private File file_card_other = null;//手持身份证图片
    private static final int SCALE = 2;//照片缩小比例

    public CMaterialPresenterImpl(Context context, CMaterialView cMaterialView) {
        this.context = context;
        this.cMaterialView = cMaterialView;
    }

    @Override
    public void showPicturePicker(Context context, final int takeType, final int chooseType) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("请选择图片来源");
        builder.setNegativeButton("取消", null);
        builder.setItems(new String[]{"拍照", "相册"}, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case TAKE_PICTURE_FRONT:
                        //身份正面（拍照）
                        takePicture(takeType);
                        break;
                    case CHOOSE_PICTURE_FRONT:
                        //身份证正面（相册）
                        choosePicture(chooseType);
                        break;
                    default:
                        break;
                }
            }
        });
        builder.create().show();
    }

    private void takePicture(int takePictureFront) {
        Intent openCameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        Uri imageUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), "image.jpg"));
        //指定照片保存路径（SD卡），image.jpg为一个临时文件，每次拍照后这个图片都会被替换
        openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        cMaterialView.startActivityByPicture(openCameraIntent, takePictureFront);
    }

    private void choosePicture(int choosePictureFront) {
        Intent openAlbumIntent = new Intent(Intent.ACTION_GET_CONTENT);
        openAlbumIntent.setType("image/*");
        cMaterialView.startActivityByPicture(openAlbumIntent, choosePictureFront);
    }

    @Override
    public void showImageByTake(int pictureType, File file, ImageView imageView) {
        //将保存在本地的图片取出并缩小后显示在界面上
        if (pictureType == 0) {
            file = new File(Environment.getExternalStorageDirectory() + "/id_front_take.jpg");
            file_card_front = file;
        } else if (pictureType == 1) {
            file = new File(Environment.getExternalStorageDirectory() + "/id_back_take.jpg");
            file_card_contrary = file;
        } else if (pictureType == 2) {
            file = new File(Environment.getExternalStorageDirectory() + "/id_face_take.jpg");
            file_card_other = file;
        } else {
            file = new File(Environment.getExternalStorageDirectory() + "/id_business_take.jpg");
            file_card_business = file;
        }

        if (file != null && file.exists()) {
            Bitmap bitmap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory() + "/image.jpg");
            Bitmap newBitmap = ImageTools.zoomBitmap(bitmap, bitmap.getWidth() / SCALE, bitmap.getHeight() / SCALE);
            try {
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
                newBitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
                bos.flush();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //由于Bitmap内存占用较大，这里需要回收内存，否则会报out of memory异常
            bitmap.recycle();
            //将处理过的图片显示在界面上，并保存到本地
            imageView.setImageBitmap(newBitmap);
            ImageTools.savePhotoToSDCard(newBitmap, Environment.getExternalStorageDirectory().getAbsolutePath(),
                    String.valueOf(System.currentTimeMillis()));
        }
    }

    @Override
    public void showImageByChoose(int pictureType, Intent data, File file, ImageView imageView) {
        ContentResolver resolver = context.getContentResolver();
        //照片的原始资源地址
        Uri originalUri = data.getData();
        try {
            //使用ContentProvider通过URI获取原始图片
            Bitmap photo = MediaStore.Images.Media.getBitmap(resolver, originalUri);
            if (photo != null) {
                //为防止原始图片过大导致内存溢出，这里先缩小原图显示，然后释放原始Bitmap占用的内存
                Bitmap smallBitmap = ImageTools.zoomBitmap(photo, photo.getWidth() / SCALE, photo.getHeight() / SCALE);
                if (pictureType == 0) {
                    file = NetUtils.saveFile(photo, "/storage/emulated/0/", "id_front.png");
                    file_card_front = file;
                } else if (pictureType == 1) {
                    file = NetUtils.saveFile(photo, "/storage/emulated/0/", "id_back.png");
                    file_card_contrary = file;
                } else if (pictureType == 2) {
                    file = NetUtils.saveFile(photo, "/storage/emulated/0/", "id_face.png");
                    file_card_other = file;
                } else {
                    file = NetUtils.saveFile(photo, "/storage/emulated/0/", "id_business.png");
                    file_card_business = file;
                }
                //释放原始图片占用的内存，防止out of memory异常发生
                photo.recycle();
                imageView.setImageBitmap(smallBitmap);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void netForPicture() {
        if (file_card_front == null) {
            cMaterialView.showToast("身份证正面照未选择");
        } else if (file_card_contrary == null) {
            cMaterialView.showToast("身份证反面照未选择");
        } else if (file_card_other == null) {
            cMaterialView.showToast("手持身份证照未选择");
        } else if (file_card_business == null) {
            cMaterialView.showToast("营业执照未选择");
        } else {
            String token = ACache.get(context).getAsString("token");
            Log.e("TAG", "---token--" + token);
            Map<String, String> headers = new HashMap<>();
            headers.put("token", token);
            OkHttpUtils
                    .post()
                    .addFile("idcard_front", "idcard_front.png", file_card_front)
                    .addFile("idcard_back", "idcard_back.png", file_card_contrary)
                    .addFile("hand_idcard", "hand_idcard.png", file_card_other)
                    .addFile("bussiness_licence", "file_card_business.png", file_card_business)
                    .url(Constant.NET_APP_FILE)
                    .headers(headers)
                    .build()
                    .execute(new FileCallback());
        }
    }

    private class FileCallback extends StringCallback {
        @Override
        public void onError(Call call, Exception e) {
            Log.e("TAG", "--error---" + e.getMessage());
            cMaterialView.showToast("添加失败,可能是网络原因");
        }

        @Override
        public void onResponse(String response) {
            Log.e("TAG", "---企业认证response--" + response);
            Gson gson = new Gson();
            NetForPictureBean netForPictureBean = gson.fromJson(response.toString(),NetForPictureBean.class);
            if(netForPictureBean.getCode().equals("1") && netForPictureBean.getData()!=null){
                Intent intent = new Intent();
                ArrayList<String> list = new ArrayList<>();
                list.add(netForPictureBean.getData().getIdcard_front());
                list.add(netForPictureBean.getData().getIdcard_back());
                list.add(netForPictureBean.getData().getHand_idcard());
                list.add(netForPictureBean.getData().getHand_idcard());
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("approve_c",list);
                intent.putExtras(bundle);
                cMaterialView.showToast("添加成功");
                cMaterialView.commitSuccess(intent);
            }else{
                cMaterialView.showToast("添加失败");
            }
        }
    }
}
