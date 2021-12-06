package com.example.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

data class HelloResponse(val message: String)

data class HelloRequest(val name: String)

@RestController
@RequestMapping("greeter")
class GreeterController {
    // $ curl http://localhost:8080/greeter/hello?name=Izacchi
    @GetMapping("/hello")
    fun hello(@RequestParam("name") name: String): HelloResponse {
        return HelloResponse("Hello $name")
    }

    // $ curl http://localhost:8080/greeter/hello/Izacchi
    @GetMapping("/hello/{name}")
    fun helloPathValue(@PathVariable("name") name: String): HelloResponse {
        return HelloResponse("Hello $name")
    }

    // $ curl -H 'Content-Type:application/json' -X POST -d '{"name":"Izacchi"}' http://localhost:8080/greeter/hello
    @PostMapping("/hello")
    fun helloByPost(@RequestBody request: HelloRequest): HelloResponse {
        return HelloResponse("Hello ${request.name}")
    }
}