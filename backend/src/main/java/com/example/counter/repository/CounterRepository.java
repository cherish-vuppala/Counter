package com.example.counter.repository;

import com.example.counter.model.Counter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CounterRepository extends JpaRepository<Counter, Long> {

    // Single atomic UPDATE: no read-modify-write race between concurrent requests.
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update Counter c set c.value = c.value + :delta where c.id = :id")
    int addToValue(@Param("id") Long id, @Param("delta") long delta);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update Counter c set c.value = 0 where c.id = :id")
    int resetValue(@Param("id") Long id);
}
