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
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
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
        Author author = TestDataUtil.createTestAuthorA();
        authorDao.create(author);
        Book book = TestDataUtil.createTestBookA();
        book.setAuthorId(author.getId());
        underTest.create(book);
        Optional<Book> result = underTest.findOne("helloisbn");
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);
    }

    @Test
    public void testThatFindAllCreatesTheCorrectSql() {
        Author author = TestDataUtil.createTestAuthorA();
        authorDao.create(author);

        Book bookA = TestDataUtil.createTestBookA();
        bookA.setAuthorId(author.getId());
        underTest.create(bookA);

        Book bookB = TestDataUtil.createTestBookB();
        bookB.setAuthorId(author.getId());
        underTest.create(bookB);

        Book bookC = TestDataUtil.createTestBookC();
        bookC.setAuthorId(author.getId());
        underTest.create(bookC);

        List<Book> results = underTest.find();

        assertThat(results)
                .hasSize(3)
                .containsExactly(bookA, bookB, bookC);

    }

    @Test
    public void testThatBookCanBeUpdated() {
        Author author = TestDataUtil.createTestAuthorA();
        Book book = TestDataUtil.createTestBookA();
        authorDao.create(author);
        book.setAuthorId(author.getId());
        underTest.create(book);
        book.setTitle("upated");
        underTest.update(book.getIsbn(), book);
        Optional<Book> result = underTest.findOne(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);
    }

    @Test
    public void testThatBookCanBeDeleted() {
        Author author = TestDataUtil.createTestAuthorA();
        Book book = TestDataUtil.createTestBookA();
        authorDao.create(author);
        book.setAuthorId(author.getId());
        underTest.create(book);
        underTest.delete(book.getIsbn());
        Optional<Book> result = underTest.findOne(book.getIsbn());
        assertThat(result).isEmpty();
    }
}
