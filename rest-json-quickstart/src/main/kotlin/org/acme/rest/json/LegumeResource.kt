package org.acme.rest.json

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/legume")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class LegumeResource {
    private val legumes: MutableSet<Legume> = mutableSetOf<Legume>()

    @GET
    fun list(): Response? {
        return Response.ok(legumes).build()
    }

    init {
        legumes.add(Legume("Carrot", "Root vegetable, usually orange"))
        legumes.add(Legume("Zucchini", "Summer squash"))
    }
}
