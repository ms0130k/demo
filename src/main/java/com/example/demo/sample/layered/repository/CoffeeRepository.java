package com.example.demo.sample.layered.repository;

import com.example.demo.sample.layered.domain.Coffee;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends CrudRepository<Coffee, Long> {
}
