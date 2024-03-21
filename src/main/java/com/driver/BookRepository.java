package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    private Map<Integer, Book> bookMap;
    private int nextId;
    public BookRepository(){
        bookMap = new HashMap<>();
        nextId = 1;
    }

    public Book save(Book book){
        book.setId(nextId++);
        bookMap.put(book.getId(), book);
        return book;
    }

    public Book findBookById(int id){
        return bookMap.get(id);
    }

    public List<Book> findAll(){
        return new ArrayList<>(bookMap.values());
    }

    public void deleteBookById(int id){
        bookMap.remove(id);
    }

    public void deleteAll(){
        bookMap.clear();
    }

    public List<Book> findBooksByAuthor(String author){
        List<Book> booksByAuthor = new ArrayList<>();
        for (Book book : bookMap.values()) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor;
    }

    public List<Book> findBooksByGenre(String genre){
        List<Book> booksByGenre = new ArrayList<>();
        for (Book book : bookMap.values()) {
            if (book.getGenre().equalsIgnoreCase(genre)) {
                booksByGenre.add(book);
            }
        }
        return booksByGenre;
    }
}
