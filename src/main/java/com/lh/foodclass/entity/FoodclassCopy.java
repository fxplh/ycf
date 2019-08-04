package com.lh.foodclass.entity;

import java.io.Serializable;
import java.util.List;

public class FoodclassCopy{

    private String id;

    private String name;

    private String photo;

    private Integer ishot;

    private List<Foodclass> childClass;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public Integer getIshot() {
        return ishot;
    }

    public void setIshot(Integer ishot) {
        this.ishot = ishot;
    }

    public List<Foodclass> getChildClass() {
        return childClass;
    }

    public void setChildClass(List<Foodclass> childClass) {
        this.childClass = childClass;
    }

    @Override
    public String toString() {
        return "FoodclassCopy{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                ", ishot=" + ishot +
                ", childClass=" + childClass +
                '}';
    }
}