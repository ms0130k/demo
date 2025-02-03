package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    @Value("${greeting-name: Mirage}")
    private String name;

    @Value("${greeting-coffee: ${greeting-name} is drinking coffee}")
    private String coffee;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Object greeting() {
        return name;
    }

    @GetMapping(value = "2", produces = MediaType.TEXT_PLAIN_VALUE)
    public Object greeting2() {
        return Map.of("name", name);
    }

    @GetMapping("/coffee")
    public Object coffee() {
        return coffee;
    }
}
