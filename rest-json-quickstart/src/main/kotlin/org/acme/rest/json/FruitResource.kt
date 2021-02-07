package org.acme.rest.json

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;


@Path("/fruits")
class FruitResource {

    private val fruits: MutableSet<Fruit> = mutableSetOf<Fruit>()
    @GET
    fun list(): Set<Fruit> {
        return fruits
    }

    @POST
    fun add(fruit: Fruit?): Set<Fruit> {
        if (fruit != null) {
            fruits.add(fruit)
        }
        return fruits
    }

    @DELETE
    fun delete(fruit: Fruit): Set<Fruit> {
        fruits.removeIf { existingFruit -> existingFruit.name.contentEquals(fruit.name) }
        return fruits
    }

    init {
        fruits.add(Fruit("Apple", "Winter fruit"))
        fruits.add(Fruit("Pineapple", "Tropical fruit"))
    }
}
