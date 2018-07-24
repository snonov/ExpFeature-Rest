package com.snonov.explore.restclient;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import feign.form.FormData;

public interface ServerClient {

	@RequestLine("GET hello/{name}")
    Greeting getGreeting(@Param("name") String name);

    @RequestLine("POST hello/Greeting")
    @Headers("Content-Type: application/json")
    String sendGreeting(Greeting greeting);
	
    @RequestLine("POST hello/Test/{spaceName}/MyQuery?inputName={inputName}&inputValue={inputValue}&isOk={isOk}")
    @Headers("Content-Type: multipart/form-data")
    void testPost(@Param("spaceName") String spaceName,
    		@Param("file") FormData file,
    		@Param("inputName") String inputName, 
    		@Param("inputValue") String inputValue, 
    		@Param("isOk") boolean isOk    		
    		);
    
}
