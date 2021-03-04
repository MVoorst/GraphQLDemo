package com.mvoorst.backbone.persistence;

import com.mvoorst.backbone.models.Book;
import org.springframework.data.repository.CrudRepository;


public interface BookRepository extends CrudRepository<Book, Long> {
}