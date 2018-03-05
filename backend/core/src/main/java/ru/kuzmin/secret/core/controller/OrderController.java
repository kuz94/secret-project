package ru.kuzmin.secret.core.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @RequestMapping(method = RequestMethod.POST)
    public void createOrder() {

    }
}
