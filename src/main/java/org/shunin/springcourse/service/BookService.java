package org.shunin.springcourse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class BookService  {

    private final BookService bookService;

    @Autowired
    public BookService(BookService bookService) {
        this.bookService = bookService;
    }
}
