package component.test.exemple.infrastructure.fruit.impl;

import component.test.exemple.domain.entities.Fruit;
import component.test.exemple.domain.entities.Nutritions;
import component.test.exemple.domain.exceptions.ApiException;
import component.test.exemple.domain.exceptions.FruitNotFoundException;
import component.test.exemple.infrastructure.fruit.domain.FruitResponse;
import component.test.exemple.infrastructure.fruit.gateways.FruitGateway;
import component.test.exemple.infrastructure.fruit.mappers.FruitMapper;
import component.test.exemple.infrastructure.fruit.mappers.NutritionMapper;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import org.jboss.resteasy.client.exception.ResteasyWebApplicationException;
import org.mapstruct.factory.Mappers;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class FruitGatewayImpl {
    private static final Logger LOG = Logger.getLogger(FruitGatewayImpl.class);
    private static final String NOT_FOUND_ERROR_MESSAGE = "Fruit not found";

    private final FruitGateway fruitGateway;

    private final FruitMapper fruitMapper = Mappers.getMapper(FruitMapper.class);
    private final NutritionMapper nutritionMapper = Mappers.getMapper(NutritionMapper.class);

    @Inject
    public FruitGatewayImpl(@RestClient FruitGateway fruitGateway) {
        this.fruitGateway = fruitGateway;
    }

    public List<Fruit> getAllFruits() {
        List<FruitResponse> fruitResponses = fruitGateway.getAllFruits();
        return fruitMapper.toFruitList(fruitResponses);
    }

    public Fruit getFruitFamily(String fruitName) throws FruitNotFoundException {
        try {
            FruitResponse fruitResponse = fruitGateway.getFruitFamily(fruitName);
            return fruitMapper.toFruit(fruitResponse);
        } catch (ResteasyWebApplicationException notFoundException) {
            if (notFoundException.getResponse().getStatus() == 404) {
                LOG.error(NOT_FOUND_ERROR_MESSAGE);
                throw new FruitNotFoundException(NOT_FOUND_ERROR_MESSAGE);
            }
            throw new ApiException("API Error");
        }
    }

    public Nutritions getFruitNutritions(String fruitName) throws FruitNotFoundException {
        try {
            FruitResponse fruitResponse = fruitGateway.getFruitFamily(fruitName);
            return nutritionMapper.toNutrition(fruitResponse.getNutritions());
        } catch (ResteasyWebApplicationException notFoundException) {
            LOG.error(NOT_FOUND_ERROR_MESSAGE);
            throw new FruitNotFoundException(NOT_FOUND_ERROR_MESSAGE);
        }
    }
}
