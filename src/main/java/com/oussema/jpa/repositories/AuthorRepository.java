package com.oussema.jpa.repositories;

import com.oussema.jpa.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

// the difference between JpaRepository and JpaSpecificationExecutor is that the first one is used to perform CRUD operations
// while the second one is used to perform more complex queries using the Criteria API
@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> , JpaSpecificationExecutor<Author> {

    List<Author>  findAllByFirstName(String firstName);

    // find all authors whose first name is the given string
    List<Author> findAllByFirstNameIgnoreCase(String fn);

    // find all authors whose first name contains the given string
    List<Author> findAllByFirstNameContainingIgnoreCase(String fn);

    // find all authors whose first name starts with the given string
    List<Author> findAllByFirstNameStartingWithIgnoreCase(String fn);

    // find all authors whose first name ends with the given string
    List<Author> findAllByFirstNameEndsWithIgnoreCase(String fn);

    // find all authors whose first name is in the given list
    List<Author> findAllByFirstNameInIgnoreCase(List<String> firstNames);


}
