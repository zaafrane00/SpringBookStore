package com.store.bookstorespring.services;

import com.store.bookstorespring.entities.Book;
import com.store.bookstorespring.entities.BuyLine;
import com.store.bookstorespring.entities.Order;
import com.store.bookstorespring.entities.User;
import com.store.bookstorespring.repositories.BookRepository;
import com.store.bookstorespring.repositories.BuyLineRepository;
import com.store.bookstorespring.repositories.OrderRepository;
import com.store.bookstorespring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuyLineService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    BuyLineRepository buyLineRepository;

    public List<BuyLine> getAllBuyLines() {
        return buyLineRepository.findAll();
    }

    public BuyLine getCommandLineById(Long id) throws Exception {
        return buyLineRepository.findById(id).orElseThrow(()-> new Exception(
                "No command line with this id"));
    }

    public ResponseEntity<String> addBuyLine(Long user_id, Long bookId, BuyLine _line) throws Exception {
      User user = userRepository.findById(user_id).orElseThrow(() -> new Exception(
               "No user with this id"));
       if(user!=null){
           Book book= bookRepository.findById(bookId).orElseThrow(() -> new Exception(
                   "No book with this id"));
           if(book!=null){
               Order newOrder =new Order(user);
               BuyLine line=new BuyLine();
               line.setOrder(newOrder);
               line.setBook(book);
               buyLineRepository.save(line);
               return new ResponseEntity<String>("Book deleted successfully \n"+line, HttpStatus.CREATED);
           }
           else
               return new ResponseEntity<String>("book not Found", HttpStatus.NOT_FOUND);
       }else
        return new ResponseEntity<String>("user not Found", HttpStatus.NOT_FOUND);
    }


}
