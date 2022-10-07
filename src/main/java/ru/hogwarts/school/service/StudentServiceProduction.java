package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("production")
public class StudentServiceProduction {

    @Value("${server.port}")
    private String serverPort;
    Logger logger = LoggerFactory.getLogger(StudentServiceProduction.class);
    public String getPortProduction() {
        logger.debug(serverPort);
        return serverPort;
    }
}
