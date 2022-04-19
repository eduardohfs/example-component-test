package component.test.exemple.application.commands;

import component.test.exemple.domain.entities.Fruit;
import component.test.exemple.domain.entities.Nutritions;
import component.test.exemple.domain.exceptions.DiseaseNameException;
import component.test.exemple.domain.exceptions.FruitNotFoundException;
import component.test.exemple.infrastructure.fruit.impl.FruitGatewayImpl;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Singleton
public class FruitCommand {
    private static final Logger LOG = Logger.getLogger(FruitCommand.class);

    private final FruitGatewayImpl fruitGatewayImpl;

    @Inject
    public FruitCommand(FruitGatewayImpl fruitGatewayImpl) {
        this.fruitGatewayImpl = fruitGatewayImpl;
    }

    public List<Fruit> getAllFruits() {
        try {
            List<Fruit> response = fruitGatewayImpl.getAllFruits();
            response.sort(Comparator.comparing(Fruit::getName));

            return response;
        } catch (Exception e) {
            LOG.error("Error ", e);
            return Collections.emptyList();
        }
    }

    public String getFruitFamily(String fruitName) throws DiseaseNameException, FruitNotFoundException {
        Fruit fruit = fruitGatewayImpl.getFruitFamily(fruitName);
        if (fruit.getFamily().equals("Anacardiaceae")) {
            throw new DiseaseNameException("This name is not from fruit family");
        }
        return fruit.getFamily();
    }

    public Nutritions getFruitNutrition(String fruitName) throws DiseaseNameException, FruitNotFoundException {
        return fruitGatewayImpl.getFruitNutritions(fruitName);
    }
}
