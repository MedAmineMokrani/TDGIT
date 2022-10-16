package controller;

import java.util.Scanner;

public class FacadeController {

    OrderCreationController orderCreationController;
    OrderDisplayController  orderDisplayController;

    public FacadeController(OrderCreationController orderCreationController, OrderDisplayController orderDisplayController) {
        this.orderCreationController = orderCreationController;
        this.orderDisplayController = orderDisplayController;
    }

    public void run()  {
        //get user input

        String userInput;
        do
        {
            System.out.println("Select one operation (1 or 2) or quit:");
            System.out.println("1. Customer login");
            System.out.println("2. Delivery man login");
            System.out.println("Make your choice");

            Scanner sc = new Scanner(System.in);
            userInput = sc.nextLine();

            switch (userInput) {
                case "1":
                    orderCreationController.run();
                    break;
                case "2":
                    orderDisplayController.run();
                    break;

                case "quit":
                    break;
            }

        } while (!userInput.equals("quit"));
    }
}

