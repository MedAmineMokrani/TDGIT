package entities;

public class Restaurant {



    private int id;

    private String restaurantName;

    private String address;


    public Restaurant(int id, String restaurantName, String address) {
        this.id = id;
        this.restaurantName = restaurantName;
        this.address = address;

    }

    @Override
    public String toString() {
        return "Restaurant ID : " + id + " | " + "Restaurant Name : " + restaurantName + " | " +"Restaurant Address : " + address ;
    }
}

