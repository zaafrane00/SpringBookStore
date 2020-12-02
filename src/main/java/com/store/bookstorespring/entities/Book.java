package com.store.bookstorespring.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="books")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column
    public String title;
    @Column
    public String auther;
    @Column
    public double price;
    @Column
    public int releasee;

    public Book(Book b) {
        this.id = b.id;
        this.title = b.title;
        this.auther = b.auther;
        this.price = b.price;
        this.releasee = b.releasee;
    }

    public Book(Long id, String title, String auther, double price, int release) {
        this.id = id;
        this.title = title;
        this.auther = auther;
        this.price = price;
        this.releasee = release;
    }

    public Book() {

    }




    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRelease(int release) {
        this.releasee = release;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", auther='" + auther + '\'' +
                ", price=" + price +
                ", release=" + releasee +
                '}';
    }

 }
