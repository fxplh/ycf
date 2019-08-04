package com.lh.util;

/**
 * Created by Administrator on 2019/6/1.
 */
public class PriceFood {

    private String foodId;
    private String photo;
    private String name;
    private int price;
    private String info;

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "PriceFood{" +
                "foodId='" + foodId + '\'' +
                ", photo='" + photo + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", info='" + info + '\'' +
                '}';
    }
}
