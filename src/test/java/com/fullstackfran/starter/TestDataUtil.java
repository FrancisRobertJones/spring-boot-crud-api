package com.fullstackfran.starter;

import com.fullstackfran.starter.domain.Author;
import com.fullstackfran.starter.domain.Book;

public final class TestDataUtil {
    private TestDataUtil(){}

    public static Author createTestAuthorA() {
        Author author = Author.builder()
                .id(1L)
                .name("Abigail Rose")
                .age(80)
                .build();
        return author;
    }
    public static Author createTestAuthorB() {
        Author author = Author.builder()
                .id(2L)
                .name("Francis Jones")
                .age(32)
                .build();
        return author;
    }
    public static Author createTestAuthorC() {
        Author author = Author.builder()
                .id(3L)
                .name("Charlie Jones")
                .age(1)
                .build();
        return author;
    }

    public static Book createTestBookA(final Author author) {
        Book bookA = Book.builder()
                .isbn("helloisbn")
                .title("The lord of the rings")
                .author(author)
                .build();
        return bookA;
    }

    public static Book createTestBookB(Author author) {
        Book bookB = Book.builder()
                .isbn("sdfjnsdjfns")
                .title("Return of the king")
                .author(author)
                .build();
        return bookB;
    }
    public static Book createTestBookC(Author author) {
        Book bookC = Book.builder()
                .isbn("kmsmmm")
                .title("Two towers")
                .author(author)
                .build();
        return bookC;
    }

}
