package com.samuellaw.springbootwebflux_assign2_samuel_law.service;

import com.samuellaw.springbootwebflux_assign2_samuel_law.model.Savings;
import com.samuellaw.springbootwebflux_assign2_samuel_law.repository.SavingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SavingsService {

    @Autowired
    private SavingsRepository savingsRepository;

    public Flux<Savings> getAll() {
        return savingsRepository.findAll();
    }

    public Mono<Savings> getById(String id) {
        return savingsRepository.findById(id);
    }

    public Mono<Savings> create(Savings savings) {
        return savingsRepository.save(savings);
    }

    public Mono<Savings> update(String id, Savings savings) {
        return savingsRepository.findById(id).flatMap(existing -> {
            existing.setAccountHolder(savings.getAccountHolder());
            existing.setBalance(savings.getBalance());
            existing.setInterestRate(savings.getInterestRate());
            return savingsRepository.save(existing);
        });
    }

    public Mono<Void> delete(String id) {
        return savingsRepository.deleteById(id);
    }

    public Mono<Savings> applyMonthlyInterest(String id) {
        return savingsRepository.findById(id).flatMap(existing -> {
            existing.depositMonthlyInterest();
            return savingsRepository.save(existing);
        });
    }
}
