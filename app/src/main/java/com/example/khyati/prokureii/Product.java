package com.example.khyati.prokureii;

/**
 * Created by khyati on 9/27/2015.
 */
public class Product {
    private int imgId;
    private String productName;

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    Product(int img, String name){
        this.imgId = img;
        this.productName = name;
    }
}
