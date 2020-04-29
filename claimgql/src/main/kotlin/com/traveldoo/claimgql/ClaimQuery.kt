package com.traveldoo.claimgql

import com.expediagroup.graphql.annotations.GraphQLDescription
import com.expediagroup.graphql.federation.directives.FieldSet
import com.expediagroup.graphql.federation.directives.KeyDirective
import com.expediagroup.graphql.spring.operations.Query
import org.springframework.stereotype.Component

@Component
class ClaimQuery: Query {

    fun claim() = Claim(1, "ClaimTitle")
}

@KeyDirective(fields = FieldSet("id"))
data class Claim(
        val id: Int,
        @GraphQLDescription("Awesome **title**")
        val title: String
)
