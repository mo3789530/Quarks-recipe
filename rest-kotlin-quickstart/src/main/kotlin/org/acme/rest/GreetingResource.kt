package org.acme.rest

import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@ApplicationScoped
class GreetingService {
    fun greeting(name: String): String {
        return "Hello  $name"
    }
}

@Path("/greeting")
class GreetingResource(
    @Inject
    private val greetingService: GreetingService
){

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello() = "Hi"

    @GET
    @Path("/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    fun helloName(@PathParam("name") name: String) = greetingService.greeting(name)
}
