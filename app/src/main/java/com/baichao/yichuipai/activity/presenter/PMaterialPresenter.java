package com.baichao.yichuipai.activity.presenter;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by pll on 2017/5/12.
 */

public interface PMaterialPresenter {
    void showPicturePicker(Context context, int takeType, int chooseType);
    void showImageByTake(int pictureType, File file, ImageView imageView);
    void showImageByChoose(int pictureType, Intent data, File file, ImageView imageView);
    void netForPicture();
}
