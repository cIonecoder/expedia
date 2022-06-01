package com.expedia.b2b.application.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccommodationController {
    @PostMapping("/")
    public String test() {
        return "";
    }
}
