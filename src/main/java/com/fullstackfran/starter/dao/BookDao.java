package com.fullstackfran.starter.dao;

import com.fullstackfran.starter.domain.Book;

import java.util.Optional;

public interface BookDao {
    void create(Book book);
    Optional<Book> find(String isbn);
}
