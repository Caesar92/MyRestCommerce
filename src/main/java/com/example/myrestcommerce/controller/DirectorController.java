package com.example.myrestcommerce.controller;


import com.example.myrestcommerce.controller.model.*;
import com.example.myrestcommerce.dao.entity.Director;
import com.example.myrestcommerce.dao.entity.User;
import com.example.myrestcommerce.service.DirectorService;
import com.example.myrestcommerce.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/directors")
public class DirectorController {


    @Inject
    DirectorService directorService;

    // OK - CREATE
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Director director){

        Long result = directorService.create(
                new Director(director.getFirstName(), director.getLastName())
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
        List<DirectorResponse> directorResponses = directorService.fetchAll();

        if(directorResponses.size()==0)
            return Response.status(204).build();
        else
            return Response.ok(directorResponses).build();
    }

    // OK - READ ONE BY ID
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") long id) {
        if(id < 1){
           return Response.status(Response.Status.PRECONDITION_FAILED).entity("Mauvais ID ! Doit etre 1 ou plus").build();
        }

        DirectorResponse directorResponse = directorService.fetchById(id);

        if (directorResponse == null)
            return Response.status(204).build();
        else
            return Response.ok(directorResponse).build();
    }

    // OK - UPDATE
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") long id, UpdateDirector director){
        try{
            directorService.update(id, director);
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
            directorService.delete(id);
            return Response.status(200).build();

        } catch (Exception e){
            return Response.status(Response.Status.PRECONDITION_FAILED).entity(e.getMessage()).build();
        }
    }

}