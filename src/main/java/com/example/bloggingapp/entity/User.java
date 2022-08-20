package com.example.bloggingapp.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@Entity
@Table(name = "TABLE_USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Long id;

    private String firstName;
    private String lastName;
    private Instant createDate;

    @OneToMany(mappedBy = "user", targetEntity = Blog.class)
    private List<Blog> blogs;
}
