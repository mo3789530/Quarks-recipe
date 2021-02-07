package org.acme.rest.json

import javax.enterprise.context.ApplicationScoped
import javax.transaction.Transactional
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/fruits")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
class FruitResource(val fruitRepository: FruitRepository) {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello() = "Hello RESTEasy"

    @POST
    @Transactional
    fun add(fruit: Fruit): Response {
        fruitRepository.persist(fruit)
        return Response.ok(fruit).status(201).build()
    }

    @GET
    fun findAll(): List<Fruit> = fruitRepository.listAll()

    @GET
    @Path("/{id}")
    fun findById(@PathParam("id") id: Long): Fruit? = fruitRepository.findById(id)
}
