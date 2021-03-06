package com.demo.service;


import org.springframework.stereotype.Service;


// Buisness Logic
@Service
public class DemoServiceImpl implements DemoService{

    @Override
    public String getHelloMessage(String user) {
        return "Hello " + user;
    }

    @Override
    public String getWelcomeMessage() {
        return "Welcome to this Demo app";
    }
}
