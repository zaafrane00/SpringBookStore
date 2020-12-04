package com.store.bookstorespring.entities;


import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Length(min = 4, max = 15)
    private String title;
    @Length(min = 4, max = 15)
    private String auther;
    private double price;
    @Length(min = 4, max = 4)
    private String release_date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Book(Long id, String title, String auther, double price, String release_date) {
        this.id = id;
        this.title = title;
        this.auther = auther;
        this.price = price;
        this.release_date = release_date;
    }

    public Book(Book b) {
        this.id = b.id;
        this.title = b.title;
        this.auther = b.auther;
        this.price = b.price;
        this.release_date = b.release_date;
    }

    public Book() {

    }
    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", auther='" + auther + '\'' +
                ", price=" + price +
                ", release=" + release_date +
                '}';
    }

 }
