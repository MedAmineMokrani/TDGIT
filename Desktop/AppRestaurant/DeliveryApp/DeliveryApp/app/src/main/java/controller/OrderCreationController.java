package controller;


import datatransferobjects.OrderCreationDTO;
import entities.Menu;
import entities.Restaurant;
import gateways.IRepository;
import repositories.Authentification;
import repositories.CreditCardValidator;

import usecases.CreateOrderInteractor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class OrderCreationController {


    public String name;
    public String address;
    public int restaurantid;
    public int menuid;
    public Long creditcard;
    public int paymentmethod;

    public String state = "AwaitingDelivery";
    public int deliverymanid = 1;
    public int clientid;
    public int orderid = 1;
    public UUID orderNumber;
    IRepository IRepository;

    //this controller works with a contestRepository;
    //because we have a memory repository, we must initialize it
    // outside the controller, otherwise its state is lost
    public OrderCreationController(IRepository contestRepository) {
        this.IRepository = contestRepository;
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






        //login




        Scanner input1 = new Scanner(System.in);
        System.out.println("Please enter you username : ");
        String username = input1.next();

        Scanner input2 = new Scanner(System.in);
        System.out.println("Please enter you password : ");
        String password = input2.next();
        Authentification login = new Authentification(username, password);

        //Creating order

        if (login.checkPasswordCustomer()) {
            System.out.println("Press 1 to place an order");
            System.out.println("Press 2 available restaurant");
            System.out.println("Press 3 to see your orders");


            //Asking user to make choice
            System.out.println("Make your choice");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:


                    Scanner inputname = new Scanner(System.in);
                    System.out.println("Please enter your name : ");
                    name = inputname.next();


                    Scanner inputaddress = new Scanner(System.in);
                    System.out.println("Please enter your address : ");
                    address = inputaddress.next();

                    System.out.println("Here is the list of available restaurant");
                    System.out.println("1 - PizzaMaster press  1");
                    System.out.println("2 - PastaCosi press 2");

                    Scanner inputrestaurantnumber = new Scanner(System.in);
                    System.out.println("Please enter restaurant number  : ");
                    restaurantid = inputrestaurantnumber.nextInt();

                    IRepository.DisplayRestaurantMenu(restaurantid);

                    System.out.println("Here is the list of available menu");

                    Scanner inputmenu = new Scanner(System.in);
                    System.out.println("Please enter menu ID  : ");
                    menuid = inputmenu.nextInt();

                    Scanner inputdeliverymethod = new Scanner(System.in);
                    System.out.println("Please choose your delivery method  : ");
                    System.out.println("1 - Pay by card ");
                    System.out.println("2 - Pay on delivery ");
                    paymentmethod = inputdeliverymethod.nextInt();

                    if (paymentmethod == 1) {
                        Scanner inputcreditcard = new Scanner(System.in);
                        System.out.println("Please your creditcard number  : ");
                        creditcard = inputcreditcard.nextLong();

                        CreditCardValidator creditCardValidator = new CreditCardValidator();
                        boolean isvalid = creditCardValidator.isValid(creditcard);
                        if (isvalid == false) {
                            System.out.println("Please login again and  enter a correct credit card number");

                        }

                    }




                    break;
                case 2:
                    IRepository.displayallRestaurant();

                case 3:
                    IRepository.displayclientorder();

                default:
                    System.out.println("Invalid choice!!! Please make a valid choice. \\n\\n");

            }


        } else {
            System.out.println("The username and password you entered are incorrect."); }








                    //default case to display the message invalid choice made by the user




            //*************************************************************************************************
            // connecting the app with the Use Case Interactor
            //*************************************************************************************************
            // 1. create the request message passing with the target student id and a list of selected contest codes

            var useCaseRequestMessage = new OrderCreationDTO(name, address, restaurantid, menuid,creditcard,paymentmethod,state,deliverymanid,login.getNewcustomer().getId(),orderid++);

            // 2. instantiate Contest Registration Use Case injecting gateways
            //the repository cannot be instantiated here because it would be emptied at each user input
            //so I put it as a private attribute and instantiate it in main
            var OrderCreationRequestUseCase = new CreateOrderInteractor(IRepository);


            // 3. call the use case and store the response
            var responseMessage = OrderCreationRequestUseCase.handle(useCaseRequestMessage);

            //display the response
            System.out.println(responseMessage.getMessage());
            // 4. use a Presenter to format the use case response and display it
            // Presenter also displays to its associated view



    }

}

