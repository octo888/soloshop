package com.core.beans;

import com.core.entity.Book;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {

    private List<Book> items;

    public List<Book> getItems() {
        return items;
    }

    public void setItems(List<Book> items) {
        this.items = items;
    }


    public Double totalSum() {
        double sum = 0;
        for (Book book : this.items) {
            sum += book.getPrice();
        }
        return sum;
    }

}
