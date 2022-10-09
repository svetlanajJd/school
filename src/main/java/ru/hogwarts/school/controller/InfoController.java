package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.school.service.InfoService;
import ru.hogwarts.school.service.StudentService;

@RestController
public class InfoController {


    private StudentService studentService;

    private InfoService infoService;

    public InfoController(StudentService studentService, InfoService infoService) {
        this.studentService = studentService;
        this.infoService = infoService;
    }

    @GetMapping("/getPort")
    public String getPortProduction() {
        return studentService.getPort();
    }

    @GetMapping("/sumParallel")
    public String sumParallel() {
        return infoService.sumParallel();
    }

}
