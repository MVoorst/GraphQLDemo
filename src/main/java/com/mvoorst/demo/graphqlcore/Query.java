package com.mvoorst.demo.graphqlcore;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.mvoorst.demo.models.Author;
import com.mvoorst.demo.models.Book;
import com.mvoorst.demo.persistence.AuthorRepository;
import com.mvoorst.demo.persistence.BookRepository;

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
