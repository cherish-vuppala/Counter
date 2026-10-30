package com.example.counter.config;

import com.example.counter.model.Counter;
import com.example.counter.repository.CounterRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    // Seed the single counter row on first startup only.
    @Bean
    ApplicationRunner seedCounter(CounterRepository repository) {
        return args -> {
            if (!repository.existsById(Counter.DEFAULT_ID)) {
                repository.save(new Counter(Counter.DEFAULT_ID, 0));
            }
        };
    }
}
