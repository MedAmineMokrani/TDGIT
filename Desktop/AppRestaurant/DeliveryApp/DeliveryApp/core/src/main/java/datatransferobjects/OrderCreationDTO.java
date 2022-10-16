package datatransferobjects;

import java.util.UUID;

public class OrderCreationDTO {

    public String Customername;
    public String address;
    public int restaurantid;
    public int menuid;
    public Long creditcard;
    public int paymentmethod;
    public String State;

    public int deliverymanid;
    public int clientid;
    public int id = 0;

    public OrderCreationDTO (String Customername, String address, int restaurantid, int menuid,Long creditcard, int paymentmethod,String State,int deliverymanid,int clientid,int id) {
        this.Customername = Customername;
        this.address = address;
        this.restaurantid = restaurantid;
        this.menuid = menuid;
        this.creditcard = creditcard;
        this.paymentmethod = paymentmethod;
        this.State = State;
        this.deliverymanid = deliverymanid;
        this.clientid = clientid;
        this.id = id++;
    }

}
