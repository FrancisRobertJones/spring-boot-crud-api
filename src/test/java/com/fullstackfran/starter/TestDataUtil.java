package com.fullstackfran.starter;

import com.fullstackfran.starter.domain.Author;
import com.fullstackfran.starter.domain.Book;

public final class TestDataUtil {
    private TestDataUtil(){}

    public static Author createTestAuthor() {
        Author author = Author.builder()
                .id(1L)
                .name("Abigail Rose")
                .age(80)
                .build();
        return author;
    }

    public static Book createTestBook() {
        Book book = Book.builder()
                .isbn("helloisbn")
                .title("The lord of the rings")
                .authorId(123L)
                .build();
        return book;
    }

}
