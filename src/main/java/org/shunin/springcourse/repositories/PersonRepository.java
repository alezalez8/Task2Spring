package org.shunin.springcourse.repositories;

import org.shunin.springcourse.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
