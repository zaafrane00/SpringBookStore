package com.store.bookstorespring.controllers;

import com.store.bookstorespring.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.store.bookstorespring.entities.Order;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/")
    public Order index(){
        return (Order) orderService.getAllBuyLines();
    }

    @PostMapping("/add")
    public void store(@RequestBody Order order){
        System.out.printf(String.valueOf(order));
        orderService.add(order);
    }
}
