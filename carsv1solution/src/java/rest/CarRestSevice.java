package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Car;
import facade.Facade;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("car")
public class CarRestSevice {

    @Context
    private UriInfo context;

    Facade facade = new Facade();
    Gson gson;

    public CarRestSevice() {
        gson = new GsonBuilder().setPrettyPrinting().create();

    }

    @GET
    @Produces("application/json")
    public Response getJson() {
        List<Car> groups = facade.getCars();
        Response.ResponseBuilder response = Response.ok(gson.toJson(groups));
        return response.build();
    }
    
    
}
