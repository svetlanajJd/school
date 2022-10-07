package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
//import ru.hogwarts.school.inter.ExpenseById;
import org.springframework.web.client.RestTemplate;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service

public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;
    Logger logger = LoggerFactory.getLogger(StudentService.class);
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        logger.info("Was invoked method for create student");
        return studentRepository.save(student);
    }

    public Student readStudentById(Long id) {
        logger.error("There is not student with id = " + id);
        Student student = studentRepository.findById(id).get();
        if (student != null) {
            return student;
        } else {
            throw new RuntimeException();
        }
    }

    public Student updateStudent(Student student) {
        Optional<Student> s = studentRepository.findById(student.getId());
        if (s.isPresent()) {
            s.get().setId(student.getId());
            s.get().setName(student.getName());
            s.get().setAge(student.getAge());
            return studentRepository.save(s.get());
        }
        return null;
    }

    public void deleteStudent(Long id) {
        logger.warn("There is student with id = {} was delete", id);
        studentRepository.deleteById(id);
    }

    public List<Student> findAge(int minAge, int maxAge) {
        logger.debug("Students were found");
        return studentRepository.findByAgeBetween(minAge, maxAge);
    }

//    public String getPort() {
//        logger.debug("port 8080");
//        return "port 8080";
//    }

    public Faculty nameStudent(Long id) {
        return studentRepository.findById(id).get().getFaculty();
    }

    public Integer getStudentById() {

        return studentRepository.getStudentById();
    }

    public Integer getStudentByAge() {
        return studentRepository.getStudentByAge();
    }

    public List<Student> getStudentByOffset() {
        return studentRepository.getStudentByOffset();
    }
}
