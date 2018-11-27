package com.way.rapid.shopping.help;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Message;

import com.way.rapid.shopping.bean.ImageShow;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageHttpThread extends Thread{
   private String imgUrl;
   private Bitmap bitmap;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    @Override
    public void run() {
        try {
                    HttpURLConnection conn = (HttpURLConnection) new URL("http://192.168.22.2:8080/shopping/"+imgUrl).openConnection();
                    conn.setConnectTimeout(5000);
                    conn.setReadTimeout(5000);
                    conn.setRequestMethod("GET");
                    InputStream inputStream = conn.getInputStream();
                    bitmap = BitmapFactory.decodeStream(inputStream);
                    inputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
    }
}
