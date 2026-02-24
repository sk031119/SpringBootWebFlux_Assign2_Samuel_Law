package com.samuellaw.springbootwebflux_assign2_samuel_law.controller;

import com.samuellaw.springbootwebflux_assign2_samuel_law.model.Savings;
import com.samuellaw.springbootwebflux_assign2_samuel_law.service.SavingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/savings")
public class SavingsController {

    @Autowired
    private SavingsService savingsService;

    @GetMapping
    public Flux<Savings> getAll() {
        return savingsService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<Savings> getById(@PathVariable String id) {
        return savingsService.getById(id);
    }

    @PostMapping
    public Mono<Savings> create(@RequestBody Savings savings) {
        return savingsService.create(savings);
    }

    @PutMapping("/{id}")
    public Mono<Savings> update(@PathVariable String id, @RequestBody Savings savings) {
        return savingsService.update(id, savings);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return savingsService.delete(id);
    }

    // apply monthly interest to the given account
    @PutMapping("/{id}/monthly-interest")
    public Mono<Savings> applyMonthlyInterest(@PathVariable String id) {
        return savingsService.applyMonthlyInterest(id);
    }
}
