package org.acme.rest.json

import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import javax.persistence.Cacheable
import javax.persistence.Column
import javax.persistence.Entity

@Entity
@Cacheable
data class Fruit(
    @Column(length = 40, unique = true)
    var name: String = ""
): PanacheEntity()
