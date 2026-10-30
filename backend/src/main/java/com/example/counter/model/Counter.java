package com.example.counter.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Counter {

    public static final long DEFAULT_ID = 1L;

    @Id
    private Long id;
    // "value" is a reserved word in H2, so map to a different column name.
    @Column(name = "counter_value", nullable = false)
    private long value;

    protected Counter() {
    }

    public Counter(Long id, long value) {
        this.id = id;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public long getValue() {
        return value;
    }
}
