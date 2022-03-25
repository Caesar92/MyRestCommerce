package com.example.myrestcommerce.controller;


import com.example.myrestcommerce.controller.model.CreateUser;
import com.example.myrestcommerce.controller.model.UpdateUser;
import com.example.myrestcommerce.controller.model.UserResponse;
import com.example.myrestcommerce.dao.entity.User;
import com.example.myrestcommerce.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
public class UserController {


    @Inject
    UserService userService;

    // OK - CREATE
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(CreateUser user){

        System.out.println(user);

        Long result = userService.create(
                new User(user.getFirstName(), user.getLastName(), user.isSusbrib())
        );

        if(result != null)
            return Response.status(201).build();
        else
            return Response.status(400).build();
    }

    // OK - READ ALL
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<UserResponse> userResponses = userService.fetchAll();

        if(userResponses.size()==0)
            return Response.status(204).build();
        else
            return Response.ok(userResponses).build();
    }

    // OK - READ ONE BY ID
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") long id) {
        if(id < 1){
           return Response.status(Response.Status.PRECONDITION_FAILED).entity("Mauvais ID ! Doit etre 1 ou plus").build();
        }

        UserResponse userResponse = userService.fetchById(id);

        if (userResponse == null)
            return Response.status(204).build();
        else
            return Response.ok(userResponse).build();
    }

    // OK - UPDATE
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") long id, UpdateUser user){
        try{
            userService.update(id, user);
            return Response.status(200).build();
        }
        catch (Exception e){
            return Response.status(Response.Status.PRECONDITION_FAILED).entity(e.getMessage()).build();
        }
    }


    // OK - DELETE
    @Path("/{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") long id){
        if(id < 1){
            return Response.status(Response.Status.PRECONDITION_FAILED).entity("Mauvais ID ! Doit etre 1 ou plus").build();
        }
        try {
            userService.delete(id);
            return Response.status(200).build();

        } catch (Exception e){
            return Response.status(Response.Status.PRECONDITION_FAILED).entity(e.getMessage()).build();
        }
    }

}