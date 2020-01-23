package vitali.springframework.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import vitali.springframework.spring5webapp.model.Author;
import vitali.springframework.spring5webapp.model.Book;
import vitali.springframework.spring5webapp.repositories.AuthorRepository;
import vitali.springframework.spring5webapp.repositories.BookRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Author author1 = new Author("Author1", "Surname1");
        Book book1 = new Book("title1", "123", "publisher1");
        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);

        authorRepository.save(author1);
        bookRepository.save(book1);


        Author author2 = new Author("Author2", "Surname2");
        Book book2 = new Book("title2", "456", "publisher2");
        author2.getBooks().add(book2);

        authorRepository.save(author2);
        bookRepository.save(book2);

    }
}
