package com.store.bookstorespring.entities;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name="buylines")
public class BuyLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;

    private int quantity;
    private double price;
    @ManyToOne
    private Book book;
    @ManyToOne
    private Order order;

    public BuyLine(int quantity, double price, Book book, Order order) {
        this.quantity = quantity;
        this.price = price;
        this.book = book;
        this.order = order;
    }

    public BuyLine(BuyLine b) {
        this.quantity = b.quantity;
        this.price = b.price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
                ", price=" + price +
                ", book=" + book +
                ", order=" + order +
                '}';
    }
}
