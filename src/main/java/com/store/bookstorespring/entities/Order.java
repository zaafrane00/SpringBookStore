package com.store.bookstorespring.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;

    @Column(name = "buydate", nullable = false, updatable = true)
    private String buydate;

    @Column(name = "amount", nullable = false, updatable = true)
    private double amount;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private User client;

    @OneToMany
    private Set<BuyLine> orderItemSet = new HashSet<BuyLine>();

    public Order(User client) {
        this.setClient(client);
    }

    public Order() {

    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Set<BuyLine> getOrderItemSet() {
        return orderItemSet;
    }

    public void setOrderItemSet(Set<BuyLine> orderItemSet) {
        this.orderItemSet = orderItemSet;
    }



    public String getBuydate() {
        return buydate;
    }

    public void setBuydate(String buydate) {
        this.buydate = buydate;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", buydate='" + buydate + '\'' +
                ", user=" + client +
                '}';
    }
}
