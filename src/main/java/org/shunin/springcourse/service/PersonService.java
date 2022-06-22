package org.shunin.springcourse.service;

import org.shunin.springcourse.models.Book;
import org.shunin.springcourse.models.Person;
import org.shunin.springcourse.repositories.BookRepository;
import org.shunin.springcourse.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PersonService {

    private final PersonRepository personRepository;
    private final BookRepository bookRepository;

    @Autowired
    public PersonService(PersonRepository personRepository, BookRepository bookRepository) {
        this.personRepository = personRepository;
        this.bookRepository = bookRepository;
    }

    public List<Person> index() {
        return personRepository.findAll();
    }

    public Person findById(int id) {
        return personRepository.findById(id).get();
    }

    @Transactional(readOnly = false)
    public void save(Person person) {
        personRepository.save(person);
    }

    @Transactional(readOnly = false)
    public void delete(int id) {
        Person person = personRepository.findById(id).get();
        personRepository.delete(person);
    }

    public Optional<Person> getBookOwner(int id) {
        Book book = bookRepository.findById(id).get();
        int idBook = book.getForId();
        return personRepository.findById(idBook);
    }
}
