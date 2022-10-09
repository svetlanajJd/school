package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class InfoService {

    public String sumParallel() {
        long start = System.currentTimeMillis();
        long sum = Stream.iterate(1, a -> a + 1)
                .limit(1_000_000)
                .reduce(0, (a, b) -> a + b);
        long time = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        sum = Stream.iterate(1, a -> a + 1)
                .parallel()
                .limit(1_000_000)
                .reduce(0, (a, b) -> a + b);
        long timeParallel = System.currentTimeMillis() - start;

        return "без распараллеливания " + time + " с распараллеливанием " + timeParallel;
    }
}
