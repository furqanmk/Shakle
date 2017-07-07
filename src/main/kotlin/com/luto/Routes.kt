package com.luto

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by furqan on 07/07/2017.
 */

@RestController
class Router {
    @RequestMapping("/ping")
    fun ping(): String {
        return "Server Okay!"
    }
}