package org.practice.quarkus;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.List;
import java.util.Optional;


@ApplicationScoped
public class BookRepository {

    @ConfigProperty(name = "books.genre", defaultValue = "Sci-Fi")
    String genre;


    public List<Book> getAllBooks() {
        return List.of(
                new Book(1,"Understanding Quarkus","Harsh", 2020 ,genre),
                new Book(2,"Practising Quarkus","Harsh", 2023 ,genre),
                new Book(3,"Effective Quarkus","Harsh Vyas", 2025 ,genre)
        );
    }


    public int countAllBooks(){
        return getAllBooks().size();
    }

    public Optional<Book> getBook(Integer id){
        return getAllBooks().stream().filter(book ->book.id == id).findFirst();
    }
}
