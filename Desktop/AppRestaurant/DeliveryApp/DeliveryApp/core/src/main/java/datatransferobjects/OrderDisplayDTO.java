package datatransferobjects;

import java.util.UUID;

public class OrderDisplayDTO {

    public String Customername;
    public String address;
    public int restaurantnumber;
    public int menunumber;
    public Long creditcard;
    public int paymentmethod;

    public int deliverymanid;

    public String State;
    public int clientid;
    public int id;

    public OrderDisplayDTO (String Customername, String address, int restaurantnumber, int menunumber,Long creditcard, int paymentmethod,String State,int deliverymanid,int id) {
        this.Customername = Customername;
        this.address = address;
        this.restaurantnumber = restaurantnumber;
        this.menunumber = menunumber;
        this.creditcard = creditcard;
        this.paymentmethod = paymentmethod;
        this.State = State;
        this.deliverymanid = deliverymanid;
        this.id = id;

    }

}