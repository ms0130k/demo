package com.example.demo.controller;

import com.example.demo.domain.Coffee;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class RestApiDemoController {
    private List<Coffee> coffees = new ArrayList<>();

    public RestApiDemoController() {
        coffees.addAll(List.of(
                new Coffee("Cafe Cereza"),
                new Coffee("Cafe Ganador"),
                new Coffee("Cafe Lareno"),
                new Coffee("Cafe Tres Pontas")
        ));

    }

    @GetMapping("/coffees")
    public Iterable<Coffee> getCoffees() {
        return coffees;
    }

    @GetMapping("/coffees/{id}")
    Optional<Coffee> getCoffeeById(@PathVariable String id) {
        return coffees.stream()
                .filter(coffee -> id.equals(coffee.getId()))
                .findFirst();
    }

    @PostMapping("/coffees")
    public Coffee postCoffee(@RequestBody Coffee coffee) {
        coffees.add(coffee);
        return coffee;
    }

    @PutMapping("/coffees/{id}")
    public ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
        Optional<Coffee> coffeeOptional = getCoffeeById(id);
        if (coffeeOptional.isPresent()) {
            Coffee existingCoffee = coffeeOptional.get();
            existingCoffee.setName(coffee.getName());
            return ResponseEntity.ok(existingCoffee);
        } else {
            coffee.setId(id);
            coffees.add(coffee);
            return ResponseEntity.status(HttpStatus.CREATED).body(coffee);
        }
    }

    @DeleteMapping("/coffees/{id}")
    public void deleteCoffee(@PathVariable String id) {
        coffees.removeIf(coffee -> id.equals(coffee.getId()));
    }
}
