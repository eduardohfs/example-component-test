package component.test.exemple.infrastructure.fruit.gateways;

import component.test.exemple.infrastructure.fruit.domain.FruitResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/fruit")
@RegisterRestClient(configKey = "services.fruit.base-url")
public interface FruitGateway {

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    List<FruitResponse> getAllFruits();

    @GET
    @Path("/{fruitName}")
    @Produces(MediaType.APPLICATION_JSON)
    FruitResponse getFruitFamily(@PathParam("fruitName") String fruitFamily);
}
