package com.mvoorst.demo.persistence;

import com.mvoorst.demo.models.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}