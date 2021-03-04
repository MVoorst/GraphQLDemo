package com.mvoorst.backbone.graphqls;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.mvoorst.backbone.models.Author;
import com.mvoorst.backbone.models.Book;
import com.mvoorst.backbone.persistence.AuthorRepository;
import com.mvoorst.backbone.persistence.BookRepository;

public class Query implements GraphQLQueryResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public Query(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public long countBooks() {
        return bookRepository.count();
    }
    public long countAuthors() {
        return authorRepository.count();
    }
}
