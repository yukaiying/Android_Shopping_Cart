package com.way.rapid.shopping.help;

import android.annotation.SuppressLint;
import android.os.Message;
import android.widget.ImageView;

import com.way.rapid.shopping.bean.ImageShow;

public class ShowImageByHttp {
     @SuppressLint("HandlerLeak")
    private static android.os.Handler handler = new android.os.Handler() {
        @Override
        public void handleMessage(Message msg) {
            ImageShow imageShow = (ImageShow) msg.obj;
            imageShow.getImageView().setImageBitmap(imageShow.getBitmap());
            super.handleMessage(msg);
        }
    };

    public static void setImage(String path, ImageView view) {
        ImageHttpThread imageHttpThread = new ImageHttpThread();
        imageHttpThread.setImgUrl(path);
        imageHttpThread.start();
        try {
            imageHttpThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Message message = new Message();
        message.obj = new ImageShow(view, imageHttpThread.getBitmap());
        handler.sendMessage(message);
    }

}
