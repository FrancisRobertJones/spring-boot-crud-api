package com.fullstackfran.starter.dao;

import com.fullstackfran.starter.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorDao {
    void create(Author author);
    Optional<Author> findOne(Long id);
    List<Author> find();
}
