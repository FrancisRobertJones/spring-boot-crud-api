package com.fullstackfran.starter;

import com.fullstackfran.starter.domain.Author;

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

}
