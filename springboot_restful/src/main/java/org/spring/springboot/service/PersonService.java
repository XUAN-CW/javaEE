package org.spring.springboot.service;

import org.spring.springboot.domain.Person;

import java.util.List;

/**
 * 城市业务逻辑接口类
 *
 * @author XUAN
 * @date 2020/11/2
 */
public interface PersonService {

    List<Person> findAll();

    Person findOne(Long id);

    Long savePerson(Person person);

    Long updatePerson(Person person);

    Long deletePerson(Long id);

}
