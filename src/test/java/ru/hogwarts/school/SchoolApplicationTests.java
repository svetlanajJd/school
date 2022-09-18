package ru.hogwarts.school;

//import org.junit.jupiter.api.Assertions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import ru.hogwarts.school.controller.StudentController;

//@RunWith(SpringRunner.class)
//@SpringBootTest(
//        classes = SchoolApplication.class,
//        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
//)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SchoolApplicationTests {

    @Test
    void contextLoads() {
    }

//	@LocalServerPort
//	private int port;
//
//	@Autowired
//	private StudentController studentController;
//
//	@Autowired
//	private TestRestTemplate restTemplate;
//
//	@Test
//	public void contextLoads() throws Exception {
//		Assertions.assertThat(studentController).isNotNull();
//	}


}
