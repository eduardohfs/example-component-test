package component.test.exemple.resources;

import component.test.exemple.application.commands.FruitCommand;
import component.test.exemple.domain.entities.Fruit;
import component.test.exemple.domain.entities.Nutritions;
import component.test.exemple.domain.exceptions.DiseaseNameException;
import component.test.exemple.domain.exceptions.FruitNotFoundException;
import component.test.exemple.resources.entities.CocoaErrorResponse;
import component.test.exemple.resources.entities.FruitResponse;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/fruit")
public class FruitResource {
    private static final Logger LOG = Logger.getLogger(FruitResource.class);

    private final FruitCommand fruitCommand;

    @Inject
    public FruitResource(FruitCommand fruitCommand) {
        this.fruitCommand = fruitCommand;
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllFruits() {
        LOG.info("Getting all fruits");
        List<Fruit> fruits = fruitCommand.getAllFruits();
        return Response.ok(fruits).build();
    }

    @GET
    @Path("/family")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFruitFamily(@QueryParam("fruitName") String fruitName) {
        LOG.info("Getting fruit family");
        try {
            if (fruitName.equalsIgnoreCase("cocoa")) {
                return Response.accepted(new CocoaErrorResponse("Chocolate debts are paid")).build();
            }
            String fruitFamily = fruitCommand.getFruitFamily(fruitName);
            return Response.ok(new FruitResponse(fruitFamily)).build();
        } catch (FruitNotFoundException e) {
            return Response.status(404).build();
        } catch (DiseaseNameException diseaseNameException) {
            return Response.status(418).build();
        } catch (Exception exception) {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/nutritions")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFruitNutrition(@QueryParam("fruitName") String fruitName) {
        LOG.info("Getting fruit nutritions");
        try {
            Nutritions nutritions = fruitCommand.getFruitNutrition(fruitName);
            return Response.ok(nutritions).build();
        } catch (FruitNotFoundException e) {
            return Response.status(404).build();
        } catch (Exception exception) {
            return Response.serverError().build();
        }
    }
}
