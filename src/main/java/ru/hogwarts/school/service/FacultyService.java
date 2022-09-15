package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty studentFaculty) {
        return facultyRepository.save(studentFaculty);
    }

    public Faculty readFacultyById(Long id) {
        return facultyRepository.findById(id).orElse(null);
    }

    public Faculty updateFaculty(Faculty studentFaculty) {
        Optional<Faculty> facultyUpdate = facultyRepository.findById(studentFaculty.getId());
        if (facultyUpdate.isPresent()) {
            facultyUpdate.get().setId(studentFaculty.getId());
            facultyUpdate.get().setName(studentFaculty.getName());
            facultyUpdate.get().setColor(studentFaculty.getColor());
            return facultyRepository.save(facultyUpdate.get());
        }
        return null;
    }

    public void deleteFaculty(Long id) {
        facultyRepository.deleteById(id);
    }

    public List<Faculty> nameOrColorFaculty(String name) {
        return facultyRepository.findByNameIgnoreCaseOrColorIgnoreCase(name, name);
    }

    public List<Student> studentsOfFaculty(Long id) {
        return facultyRepository.findById(id).get().getStudents();
    }
    }

    