package com.way.rapid.shopping.bean;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class ImageShow {
    private ImageView imageView;
    private Bitmap bitmap;
    public ImageShow(ImageView imageView, Bitmap bitmap) {
        this.imageView = imageView ;
        this.bitmap = bitmap;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
