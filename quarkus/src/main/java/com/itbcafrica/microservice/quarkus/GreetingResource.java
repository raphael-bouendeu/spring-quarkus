package com.itbcafrica.microservice.quarkus;

import com.itbcafrica.microservice.quarkus.model.GreetingResponse;
import com.itbcafrica.microservice.quarkus.service.GreetingService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource{

    private  final GreetingService greetingService;

    public GreetingResource(GreetingService greetingService){
        this.greetingService=greetingService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public GreetingResponse hello() {
        return greetingService.getGreeting();
    }
}