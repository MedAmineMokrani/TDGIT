import controller.FacadeController;
import controller.OrderCreationController;
import controller.OrderDisplayController;

import entities.Menu;
import entities.Restaurant;
import gateways.IRepository;
import repositories.MemoryRepository;


import javax.xml.stream.FactoryConfigurationError;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {






        IRepository contestRepository = new MemoryRepository();
        OrderCreationController creationController = new OrderCreationController(contestRepository);
        OrderDisplayController DisplayController = new OrderDisplayController(contestRepository);

        FacadeController controllerFacade = new FacadeController(creationController,DisplayController);
        controllerFacade.run();
    }
}
