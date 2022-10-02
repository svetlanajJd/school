package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
//import ru.hogwarts.school.inter.ExpenseById;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
//    private ExpenseById expenseById;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
//        this.expenseById=expenseById;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student readStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student updateStudent(Student student) {
        Optional<Student> s=studentRepository.findById(student.getId());
        if (s.isPresent()) {
            s.get().setId(student.getId());
            s.get().setName(student.getName());
            s.get().setAge(student.getAge());
            return studentRepository.save(s.get());
        }
        return null;
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> findAge(int minAge, int maxAge) {
        return studentRepository.findByAgeBetween(minAge, maxAge);
    }

    public Faculty nameStudent (Long id) {
        return studentRepository.findById(id).get().getFaculty();
    }

    public Integer getStudentById(){
       return studentRepository.getStudentById();
    }

    public Integer getStudentByAge(){
        return studentRepository.getStudentByAge();
    }

    public List<Student> getStudentByOffset(){
        return studentRepository.getStudentByOffset();
    }
}
