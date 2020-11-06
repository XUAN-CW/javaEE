//package com.github.ponymaggie.jpa.controller;
//
//import com.github.ponymaggie.jpa.entity.Student;
//import com.github.ponymaggie.jpa.repository.StudentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(value = "/student")
//public class JPAController {
//
//	@Autowired
//	private StudentRepository studentRepository;
//
//	@RequestMapping(value = "/save", method = RequestMethod.GET)
//	public Student save(Student user) {
//		return studentRepository.save(user);
//	}
//
//	@RequestMapping(value = "/list", method = RequestMethod.GET)
//	public List<Student> list() {
//		return studentRepository.findAll();
//	}
//
//	@RequestMapping(value = "/findByName", method = RequestMethod.GET)
//	public List<Student> findByName(String name) {
//		return studentRepository.findByName(name);
//	}
//
//	@RequestMapping(value = "/count", method = RequestMethod.GET)
//	public Long countByName(String name) {
//		return studentRepository.countByName(name);
//	}
//
//	@RequestMapping(value = "/delete", method = RequestMethod.GET)
//	public void delete(Long idd) {
//		studentRepository.deleteById(idd);
//	}
//
//	// http://localhost:8080/student/find?name=1&age=2
//	@RequestMapping(value = "/find", method = RequestMethod.GET)
//	public Student getByUsernameAndPassword(String name, String age) {
//		System.out.println("name:"+name+" age:"+age);
//		System.out.println(studentRepository.getByUsernameAndPassword(name,age));
//		return studentRepository.getByUsernameAndPassword(name,age);
//	}
//
//
//}
