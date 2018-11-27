package com.way.rapid.shopping.bean;

public class Shopping {
    private int id;
    private String title;
    private String price;
    private String img;
    private int num;

    public Shopping() {
    }

    public Shopping(int id, String title, String price, String img, int num) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.img = img;
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
