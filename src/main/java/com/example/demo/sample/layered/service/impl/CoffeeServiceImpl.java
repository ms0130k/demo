package com.example.demo.sample.layered.service.impl;

import com.example.demo.sample.layered.domain.Coffee;
import com.example.demo.sample.layered.repository.CoffeeRepository;
import com.example.demo.sample.layered.service.CoffeeService;
import org.springframework.stereotype.Service;

@Service
public class CoffeeServiceImpl implements CoffeeService {
    private final CoffeeRepository coffeeRepository;

    public CoffeeServiceImpl(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @Override
    public Iterable<Coffee> findAll() {
        return coffeeRepository.findAll();
    }

    @Override
    public Coffee findById(Long id) {
        return coffeeRepository.findById(id).orElse(null);
    }

    @Override
    public Coffee save(Coffee coffee) {
        return coffeeRepository.save(coffee);
    }

    @Override
    public void deleteById(Long id) {
        coffeeRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return coffeeRepository.existsById(id);
    }
}
