package com.demo.controller;

import com.demo.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

// controller is a special type of component annotation
@Slf4j
@Controller
public class DemoController {

    private final DemoService demoService;

    // == constructor ==
    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

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
    public String welcome(Model model) {
        model.addAttribute("helloMessage", demoService.getHelloMessage("Tim"));
        log.info("model= {}", model);
        // "welcome" is a view name: ie jsp file
        // WEB-INF/view/welcome.jsp will be generated
        return "welcome";
    }

    // == model attributes ==
    @ModelAttribute("welcomeMessage")
    public String welcomeMessage() {
        log.info("welcomeMessage() called");
        return demoService.getWelcomeMessage();
    }
}
