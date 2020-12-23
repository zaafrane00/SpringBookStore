package com.store.bookstorespring.controllers;

import com.store.bookstorespring.repositories.BookRepository;
import com.store.bookstorespring.repositories.BuyLineRepository;
import com.store.bookstorespring.repositories.OrderRepository;
import com.store.bookstorespring.repositories.UserRepository;
import com.store.bookstorespring.services.OrderService;
import com.store.bookstorespring.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/order/line")
public class BuyLineController {

    @Autowired
    OrderService orderLineService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    BuyLineRepository buyLineRepository;

    @GetMapping("/")
    public void getBuyLines() {
        orderLineService.getAllBuyLines();
    }

    @Transactional
    @PostMapping("/add/orderLine/{idOrder}/client/{client_id}/book/{book_id}")
    public void createOrder(@PathVariable Long idOrder, @PathVariable Long client_id,@PathVariable Long book_id){
        Optional<Order> order = orderRepository.findById(idOrder);
       // System.err.println(order.isPresent() + "//"+order.get());
        Book book = bookRepository.findById(book_id).orElseThrow(()->{
            return new RuntimeException("book not found");
        });
        if(!order.isPresent()){
            Order newOrder=new Order();
            List<BuyLine> buyLineList = new ArrayList<>();
            BuyLine buyLine = new BuyLine(1, book, newOrder);
            buyLineList.add(buyLine);
            newOrder.setClient(userRepository.findById(client_id).orElseThrow(()->{
               return new RuntimeException("client not found");
            }));
            newOrder.setAmount(book.getPrice());
            newOrder.setBuydate(new Date().toString());
            newOrder.setBuyLists(buyLineList);
            orderRepository.save(newOrder);
            buyLineRepository.save(buyLine);
        }else{
            List<BuyLine> lineList = order.get().getBuyLists();

            for(int i=0;i<lineList.size();i++){
                if (lineList.get(i).getBook()!=null && lineList.get(i).getBook() == book) {
                    lineList.get(i).setQuantity(lineList.get(i).getQuantity() + 1);
                    buyLineRepository.save(lineList.get(i));
                    orderRepository.save(order.get());
                    return;
                }
            }

            BuyLine buyLine = new BuyLine(1, book, order.get());
            lineList.add(new BuyLine(buyLine));
            orderRepository.save(order.get());
            buyLineRepository.save(buyLine);

        }
    }


}
