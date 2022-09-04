package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.Map;

@Service
public class FacultyService {
    private Map<Long, Faculty> studentsFaculty=new HashMap<>();
    private long count=0;

    public Faculty createFaculty(Faculty studentFaculty){
        studentFaculty.setId(++count);
        studentsFaculty.put(count,studentFaculty);
                return  studentFaculty;
    }

    public Faculty readFacultyById (Long id){
        return studentsFaculty.get(id);
    }

    public Faculty updateFaculty(Faculty studentFaculty) {
        if (studentsFaculty.containsKey(studentFaculty.getId())) {
            studentsFaculty.put(studentFaculty.getId(), studentFaculty);
            return studentFaculty;
        }
        return null;
    }

    public Faculty deleteFaculty(Long id){
        return studentsFaculty.remove(id);
    }
}
