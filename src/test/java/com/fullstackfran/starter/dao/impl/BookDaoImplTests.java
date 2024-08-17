package com.fullstackfran.starter.dao.impl;


import com.fullstackfran.starter.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookDaoImplTests {
    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BookDaoImpl underTest;


    @Test
    public void testThatCreatesCorrectSql() {
        Book book = Book.builder()
                .isbn("978-1-2345-6789-8")
                .title("The shadow in the Attic")
                .authorId(1L)
                .build();

        underTest.create(book);

        verify(jdbcTemplate).update(
                eq("INSERT INTO authors (isbn, name, author) VALUES (?, ?, ?)"),
                eq("978-1-2345-6789-8"), eq("The shadow in the Attic"), eq(1L)
        );
    }

    @Test
    public void testThatFindOneBookGeneratesTheCorrectSql() {
        underTest.find("978-1-2345-6789-8");
        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, author_id from books WHERE isbn = ? LIMIT 1"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any(),
                eq("978-1-2345-6789-8")
        );
    }


}
