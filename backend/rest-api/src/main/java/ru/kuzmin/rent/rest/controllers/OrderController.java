package ru.kuzmin.rent.rest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.kuzmin.rent.order.api.OrderClient;
import ru.kuzmin.rent.order.api.entities.OrderApi;
import ru.kuzmin.rent.order.api.exceptions.OrderApiException;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @RequestMapping(method = RequestMethod.POST)
    public CompletableFuture<OrderApi> createOrder(OrderApi order) throws OrderApiException {
        OrderClient client = new OrderClient();
        return client.create(order);
    }
}
