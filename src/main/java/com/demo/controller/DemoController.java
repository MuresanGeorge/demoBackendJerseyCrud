package com.demo.controller;

import com.demo.commons.dto.CreateUserDTO;
import com.demo.services.DemoService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/demo")
public class DemoController {
    private DemoService demoService;

    public DemoController() {
        demoService = new DemoService();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/user")
    public Response createUser(CreateUserDTO createUserDTO) {
        return Response.status(201).entity(demoService.createUser(createUserDTO)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/userCountry")
    public Response getAllUsers() {
        return Response.status(200).entity(demoService.getAllUsers()).build();
    }

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello";
    }

}
