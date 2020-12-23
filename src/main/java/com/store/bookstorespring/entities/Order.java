package com.store.bookstorespring.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;

    @Column(name = "buydate", nullable = false, updatable = true)
    private String buydate;

    @Column(name = "amount", nullable = false, updatable = true)
    private double amount;

    @ManyToOne
    private User client;

    @OneToMany(cascade=CascadeType.ALL)
    private List<BuyLine> buyLists = new ArrayList<BuyLine>();

    @Column(name="status",nullable = false,updatable = true)
    private boolean status;

    public Order() {
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getBuydate() {
        return buydate;
    }

    public void setBuydate(String buydate) {
        this.buydate = buydate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<BuyLine> getBuyLists() {
        return buyLists;
    }

    public void setBuyLists(List<BuyLine> buyLists) {
        this.buyLists = buyLists;
    };

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", buydate='" + buydate + '\'' +
                ", amount=" + amount +
                ", client=" + client +
                ", buyLists=" + buyLists +
                ", status=" + status +
                '}';
    }
}
