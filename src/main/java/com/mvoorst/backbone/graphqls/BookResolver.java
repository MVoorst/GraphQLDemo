package com.mvoorst.backbone.graphqls;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.mvoorst.backbone.models.Author;
import com.mvoorst.backbone.models.Book;
import com.mvoorst.backbone.persistence.AuthorRepository;

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
