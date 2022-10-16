package controller;


import datatransferobjects.OrderCreationDTO;
import datatransferobjects.OrderDisplayDTO;
import entities.Menu;
import entities.Order;
import entities.Restaurant;
import gateways.IRepository;
import repositories.Authentification;
import repositories.CreditCardValidator;

import usecases.CreateOrderInteractor;
import usecases.DisplayOrderInteractor;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class OrderDisplayController {



    public String name;
    public String address;
    public int restaurantnumber;
    public int menunumber;
    public Long creditcard;
    public int paymentmethod;

    public String State;
    public int deliverymanid;
    private int id= 0;





    IRepository IRepository;
    //this controller works with a contestRepository;
    //because we have a memory repository, we must initialize it
    // outside the controller, otherwise its state is lost
    public OrderDisplayController(IRepository OrderRepository) {
        this.IRepository = OrderRepository;
    }


    public void run() {
        //Declaring all variables
        int a, b, c;
        int choice;

        // Restaurants initialization
        IRepository.addRestaurant(new Restaurant(1, "PizzaMaster", "Paris"));
        IRepository.addRestaurant(new Restaurant(2, "PastaCosi", "Lyon"));

        // Restaurant 1 Menu initialization
        IRepository.addMenu(new Menu(1, 1, "pizzza", 10));
        IRepository.addMenu(new Menu(2, 1, "spaghetti", 10));

        // Restaurant 2 Menu initialization
        IRepository.addMenu(new Menu(3, 2, "Tagliatelles", 10));
        IRepository.addMenu(new Menu(4, 2, "Burger", 10));









        Scanner scanner = new Scanner(System.in);
        //Creating infinite while loop


                //First case for finding the addition

                    Scanner inputusername = new Scanner(System.in);
                    System.out.println("Please enter you username !: ");
                    String deliverymanusername = inputusername.next();

                    Scanner inputpassword = new Scanner(System.in);
                    System.out.println("Please enter you password : ");
                    String deliverymanpassw = inputpassword.next();


                    Authentification logindeliveryman = new Authentification(deliverymanusername, deliverymanpassw);
                    if (logindeliveryman.checkPasswordDeliveryMan()) {
                        System.out.println("Press 1 to check all available Orders");
                        System.out.println("Press 2 to display Awaiting Orders");
                        System.out.println("Press 3 to display Delivered Orders");
                        System.out.println("Press 4 Update order State to Delivered");



                        //Asking user to make choice
                        System.out.println("Make your choice");
                        choice = scanner.nextInt();
                        switch (choice) {
                            case 1:


                                IRepository.displayallOrders();



                                break;

                            case 2:
                                IRepository.displayWaitingOrders();
                                break;

                            case 3:
                                IRepository.displayDeliveredOrders();
                                break;

                            case 4:
                                IRepository.displayWaitingOrders();


                                Scanner inputorder = new Scanner(System.in);
                                System.out.println("Please enter your order id to change to delivered : ");
                                int OrderIdToUpdate = inputorder.nextInt();
                                IRepository.ChangeOrderState(OrderIdToUpdate);

                                System.out.println("Order number : " + OrderIdToUpdate + " State has been changed to delivered ");
                                break;

                        }



                    } else
                        System.out.println("The username and password you entered are incorrect.");







            //*************************************************************************************************
            // connecting the app with the Use Case Interactor
            //*************************************************************************************************
            // 1. create the request message passing with the target student id and a list of selected contest codes

            var useCaseRequestMessage = new OrderDisplayDTO(name, address, restaurantnumber, menunumber,creditcard,paymentmethod,State,deliverymanid,id);

            // 2. instantiate Contest Registration Use Case injecting gateways
            //the repository cannot be instantiated here because it would be emptied at each user input
            //so I put it as a private attribute and instantiate it in main
            var OrderDisplayRequestUseCase = new DisplayOrderInteractor(IRepository);


            // 3. call the use case and store the response
            var responseMessage = OrderDisplayRequestUseCase.handle(useCaseRequestMessage);

            //display the response
            System.out.println(responseMessage.getMessage());
            // 4. use a Presenter to format the use case response and display it
            // Presenter also displays to its associated view


        }
    }


