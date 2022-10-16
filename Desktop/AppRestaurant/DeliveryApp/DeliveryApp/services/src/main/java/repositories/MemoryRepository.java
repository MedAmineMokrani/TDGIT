package repositories;


import entities.Menu;
import entities.Order;
import entities.Restaurant;
import gateways.IRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class MemoryRepository implements IRepository {


    private List<Order>  Order = new ArrayList<>();

    private List<Menu> MenuItems = new ArrayList<>();

    private List<Restaurant> RestaurantItems = new ArrayList<>();





    public void addMenu(Menu menu) {
        MenuItems.add(menu);
    }

    public void addRestaurant(Restaurant restaurant) {
        RestaurantItems.add(restaurant);
    }





    public void addOrder(Order order) {
        Order.add(order);
    }



    public Order displayclientorder() {
        System.out.println(Order.stream()
                .filter(p -> p.getClientid() == 1 && p.getRestaurantnumber() != 0 ).collect(Collectors.toList()));
        return null;
    }

    public Menu displayallMenu() {
        for (Menu m : MenuItems) {
            System.out.println(m);
        }

        return null;
    }

    public Restaurant displayallRestaurant() {
        for (Restaurant r : RestaurantItems) {
            System.out.println(r);
        }

        return null;
    }
    public List<Order> displayallOrders() {
        System.out.println(Order.stream()
                .filter(p -> p.getDeliverymanid() == 1 && p.getRestaurantnumber() != 0).collect(Collectors.toList()));

        return null;
    }
    public List<Order> displayWaitingOrders() {
        System.out.println(Order.stream()
                .filter(p -> p.getState() == "AwaitingDelivery" && p.getDeliverymanid() == 1 && p.getRestaurantnumber() != 0).collect(Collectors.toList()));

        return null;
    }
    public List<Order> displayDeliveredOrders() {
        System.out.println(Order.stream()
                .filter(p -> p.getState() == "Delivered" && p.getDeliverymanid() == 1 && p.getRestaurantnumber() != 0).collect(Collectors.toList()));

        return null;
    }

    public List<Menu> DisplayRestaurantMenu(int restaurantid) {
        System.out.println(MenuItems.stream()
                .filter(p -> p.getRestaurantid() == restaurantid ).collect(Collectors.toList()));

        return null;
    }
    public List<Order> ChangeOrderState(int id) {

        List<Order> changestate = Order.stream().filter(p -> p.getOrderid() == id ).collect(Collectors.toList());

          Order.forEach(obj->{
            changestate.forEach(o-> {
                if(o.getState() == "AwaitingDelivery" && o.getOrderid() ==  obj.getOrderid() && o.getClientid() != 0 && o.getDeliverymanid() == 1) {
                    o.setState("Delivered");
                }
            });

        });
          System.out.println(changestate.toString());


        return null;
    }



}
