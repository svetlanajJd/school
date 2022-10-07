package ru.hogwarts.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.StudentService;
import ru.hogwarts.school.service.StudentServiceProduction;
import ru.hogwarts.school.service.StudentTestService;

@RestController
public class InfoController {

    @Autowired
    private StudentServiceProduction studentServiceProduction;

    @Autowired
    private StudentTestService studentTestService;

    @Value("production")
    @GetMapping("/getPort")
    public String getPortProduction() {
        return studentServiceProduction.getPortProduction();
    }

    @Value("!production")
    @GetMapping("/getPort")
    public String getPort() {
        return studentTestService.getPort();
    }
}
