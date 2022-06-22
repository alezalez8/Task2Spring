package org.shunin.springcourse.service;

import org.shunin.springcourse.models.Book;
import org.shunin.springcourse.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public List<Book> index(int page, int booksPerPage) {
       // System.err.println("========= Pagination ======================");
       // System.err.println(page + "======== Value ==========" + booksPerPage);
        Pageable pageAndBook = PageRequest.of(page, booksPerPage);
        return bookRepository.findAll(pageAndBook).toList();
    }

    public List<Book> index(Boolean sortByYear) {
        return bookRepository.findAll(Sort.by("year"));
    }

    public void testMessage(int a, int b) {
        System.out.println(a + "    " + b);
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
