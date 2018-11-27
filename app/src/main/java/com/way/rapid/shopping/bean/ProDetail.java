package com.way.rapid.shopping.bean;

public class ProDetail {
    private Integer id;
    private int image;
    private String price;
    private String title;
    private Integer num;

    public ProDetail(Integer id, int image,String  price, String title, Integer num) {
        this.id = id;
        this.image = image;
        this.price = price;
        this.title = title;
        this.num = num;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
