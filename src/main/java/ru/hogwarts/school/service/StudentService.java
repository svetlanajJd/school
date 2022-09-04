package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final Map<Long, Student> students = new HashMap<>();
    private long count = 0;

    public Student createStudent(Student student) {
        students.put(count, student);
        student.setId(++count);
                return student;
    }

    public Student readStudentById(Long idStudent) {
        return students.get(idStudent);
    }

    public Student updateStudent(Student student) {
        if (students.containsKey(student.getId())) {
            students.put(student.getId(), student);
            return student;
        }
        return null;
    }


    public Student deleteStudent(Long idStudent) {
        return students.remove(idStudent);
    }


    public List<Student> ageStudent(int age) {
        List<Student> listStudentAge = new ArrayList<>(students.values());
        return listStudentAge.stream()
                .filter(a -> a.getAge() == age)
                .collect(Collectors.toList());
    }

}
