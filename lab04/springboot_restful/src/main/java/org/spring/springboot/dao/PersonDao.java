package org.spring.springboot.dao;

import org.spring.springboot.domain.Person;
import org.springframework.context.annotation.Bean;

import java.util.List;
/**
 * 人员Dao接口类
 *
 * @author XUAN
 * @date 2020/11/2
 */
public interface PersonDao {

    List<Person> findAll();

    Person findOne(Long id);

    Long savePerson(Person person);

    Long updatePerson(Person person);

    Long deletePerson(Long id);
}
