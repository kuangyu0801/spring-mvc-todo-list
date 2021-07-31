package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// controller is a special type of component annotation
@Controller
public class DemoController {

    // http://localhost:8080/todo-list-mvc/hello
    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        // "hello" is a view name
        return "hello";
    }
}
