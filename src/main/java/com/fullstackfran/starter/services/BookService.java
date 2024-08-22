package com.fullstackfran.starter.services;

import com.fullstackfran.starter.entities.BookEntity;

public interface BookService {
    BookEntity createBook(String isbn, BookEntity book);
}
