package com.example.bloggingapp.repo;

import com.example.bloggingapp.entity.Blog;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepo extends JpaRepository<Blog,Long> {
    List<Blog> findAllByUserId(long id);
}
