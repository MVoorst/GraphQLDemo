package com.mvoorst.backbone.persistence;

import com.mvoorst.backbone.models.Author;
import com.mvoorst.backbone.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}