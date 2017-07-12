package com.baichao.yichuipai.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by pll on 2017/1/22.
 */

public class Md5Utils {
    public static String getMd5ByFile(File file) {
        String value = null;
        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
            MappedByteBuffer byteBuffer = in.getChannel().map(FileChannel.MapMode.READ_ONLY, 0,
                    file.length());
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(byteBuffer);
            BigInteger bi = new BigInteger(1, md5.digest());
            value = bi.toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }


    public enum AlgorithmEnum {
        MD5, SHA
    }

    /**
     * 加密方法（单向）
     *
     * @param password 原始密码
     * @param algorithm 加密算法类型，如：SHA
     * @return String 加密后的值
     * @throws UnsupportedEncodingException
     */
    public static String getMd5ByString(String password, AlgorithmEnum algorithm) {
        byte[] unencodedPassword = password.getBytes();
        MessageDigest md = null;
        String algorithmString = "";
        if (algorithm == AlgorithmEnum.MD5) {
            algorithmString = "MD5";
        } else if (algorithm == AlgorithmEnum.SHA) {
            algorithmString = "SHA";
        }
        try {
            // first create an instance, given the provider
            md = MessageDigest.getInstance(algorithmString);
        } catch (Exception e) {
            System.out.println("错误，获得加密算法！Exception: " + e);
            return password;
        }
        md.reset();
        md.update(unencodedPassword);

        byte[] encodedPassword = md.digest();
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < encodedPassword.length; i++) {
            if ((encodedPassword[i] & 0xff) < 0x10) {
                buf.append("0");
            }
            buf.append(Long.toString(encodedPassword[i] & 0xff, 16));
        }
        return buf.toString();
    }

    public static String getMd5By32(String plain) {
        String re_md5 = new String();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plain.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            re_md5 = buf.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return re_md5;
    }
}
