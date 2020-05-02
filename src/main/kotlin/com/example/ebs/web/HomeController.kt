package com.example.ebs.web

import com.example.ebs.service.HelloService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping("/")
class HomeController {
    @Autowired
    lateinit var helloService: HelloService

    @GetMapping()
    @ResponseBody
    fun index(): String? {
        return helloService.hello()
    }
}