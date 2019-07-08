package com.mzbloc.demo.sample108.person.dao;

import com.mzbloc.demo.sample108.person.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author tanxw
 * @date 2019/7/3
 */
public interface PersonRepository extends JpaRepository<Person,Long> {

}
