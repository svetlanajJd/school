package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student readStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student updateStudent(Student student) {
//        if (studentRepository.findAll().contains(student.getId())) {
            return studentRepository.save(student);
        }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }


    public List<Student> ageStudent(int age) {
        return studentRepository.findByAge(age);
    }

}
