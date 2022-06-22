package org.shunin.springcourse.service;

import org.shunin.springcourse.models.Book;
import org.shunin.springcourse.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<Book> index() {
        return bookRepository.findAll();
    }

    public Book show(int id) {
        return bookRepository.findById(id).get();
    }

    @Transactional(readOnly = false)
    public void addBook(Book book) {
        bookRepository.save(book);
    }



  /*  @Transactional(readOnly = false)
    public void updateBook*/
}
