package com.traveldoo.expensegql

import com.expediagroup.graphql.federation.execution.FederatedTypeRegistry
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class ExpensegqlApplication {
	@Bean
	fun federatedTypeRegistry() = FederatedTypeRegistry(mapOf("Claim" to claimResolver))
}

fun main(args: Array<String>) {
	runApplication<ExpensegqlApplication>(*args)
}
