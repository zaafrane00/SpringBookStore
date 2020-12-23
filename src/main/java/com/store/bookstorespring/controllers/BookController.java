package com.store.bookstorespring.controllers;

import com.store.bookstorespring.entities.Book;
import com.store.bookstorespring.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {
    // les fonctions sont invoké en form data dans postman
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/")
    public List<Book> getBookList() {
        return bookRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public Object getBook(@PathVariable long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            new ResponseEntity<>(HttpStatus.ACCEPTED);
          return book.get();
        } else {
            return new ResponseEntity<String>("Not Found",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/allprices")
    public ResponseEntity<String> calculatePrice() {
    ArrayList<Book> books;
    books= (ArrayList<Book>) bookRepository.findAll();
    double _price = 0;
        for (Book var : books)
        {
            _price+=var.getPrice();
        }
        return new ResponseEntity<String>("the price of all the books is: "+_price, HttpStatus.OK);
    }

    @PostMapping("/add")
    public Book store(@Validated @RequestBody Book b) {
        System.out.println(b);
            bookRepository.save(b);
            Book book =new Book(b);
            return book;
    }

    // cette method est invoké en raw json dans postman
    @RequestMapping(value = "/update/{id}",
              method = RequestMethod.POST,  produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> update(@PathVariable Long id,@RequestBody @Validated Book bookDetails) {
            Optional<Book> b = bookRepository.findById(id);
            if (b.isPresent()){
                Book book=b.get();
                book.setAuther(bookDetails.getAuther());
                book.setPrice(bookDetails.getPrice());
                book.setRelease_date(bookDetails.getRelease_date());
                book.setTitle(bookDetails.getTitle());
                bookRepository.save(book);
                return new ResponseEntity<String>("Book updated successfully \n"+book, HttpStatus.FOUND);
            }else{
                return new ResponseEntity<String>("Book not found \n", HttpStatus.NOT_FOUND);
            }
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable long id) {
        try {
            bookRepository.deleteById(id);
            return new ResponseEntity<String>("Book deleted successfully", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<String>("error"+e, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/getbooklist/price")
    public ResponseEntity<String> getBookListPrice(/*@RequestBody ArrayList<Long> bookList*/){
        //valeurs de tests
        int var1=12;
        int var2=13;
        int var3=13;
        Long long1 = Long.valueOf(var1);
        Long long2 = Long.valueOf(var2);
        Long long3 = Long.valueOf(var3);
        ArrayList<Long> bookList=new ArrayList<Long>();
        bookList.add(long1);
        bookList.add(long2);
        bookList.add(long3);
        System.out.println(bookList);
        double _price=0;
        for (Long var : bookList)
        {
            Optional<Book> b = bookRepository.findById(var);
            _price+=b.get().getPrice();
        }
        return new ResponseEntity<String>("the price of the given booklist: "+_price, HttpStatus.OK);
    }
}
