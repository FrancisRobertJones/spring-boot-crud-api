package com.fullstackfran.starter.dao.impl;


import com.fullstackfran.starter.TestDataUtil;
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
        Book book = TestDataUtil.createTestBookB();

        underTest.create(book);

        verify(jdbcTemplate).update(
                eq("INSERT INTO books (isbn, title, author_id) VALUES (?, ?, ?)"),
                eq("sdfjnsdjfns"), eq("Return of the king"), eq(123L)
        );
    }

    @Test
    public void testThatFindOneBookGeneratesTheCorrectSql() {
        underTest.findOne("978-1-2345-6789-8");
        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, author_id from books WHERE isbn = ? LIMIT 1"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any(),
                eq("978-1-2345-6789-8")
        );
    }

    @Test
    public void testThatUpdateGeneratesTheCorrectSql() {
        Book book = TestDataUtil.createTestBookA();
        underTest.update("helloisbn", book);
        verify(jdbcTemplate).update(
                "UPDATE books SET isbn = ?, title = ?, author_id = ? WHERE isbn = ?",
                    "helloisbn", "The lord of the rings", 123L, "helloisbn"
                );
    }

    @Test
    public void testThatDeleteGeneratesTheCorrectSql() {
        underTest.delete("helloisbn");
        verify(jdbcTemplate).update(
                "DELETE FROM books where isbn = ?",
                "helloisbn"
        );
    }


}
