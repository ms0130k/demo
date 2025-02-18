package com.example.demo.sample.layered.controller;

import com.example.demo.sample.layered.domain.Coffee;
import com.example.demo.sample.layered.service.CoffeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CoffeeController {
    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @GetMapping("/coffees")
    public Iterable<Coffee> getCoffees() {
        return coffeeService.findAll();
    }

    @GetMapping("/coffees/{id}")
    Coffee getCoffeeById(@PathVariable Long id) {
        return coffeeService.findById(id);
    }

    @PostMapping("/coffees")
    public Coffee postCoffee(@RequestBody Coffee coffee) {
        return coffeeService.save(coffee);
    }

    @PutMapping("/coffees/{id}")
    public ResponseEntity<Coffee> putCoffee(@PathVariable Long id, @RequestBody Coffee coffee) {
        boolean exists = coffeeService.existsById(id);
        coffeeService.save(coffee);
        return exists
                ? ResponseEntity.ok(coffee)
                : ResponseEntity.status(HttpStatus.CREATED).body(coffee);
    }

    @DeleteMapping("/coffees/{id}")
    public void deleteCoffee(@PathVariable Long id) {
        coffeeService.deleteById(id);
    }
}
