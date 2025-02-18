package com.example.demo.sample.layered.service;

import com.example.demo.sample.layered.domain.Coffee;

public interface CoffeeService {
    Iterable<Coffee> findAll();
    Coffee findById(Long id);
    Coffee save(Coffee coffee);
    void deleteById(Long id);
    boolean existsById(Long id);
}
