package com.fullstackfran.starter.respositories;

import com.fullstackfran.starter.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, String> {
}
