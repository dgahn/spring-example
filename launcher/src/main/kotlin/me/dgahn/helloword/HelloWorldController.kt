package me.dgahn.helloword

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {

    @GetMapping("/hello-world")
    fun getHello(): String {
        return "hello"
    }

    @GetMapping("/hello-world-bean")
    fun helloWorldBean(): HelloWorldBean {
        return HelloWorldBean("Hello World")
    }

    @GetMapping("/hello-world-bean/path-variable/{name}")
    fun helloWorldBean(@PathVariable name: String): HelloWorldBean {
        return HelloWorldBean(String.format("Hello World, %s", name))
    }

}