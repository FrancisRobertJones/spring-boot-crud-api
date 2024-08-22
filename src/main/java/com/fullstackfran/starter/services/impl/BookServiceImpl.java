package com.fullstackfran.starter.services.impl;

import com.fullstackfran.starter.entities.BookEntity;
import com.fullstackfran.starter.respositories.BookRepository;
import com.fullstackfran.starter.services.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    public BookServiceImpl (BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookEntity createBook(String isbn, BookEntity book) {
        book.setIsbn(isbn);
        return bookRepository.save(book);
    }
}
