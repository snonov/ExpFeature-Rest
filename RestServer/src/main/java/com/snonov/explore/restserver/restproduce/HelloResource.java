package com.snonov.explore.restserver.restproduce;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/hello")
public class HelloResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(HelloResource.class);
	
    @GET
    @Path("/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Greeting hello(@PathParam("param") String name) {
        return new Greeting(name);
    }

    @POST
    @Path("/Greeting")
    @Produces(MediaType.APPLICATION_JSON)
    public String helloUsingJson(Greeting greeting) {
        return greeting.getMessage() + "\n";
    }
    
    @POST
    @Path("/Test/{spaceName}/MyQuery")
    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes({MediaType.MULTIPART_FORM_DATA})
    public void testPostUrl(@PathParam("spaceName") String spaceName,
    		@QueryParam("inputName") String inputName, @QueryParam("inputValue") String inputValue, 
    		@QueryParam("isOk") boolean isOk) {
//    		,
//    		@FormDataParam("file") InputStream fileInputStream,
//            @FormDataParam("file") FormDataContentDisposition fileDetail) {
    	
    	LOGGER.info("Path param");
    	LOGGER.info("spaceName [{}]", spaceName);
    	LOGGER.info("Query param");
    	LOGGER.info("inputName [{}]", inputName);
    	LOGGER.info("inputValue [{}]", inputValue);
    	LOGGER.info("isOk [{}]", isOk);

    }
}
