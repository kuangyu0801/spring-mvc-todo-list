package com.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

// import spring mvc configuration
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.demo")
public class WebConfig {
}
