package com.snonov.explore.restserver.restproduce;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/hello")
@Consumes({MediaType.MULTIPART_FORM_DATA})
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
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public void testPostUrl(@PathParam("spaceName") String spaceName, 
			@FormDataParam("file") InputStream fileInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail,
			@QueryParam("inputName") String inputName,
			@QueryParam("inputValue") String inputValue, 
			@QueryParam("isOk") boolean isOk
			) {

		LOGGER.info("Path param");
		LOGGER.info("spaceName [{}]", spaceName);
		LOGGER.info("Query param");
		LOGGER.info("inputName [{}]", inputName);
		LOGGER.info("inputValue [{}]", inputValue);
		LOGGER.info("isOk [{}]", isOk);

		try {
			String fileLocation = new File(".").getAbsolutePath();
			FileOutputStream out = new FileOutputStream(new File(fileLocation + "//target//UploadedFile.txt"));
			int read = 0;
			byte[] bytes = new byte[1024];
			while ((read = fileInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
			String output = "File UploadedFile.txt successfully uploaded to : " + fileLocation;
			LOGGER.info(output);
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
}
