package com.store.bookstorespring.services;

import com.store.bookstorespring.entities.BuyLine;
import com.store.bookstorespring.entities.Order;
import com.store.bookstorespring.entities.User;
import com.store.bookstorespring.repositories.BookRepository;
import com.store.bookstorespring.repositories.OrderRepository;
import com.store.bookstorespring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    OrderRepository orderRepository;


    public List<Order> getAllBuyLines() {
        return orderRepository.findAll();
    }



    @Transactional
    public Order add(Order order){
        Order orderr = orderRepository.save(order);
        //Optional<User> _user=userRepository.findById(orderr.getClient());
       // _user.ifPresent(System.out::println);
        //System.err.println("qsqsfqsfqsfqsfqsff"+_user.get());
        //System.out.println(order);
        return orderr;
        //return order;
    }

}
