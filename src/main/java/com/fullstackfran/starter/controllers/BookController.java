package com.fullstackfran.starter.controllers;

import com.fullstackfran.starter.domain.Dto.BookDto;
import com.fullstackfran.starter.entities.BookEntity;
import com.fullstackfran.starter.mappers.Mapper;
import com.fullstackfran.starter.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
    private Mapper<BookEntity, BookDto> bookMapper;
    private BookService bookService;

    public BookController(BookService bookService, Mapper<BookEntity, BookDto> bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @PutMapping("books/{isbn}")
    public ResponseEntity<BookDto> create(@PathVariable("isbn") String isbn,  @RequestBody  BookDto bookDto) {
        BookEntity bookEntity = bookMapper.mapFrom(bookDto);
        BookEntity savedBookEntity = bookService.createBook(isbn, bookEntity);
        BookDto savedBookDto = bookMapper.mapTo(savedBookEntity);
        return new ResponseEntity<>(savedBookDto, HttpStatus.CREATED);
    }

}