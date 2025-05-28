package org.swenbe.kotlinpractice

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller {

    @GetMapping("/")
    fun index(
        @RequestParam("name") name: String
    ) = "Hello $name!"
}