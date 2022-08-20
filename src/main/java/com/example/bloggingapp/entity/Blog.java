package com.example.bloggingapp.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TABLE_BLOG")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BLOG_ID")
    private Long blogId;
    private String blogTxt;
    protected String blogCategory;
    @ManyToOne
    private User user;

}
