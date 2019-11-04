package com.learnjooq.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveryController {



    @PostMapping("/v1/delivery")
    public ResponseEntity<?> createDelivery(){

        return null;
    }
}
