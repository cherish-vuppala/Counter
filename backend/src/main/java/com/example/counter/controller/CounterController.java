package com.example.counter.controller;

import com.example.counter.dto.CounterResponse;
import com.example.counter.service.CounterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/counter")
public class CounterController {

    private final CounterService service;

    public CounterController(CounterService service) {
        this.service = service;
    }

    @GetMapping
    public CounterResponse get() {
        return service.get();
    }

    @PostMapping("/increment")
    public CounterResponse increment() {
        return service.increment();
    }

    @PostMapping("/decrement")
    public CounterResponse decrement() {
        return service.decrement();
    }

    @PostMapping("/reset")
    public CounterResponse reset() {
        return service.reset();
    }
}
