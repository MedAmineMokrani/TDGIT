package entities;

import java.time.LocalDate;
import java.util.UUID;

public class Order{

    public String getCustomername() {
        return Customername;
    }

    public void setCustomername(String customername) {
        Customername = customername;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRestaurantnumber() {
        return restaurantnumber;
    }

    public void setRestaurantnumber(int restaurantnumber) {
        this.restaurantnumber = restaurantnumber;
    }

    public int getMenunumber() {
        return menunumber;
    }

    public void setMenunumber(int menunumber) {
        this.menunumber = menunumber;
    }

    private String Customername;
    private String address;
    private int restaurantnumber;
    private int menunumber;
    private Long creditcard;

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    private String State;

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    private int orderid;

    public int getDeliverymanid() {
        return deliverymanid;
    }

    public void setDeliverymanid(int deliverymanid) {
        this.deliverymanid = deliverymanid;
    }

    private int deliverymanid;

    public Long getCreditcard() {
        return creditcard;
    }

    public void setCreditcard(Long creditcard) {
        this.creditcard = creditcard;
    }

    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    public UUID getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(UUID ordernumber) {
        this.ordernumber = ordernumber;
    }



    private int clientid;
    private UUID ordernumber;
    private int id = 0;

    public Order(UUID ordernumber, String Customername, String address, int restaurantnumber, int menunumber,Long creditcard, String State,int deliverymanid,int clientid,int orderid) {
        this.Customername = Customername;
        this.address = address;
        this.restaurantnumber = restaurantnumber;
        this.menunumber = menunumber;
        this.creditcard = creditcard;
        this.State = State;
        this.ordernumber = ordernumber;
        this.clientid = clientid;
        this.deliverymanid = deliverymanid;
        this.orderid = orderid++;
    }

    @Override
    public String toString() {
        return "Order number : " + ordernumber + " | " + "Customer Name : " + Customername + " | " + " Address : " + address + " | " + " RestaurantId : " + restaurantnumber + " | " + " MenuId : " + menunumber + " | " + " Order id : " + orderid + " | " + " Order State : " + State + "\r\n";
    }
}
