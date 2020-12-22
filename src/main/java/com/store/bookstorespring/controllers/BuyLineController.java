package com.store.bookstorespring.controllers;

import com.store.bookstorespring.entities.BuyLine;
import com.store.bookstorespring.services.BuyLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order/line")
public class BuyLineController {

    @Autowired
    BuyLineService orderLineService;

    @GetMapping("/")
    public void getBuyLines() {
        orderLineService.getAllBuyLines();
    }

    @PostMapping("/add/user/{user_id}/book/{book_id}")
    public void store(@PathVariable Long user_id, @PathVariable long book_id, @RequestBody BuyLine buyLine) throws Exception {
        orderLineService.addBuyLine(user_id, book_id, buyLine);
    }
}
