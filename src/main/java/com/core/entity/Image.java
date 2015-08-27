package com.core.entity;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] body;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }
}
