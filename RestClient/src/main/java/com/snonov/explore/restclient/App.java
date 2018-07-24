package com.snonov.explore.restclient;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

/**
 * Hello world!
 *
 */
public class App {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		LOGGER.info("Client main call");
		ServerClient serverClient = Feign.builder()
				  .client(new OkHttpClient())
				  .encoder(new GsonEncoder())
				  .decoder(new GsonDecoder())
				  .logger(new Slf4jLogger(ServerClient.class))
				  .logLevel(feign.Logger.Level.FULL)
				  .target(ServerClient.class, "http://localhost:8080/api/");
		
		LOGGER.info("serverClient.getGreeting");
		Greeting greeting = serverClient.getGreeting("John");
		LOGGER.info(" " + greeting);
		LOGGER.info(" " + greeting.getMessage());
		
		/////////////////////////////////////////////////////////////////////////
		
//		Decoder decoder = new Decoder.Default();
//		Encoder encoder = new Encoder.Default();
//		
//		
//		ServerClient serverClient2 = Feign.builder()
//				  .client(new OkHttpClient())
//				  .encoder(new GsonEncoder())
//				  .decoder(new GsonDecoder())
//				  .logger(new Slf4jLogger(ServerClient.class))
//				  .logLevel(feign.Logger.Level.FULL)
//				  .target(ServerClient.class, "http://localhost:8080/api/");
//		
//		LOGGER.info("serverClient.sendGreeting");
//		String sendGreetingFromServer = serverClient2.sendGreeting(greeting);
//		LOGGER.info("Server response " + sendGreetingFromServer);

		/////////////////////////////////////////////////////////////////////////
		
		ServerClient serverClient3 = Feign.builder()
				  .client(new OkHttpClient())
				  .encoder(new GsonEncoder())
				  .decoder(new GsonDecoder())
				  .logger(new Slf4jLogger(ServerClient.class))
				  .logLevel(feign.Logger.Level.FULL)
				  .target(ServerClient.class, "http://localhost:8080/api/");
		
		LOGGER.info("serverClient.testPost");
		String spaceName = "mySpaceName";
		String inputName = "MyInputName";
		String inputValue = "MyInputValue";
		boolean isOk = false;
		serverClient3.testPost(spaceName, inputName, inputValue, isOk);
		LOGGER.info("Server response ");
		
	}
	
	
	
}
