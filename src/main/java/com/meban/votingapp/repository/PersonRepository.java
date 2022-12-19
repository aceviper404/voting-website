package com.meban.votingapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.meban.votingapp.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Short> {
	Optional<Person> findByName(String name);

}
