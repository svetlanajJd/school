package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collections;
import java.util.List;

@RequestMapping("student")
@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student student = studentService.readStudentById(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.ok(createdStudent);
    }


    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(student);
        if (updatedStudent == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Student> getFoundAge(@RequestParam("minAge") int minAge, @RequestParam("maxAge") int maxAge) {
        return studentService.findAge(minAge, maxAge);
    }


    @GetMapping("{id}/students")
    public Faculty getName(@PathVariable Long id) {
        return studentService.nameStudent(id);
    }

    @GetMapping("/expenses-by-id")
    public  Integer getExpensesById(){
        return studentService.getStudentById();
    }

    @GetMapping("/expenses-by-age")
    public Integer getExpensesByAge() {
        return studentService.getStudentByAge();
    }
        @GetMapping("/expenses-by-offset")
        public List<Student> getStudentByOffset(){
            return studentService.getStudentByOffset();
    }

    @GetMapping("/studentA")
    public List<String> studentA(){
        return studentService.studentA();
    }

    @GetMapping("/ageAverage")
    public double ageAverage(){
        return studentService.ageAverage();
    }

    @GetMapping("/printStudentsThread")
    public void printStudentsWithThread(){
        studentService.prinStudentsWithThread();
    }

    @GetMapping("/printStudentWithThreadSynchronized")
    public void printStudentWithThreadSynchronized(){
        studentService.prinStudentsWithThreadSynchronized();
    }
}