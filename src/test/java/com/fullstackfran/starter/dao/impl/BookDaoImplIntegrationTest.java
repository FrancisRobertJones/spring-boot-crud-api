package com.fullstackfran.starter.dao.impl;


import com.fullstackfran.starter.TestDataUtil;
import com.fullstackfran.starter.dao.AuthorDao;
import com.fullstackfran.starter.dao.BookDao;
import com.fullstackfran.starter.domain.Author;
import com.fullstackfran.starter.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class BookDaoImplIntegrationTest {

    private BookDaoImpl underTest;
    private AuthorDao authorDao;

    @Autowired
    public BookDaoImplIntegrationTest(BookDaoImpl underTest, AuthorDao authorDao) {
        this.underTest = underTest;
        this.authorDao = authorDao;
    }

    @Test
    public void testThatBookCanBeCreatedAndRecalled() {
        Author author = TestDataUtil.createTestAuthor();
        authorDao.create(author);
        Book book = TestDataUtil.createTestBook();
        book.setAuthorId(author.getId());
        underTest.create(book);
        Optional<Book> result = underTest.findOne("helloisbn");
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);
    }
}
