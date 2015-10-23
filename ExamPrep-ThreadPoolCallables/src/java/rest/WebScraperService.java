package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Group;
import facade.WebScraperFacade;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

/**
 * REST Web Service
 *
 * @author Jonas
 */
@Path("url")
public class WebScraperService {

    @Context
    private UriInfo context;

    private final WebScraperFacade facade = new WebScraperFacade();
    private final Gson gson;

    /**
     * Creates a new instance of WebScraperService
     */
    public WebScraperService() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    /**
     * Retrieves representation of an instance of rest.WebScraperService
     *
     * @return an instance of java.lang.String
     * @throws java.lang.InterruptedException
     * @throws java.util.concurrent.ExecutionException
     */
    @GET
    @Produces("application/json")
    public Response getJson() throws InterruptedException, ExecutionException {
        List<Group> groups = facade.getGroups();

        CacheControl cc = new CacheControl();
        cc.setMaxAge(60 * 60);

        ResponseBuilder response = Response.ok(gson.toJson(groups));

        response.cacheControl(cc);
        return response.build();
    }

}
