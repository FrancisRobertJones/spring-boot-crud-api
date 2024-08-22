package com.fullstackfran.starter.respositories;

import com.fullstackfran.starter.entities.BookEntity;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<BookEntity, String> {
}
