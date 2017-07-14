package com.luto

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.model.ScanRequest
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by furqan on 07/07/2017.
 */

@RestController
class Router(val repository: UserRepository, val dynamoDB: AmazonDynamoDB) {
    @RequestMapping("/ping")
    fun ping(): String {
        return "Server Okay!"
    }

    @RequestMapping("/bio")
    fun findByName () {
        try {
            val users = repository.findAll()
            print (users)

        } catch (exception: Exception) {
            val results = dynamoDB.scan(ScanRequest().withTableName("Bio"))
            print (results.items)
            throw exception
        }
    }
}
