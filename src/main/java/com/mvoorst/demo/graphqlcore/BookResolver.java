package com.mvoorst.demo.graphqlcore;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.mvoorst.demo.models.Author;
import com.mvoorst.demo.models.Book;
import com.mvoorst.demo.persistence.AuthorRepository;

import java.util.Optional;


/*
GraphQL Java Tools works with four types of Resolver classes:

GraphQLResolver<T> to resolve complex types.
GraphQLQueryResolver to define the operations of the root Query type.
GraphQLMutationResolver to define the operations of the root Mutation type.
GraphQLSubscriptionResolver to define the operations of the root Subscription type.
 */

public class BookResolver implements GraphQLResolver<Book> {

    private AuthorRepository authorRepository;

    public BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Optional<Author> getAuthor(Book book) {
        return authorRepository.findById(book.getAuthor().getId());
    }
}
