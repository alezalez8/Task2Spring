package org.shunin.springcourse.repositories;

import org.shunin.springcourse.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
