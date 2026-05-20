package it.esempio.rest;

import it.esempio.model.Cittadino;
import it.esempio.service.CittadinoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/anagrafe/api/cittadini") // Path identico al monolite per non rompere Angular
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CittadinoResource {

    @Inject
    CittadinoService service;

    @GET
    public List<Cittadino> getAll() {
        return service.findAll();
    }

    @POST
    public Response create(Cittadino cittadino) {
        Cittadino creato = service.create(cittadino);
        return Response.status(Response.Status.CREATED).entity(creato).build();
    }
}