package com.samuellaw.springbootwebflux_assign2_samuel_law.controller;

import com.samuellaw.springbootwebflux_assign2_samuel_law.model.Checking;
import com.samuellaw.springbootwebflux_assign2_samuel_law.service.CheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/checking")
public class CheckingController {

    @Autowired
    private CheckingService checkingService;

    @GetMapping
    public Flux<Checking> getAll() {
        return checkingService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<Checking> getById(@PathVariable String id) {
        return checkingService.getById(id);
    }

    @PostMapping
    public Mono<Checking> create(@RequestBody Checking checking) {
        return checkingService.create(checking);
    }

    @PutMapping("/{id}")
    public Mono<Checking> update(@PathVariable String id, @RequestBody Checking checking) {
        return checkingService.update(id, checking);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return checkingService.delete(id);
    }

    // process a check for the given account
    @PutMapping("/{id}/process-check")
    public Mono<Checking> processCheck(@PathVariable String id, @RequestParam double amount) {
        return checkingService.processCheck(id, amount);
    }
}
