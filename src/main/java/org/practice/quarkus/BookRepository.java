package org.practice.quarkus;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;


@ApplicationScoped
public class BookRepository {


    public List<Book> getAllBooks() {
        return List.of(
                new Book(1,"Understanding Quarkus","Harsh", 2020 ,"IT"),
                new Book(2,"Practising Quarkus","Harsh", 2023 ,"IT"),
                new Book(3,"Effective Quarkus","Harsh Vyas", 2025 ,"IT")
        );
    }


    public int countAllBooks(){
        return getAllBooks().size();
    }

    public Optional<Book> getBook(Integer id){
        return getAllBooks().stream().filter(book ->book.id == id).findFirst();
    }
}
