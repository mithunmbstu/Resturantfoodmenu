package com.example.user.resturantfoodmenu.Adapter;

/**
 * Created by User on 3/31/2016.
 */
public class Listrowiteam {




    String menuno;
    String name;
    String image;
    String price;


    public Listrowiteam(String name, String menuno, String image, String price) {
        this.name = name;
        this.menuno = menuno;
        this.image = image;
        this.price = price;
    }

    public Listrowiteam() {
        super();

    }

    public String getMenuno() {
        return menuno;
    }
    public void setMenuno(String menuno) {
        this.menuno = menuno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }


    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}





