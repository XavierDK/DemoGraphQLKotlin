package com.traveldoo.expensegql

import com.expediagroup.graphql.annotations.GraphQLDescription
import com.expediagroup.graphql.federation.directives.ExtendsDirective
import com.expediagroup.graphql.federation.directives.ExternalDirective
import com.expediagroup.graphql.federation.directives.FieldSet
import com.expediagroup.graphql.federation.directives.KeyDirective
import com.expediagroup.graphql.federation.execution.FederatedTypeResolver
import graphql.schema.DataFetchingEnvironment


//val expenses: List<Expense> = listOf(ExpenseItem(1, "Titel"), Mileage(2, 150))

@KeyDirective(fields = FieldSet("id"))
@ExtendsDirective
class Claim(@ExternalDirective val id: Int) {
    fun expenses(): List<Expense> {
        return listOf(ExpenseItem(1, "Titel"), Mileage(2, 150))
    }
}

val claimResolver = object : FederatedTypeResolver<Claim> {
    override suspend fun resolve(environment: DataFetchingEnvironment, representations: List<Map<String, Any>>): List<Claim?> = representations.map {
        it["id"]?.toString()?.toIntOrNull()?.let { id ->
            Claim(id)
        }
    }
}


interface Expense {
    val id: Int
}

data class ExpenseItem(
        override val id: Int,
        val title: String
): Expense

data class Mileage(
        override val id: Int,
        val kms: Int
): Expense