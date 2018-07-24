package com.snonov.explore.restclient;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface ServerClient {

	@RequestLine("GET hello/{name}")
    Greeting getGreeting(@Param("name") String name);

    @RequestLine("POST hello/Greeting")
    @Headers("Content-Type: application/json")
    String sendGreeting(Greeting greeting);
	
    @RequestLine("POST hello/Test/{spaceName}/MyQuery?inputName={inputName}&inputValue={inputValue}&isOk={isOk}")
    void testPost(@Param("spaceName") String spaceName,
    		@Param("inputName") String inputName, 
    		@Param("inputValue") String inputValue, 
    		@Param("isOk") boolean isOk);
    
}
