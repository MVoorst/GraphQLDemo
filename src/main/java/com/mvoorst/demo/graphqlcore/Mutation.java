package com.mvoorst.demo.graphqlcore;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.mvoorst.demo.models.Author;
import com.mvoorst.demo.models.Book;
import com.mvoorst.demo.persistence.AuthorRepository;
import com.mvoorst.demo.persistence.BookRepository;

import java.util.Optional;


public class Mutation implements GraphQLMutationResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public Mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Author newAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        authorRepository.save(author);

        return author;
    }

    public Book newBook(String title, String isbn, Integer pageCount, Long authorId) {
        Book book = new Book();
        book.setAuthor(new Author(authorId));
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPageCount(pageCount != null ? pageCount : 0);

        bookRepository.save(book);

        return book;
    }

    public Book updateBookPageCount(Integer pageCount, Long id) {
        Optional<Book> book = bookRepository.findById(id);
        book.ifPresent(b-> {
            b.setPageCount(pageCount);
            bookRepository.save(b);
        });
        return book.get();
    }

    public boolean deleteBook(Long id) {
        bookRepository.deleteById(id);
        return true;
    }


}
