package com.microservices.chapter11

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.ConcurrentHashMap

@RestController
class CustomerController{
    companion object {
        val initialCustomers = arrayOf(
                Customer(1, "Kotlin"),
                Customer(2, "Spring"),
                Customer(3, "Microservices")
        )
        val customers = ConcurrentHashMap(initialCustomers.associateBy { it.id })
    }
    @GetMapping("/customers")
    fun getCustomers() = customers.values.toList()
    @GetMapping("/customer/{id}")
    fun getCustomer(@PathVariable id: Int) = customers[id]
}