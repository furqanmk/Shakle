package com.luto

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class ShakleApplication

fun main(args: Array<String>) {
    SpringApplication.run(ShakleApplication::class.java, *args)
}
