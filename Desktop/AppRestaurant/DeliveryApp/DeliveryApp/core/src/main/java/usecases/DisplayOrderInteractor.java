package usecases;


import datatransferobjects.OrderCreationDTO;
import datatransferobjects.OrderDisplayDTO;
import datatransferobjects.Response;
import entities.Order;
import gateways.IRepository;

import java.util.ArrayList;
import java.util.UUID;

public class DisplayOrderInteractor {

    private IRepository memoryRepository;

    public DisplayOrderInteractor(IRepository memoryRepository) {
        //the services are given through dependency injection
        this.memoryRepository = memoryRepository;
    }

    public Response handle (OrderDisplayDTO request) {
        //implement here the steps and the variations of your use case
        //request is the data transfer object that gives you input from the user
        //Response is the data transfer object that you will fill with information for the user
        // (errors/ messages/ list of entities for display...)
        Order Order = new Order(UUID.randomUUID(), request.Customername, request.address, request.restaurantnumber, request.menunumber,request.creditcard, request.State,request.deliverymanid,request.clientid, request.id);
        //save the new contest to the repository
        //repository is created somewhere else

        memoryRepository.addOrder(Order);

        ArrayList<String> errors = new ArrayList<>();
        //TODO error handling here (as described in the use case)
        return new Response(true, "Please reconnect to do more", errors);
    }



}
