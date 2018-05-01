package com.csye6225.demo.repository;

/**
 * <Rishabh Jain>, <001226719>, <jain.rish@husky.neu.edu>
 **/

import org.springframework.data.jpa.repository.JpaRepository;
import com.csye6225.demo.domain.Person;
import org.springframework.stereotype.Repository;


@Repository("personRepository")
public interface PersonRepository extends JpaRepository<Person,Long> {
    Person findByEmail(String email);
}
