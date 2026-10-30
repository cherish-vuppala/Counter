package com.example.counter.service;

import com.example.counter.dto.CounterResponse;
import com.example.counter.exception.CounterNotFoundException;
import com.example.counter.model.Counter;
import com.example.counter.repository.CounterRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CounterService {

    private final CounterRepository repository;

    public CounterService(CounterRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public CounterResponse get() {
        return new CounterResponse(load());
    }

    @Transactional
    public CounterResponse increment() {
        return change(1);
    }

    @Transactional
    public CounterResponse decrement() {
        return change(-1);
    }

    @Transactional
    public CounterResponse reset() {
        requireUpdated(repository.resetValue(Counter.DEFAULT_ID));
        return new CounterResponse(load());
    }

    private CounterResponse change(long delta) {
        requireUpdated(repository.addToValue(Counter.DEFAULT_ID, delta));
        return new CounterResponse(load());
    }

    private long load() {
        return repository.findById(Counter.DEFAULT_ID)
                .orElseThrow(CounterNotFoundException::new)
                .getValue();
    }

    private void requireUpdated(int rows) {
        if (rows == 0) {
            throw new CounterNotFoundException();
        }
    }
}
