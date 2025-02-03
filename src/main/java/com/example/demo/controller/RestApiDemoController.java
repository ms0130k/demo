package com.example.demo.controller;

import com.example.demo.domain.Coffee;
import com.example.demo.repository.CoffeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class RestApiDemoController {
    private final CoffeeRepository coffeeRepository;

    public RestApiDemoController(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @GetMapping("/coffees")
    public Iterable<Coffee> getCoffees() {
        return coffeeRepository.findAll();
    }

    @GetMapping("/coffees/{id}")
    Optional<Coffee> getCoffeeById(@PathVariable String id) {
        for (Coffee coffee : coffeeRepository.findAll()) {
            if (id.equals(coffee.getId())) {
                return Optional.of(coffee);
            }
        }
        return Optional.empty();
    }

    @PostMapping("/coffees")
    public Coffee postCoffee(@RequestBody Coffee coffee) {
        return coffeeRepository.save(coffee);
    }

    @PutMapping("/coffees/{id}")
    public ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
        boolean exists = coffeeRepository.existsById(id);
        coffee.setId(id);
        coffeeRepository.save(coffee);
        return exists
                ? ResponseEntity.ok(coffee)
                : ResponseEntity.status(HttpStatus.CREATED).body(coffee);
    }

    @DeleteMapping("/coffees/{id}")
    public void deleteCoffee(@PathVariable String id) {
        coffeeRepository.deleteById(id);
    }
}
