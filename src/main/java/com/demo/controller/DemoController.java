package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// controller is a special type of component annotation
@Controller
public class DemoController {

    // http://localhost:8080/todo-list-mvc/hello
    // using pure text as html body
    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        // "hello" is a body content
        return "hello";
    }

    // http://localhost:8080/todo-list-mvc/welcome
    @GetMapping("welcome")
    public String welcome() {
        // "welcome" is a view name: ie jsp file
        // WEB-INF/view/welcome.jsp will be generated
        return "welcome";
    }
}
