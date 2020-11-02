package org.spring.springboot.controller;

import org.spring.springboot.domain.Person;
import org.spring.springboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 人员PersonController 实现 HTTP服务
 *
 * @author XUAN
 * @date 2020/11/2
 */

@RestController
public class PersonRestController {

    @Autowired
    private PersonService personService;
    // 增加下面的头，使得 RequestBody 为 json 格式数据
    // Content-Type: application/json

    // http://localhost:8080/api/person
    @RequestMapping(value = "/api/person" ,method = RequestMethod.GET)
    public List<Person> findAll(){
        return personService.findAll();
    }

    //http://localhost:8080/api/person/1
    @RequestMapping(value = "/api/person/{id}", method = RequestMethod.GET)
    public Person findOne(@PathVariable("id") Long id){
        return personService.findOne(id);
    }

    // http://localhost:8080/api/person
    // {"id":2,"name":"1","gender":"1","description":"1"}
    @RequestMapping(value = "/api/person", method = RequestMethod.POST)
    public void savePerson(@RequestBody Person person){
        personService.savePerson(person);
    }

    // http://localhost:8080/api/person
    // {"id":2,"name":"55555","gender":"1","description":"1"}
    @RequestMapping(value = "/api/person", method = RequestMethod.PUT)
    public void updatePerson(@RequestBody Person person){
        personService.updatePerson(person);
    }

    // http://localhost:8080/api/person/2
    @RequestMapping(value = "/api/person/{id}", method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable("id") Long id){
        personService.deletePerson(id);
    }
}
