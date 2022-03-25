package com.example.myrestcommerce.controller;

import com.example.myrestcommerce.controller.model.MovieResponse;
import com.example.myrestcommerce.controller.model.UpdateMovie;
import com.example.myrestcommerce.dao.DaoFactory;
import com.example.myrestcommerce.dao.base.MovieDao;
import com.example.myrestcommerce.controller.model.CreateMovie;
import com.example.myrestcommerce.dao.entity.Movie;
import com.example.myrestcommerce.service.MovieService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/movies")
public class MovieController {

    private static List<Movie> movies = new ArrayList<>();
    private static MovieDao movieDao = DaoFactory.getMovieDao();

    @Inject
    MovieService movieService;

    // OK - CREATE
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(CreateMovie createMovie){
        Movie m = new Movie(createMovie.getTitle(), createMovie.getDuration(), createMovie.getReleaseDate());
        m.setDirector(createMovie.getDirector());
        m.setUser(createMovie.getUser());

        Long result = movieService.create(m);

        if(result != null)
            return Response.status(201).build();
        else
            return Response.status(400).build();
    }

    // OK - READ ALL
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<MovieResponse> movieResponses = movieService.fetchAll();

        if(movieResponses.size()==0)
            return Response.status(204).build();
        else
            return Response.ok(movieResponses).build();
    }

    // OK - READ ONE BY ID
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") long id) {
        if(id < 1){
           return Response.status(Response.Status.PRECONDITION_FAILED).entity("Mauvais ID ! Doit etre 1 ou plus").build();
        }

        MovieResponse movieResponse = movieService.fetchById(id);

        if (movieResponse == null)
            return Response.status(204).build();
        else
            return Response.ok(movieResponse).build();
    }

    // OK - UPDATE
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") long id, UpdateMovie updateMovie){
        try{
            Movie m = new Movie();
            movieService.update(id, updateMovie);
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
            movieService.delete(id);
            return Response.status(200).build();

        } catch (Exception e){
            return Response.status(Response.Status.PRECONDITION_FAILED).entity(e.getMessage()).build();
        }
    }

}