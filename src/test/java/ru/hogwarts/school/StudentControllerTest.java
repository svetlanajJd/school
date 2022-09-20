package ru.hogwarts.school;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import ru.hogwarts.school.controller.StudentController;
import ru.hogwarts.school.model.Student;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private StudentController studentController;
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() throws Exception {
        Assertions.assertThat(studentController).isNotNull();
    }

    @Test
    public void testGetStudent() throws Exception {
        Assertions.
                assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student/", String.class)).
                isNotNull();
    }

    @Test
    public void testCreateStudent() throws Exception {
        Student student = new Student();
        student.setName("nameTest");
        student.setAge(15);
        Assertions.
                assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/student/", student, String.class)).
                isNotNull();
    }
}
