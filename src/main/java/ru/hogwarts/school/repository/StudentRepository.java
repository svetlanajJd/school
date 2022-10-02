package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByAgeBetween(int minAge, int maxAge);

    @Query(value = "SELECT count (id) FROM student",nativeQuery = true)
    Integer getStudentById();

    @Query(value = "SELECT AVG (age) FROM student",nativeQuery = true)
    Integer getStudentByAge();

    @Query(value = "SELECT * FROM student OFFSET (SELECT count(*) FROM student)-5",nativeQuery = true)
    List<Student> getStudentByOffset();

}
