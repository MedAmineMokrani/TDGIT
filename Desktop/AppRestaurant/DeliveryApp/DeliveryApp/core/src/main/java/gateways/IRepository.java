package gateways;

import entities.Menu;
import entities.Order;
import entities.Restaurant;

import java.util.List;

public interface IRepository {

    void addOrder(Order order);


    Order displayclientorder();

    Menu displayallMenu();

    Restaurant displayallRestaurant();

    void addMenu (Menu menu);

    void addRestaurant(Restaurant restaurant);

    List<Order> displayWaitingOrders();

    List<Menu> DisplayRestaurantMenu(int restaurantnumber);
    List<Order> ChangeOrderState(int id);
    List<Order> displayallOrders();
    List<Order> displayDeliveredOrders();





}
