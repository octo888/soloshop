package com.core.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cart {

    @Id
    @GeneratedValue
    private Long id;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> items;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<Integer> prices;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public List<Integer> getPrices() {
        return prices;
    }

    public void setPrices(List<Integer> prices) {
        this.prices = prices;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
