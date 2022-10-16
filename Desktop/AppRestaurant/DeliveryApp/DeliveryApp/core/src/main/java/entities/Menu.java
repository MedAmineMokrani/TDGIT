package entities;

import java.util.UUID;

public class Menu {




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRestaurantid() {
        return restaurantid;
    }

    public void setRestaurantid(int restaurantid) {
        this.restaurantid = restaurantid;
    }

    public String getMenuname() {
        return Menuname;
    }

    public void setMenuname(String menuname) {
        Menuname = menuname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int id;

    public int restaurantid;

    public String Menuname;
    public double price;






    public Menu (int id, int restaurantid, String Menuname, double price) {
        this.restaurantid = restaurantid;
        this.Menuname = Menuname;
        this.price = price;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Menu ID : " + id + " | " + "Menu Name : " + Menuname + " | " + "Restaurant ID : " + restaurantid + " | " + "Menu Price : "+ price + "\r\n" ;
    }
}

