package repositories;

import entities.UserAccount;

public class Authentification {

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    private String username;
    private String password;



    UserAccount newcustomer = new UserAccount(1,"customer",1,"customerpass");

    UserAccount newdeliveryman = new UserAccount(1,"deliveryman",2,"deliverymanpass");

    public UserAccount getNewcustomer() {
        return newcustomer;
    }



    public Authentification(String username, String password)
    {
        this.username = username;
        this.password = password;


    }

    public boolean checkPasswordCustomer()
    {

        if((username.equals(newcustomer.getUsername()) && (password.equals(newcustomer.getPassword()))))
            return true;
        else
            return false;
    }

    public boolean checkPasswordDeliveryMan()
    {

        if((username.equals(newdeliveryman.getUsername()) && (password.equals(newdeliveryman.getPassword()))))
            return true;
        else
            return false;
    }





}