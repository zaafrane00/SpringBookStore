package com.store.bookstorespring.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Optional;

@Entity
@Table(name="buylines")
public class BuyLine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;

    private int quantity;

    @ManyToOne(cascade=CascadeType.ALL)
    private Book book;

    @ManyToOne(cascade=CascadeType.ALL)
    private Order order;

    public BuyLine(int quantity, Book book, Order order) {
        this.quantity = quantity;
        this.book = book;
        this.order = order;
    }

    public BuyLine(BuyLine b) {
        this.quantity = b.quantity;
        this.book = b.book;
        this.order = b.order;
    }

    public BuyLine() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "BuyLine{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", book=" + book +
                ", order=" + order +
                '}';
    }
}
