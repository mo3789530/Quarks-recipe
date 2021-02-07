package org.acme.rest.json

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import org.acme.rest.json.Fruit
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class FruitRepository : PanacheRepository<Fruit> {
}
