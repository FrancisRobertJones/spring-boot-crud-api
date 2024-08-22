package com.fullstackfran.starter;

import com.fullstackfran.starter.entities.AuthorEntity;
import com.fullstackfran.starter.entities.BookEntity;

public final class TestDataUtil {
    private TestDataUtil(){}

    public static AuthorEntity createTestAuthorA() {
        AuthorEntity authorEntity = AuthorEntity.builder()
                .id(1L)
                .name("Abigail Rose")
                .age(80)
                .build();
        return authorEntity;
    }
    public static AuthorEntity createTestAuthorB() {
        AuthorEntity authorEntity = AuthorEntity.builder()
                .id(2L)
                .name("Francis Jones")
                .age(32)
                .build();
        return authorEntity;
    }
    public static AuthorEntity createTestAuthorC() {
        AuthorEntity authorEntity = AuthorEntity.builder()
                .id(3L)
                .name("Charlie Jones")
                .age(1)
                .build();
        return authorEntity;
    }

    public static BookEntity createTestBookA(final AuthorEntity authorEntity) {
        BookEntity bookEntityA = BookEntity.builder()
                .isbn("helloisbn")
                .title("The lord of the rings")
                .authorEntity(authorEntity)
                .build();
        return bookEntityA;
    }

    public static BookEntity createTestBookB(AuthorEntity authorEntity) {
        BookEntity bookEntityB = BookEntity.builder()
                .isbn("sdfjnsdjfns")
                .title("Return of the king")
                .authorEntity(authorEntity)
                .build();
        return bookEntityB;
    }
    public static BookEntity createTestBookC(AuthorEntity authorEntity) {
        BookEntity bookEntityC = BookEntity.builder()
                .isbn("kmsmmm")
                .title("Two towers")
                .authorEntity(authorEntity)
                .build();
        return bookEntityC;
    }

}
