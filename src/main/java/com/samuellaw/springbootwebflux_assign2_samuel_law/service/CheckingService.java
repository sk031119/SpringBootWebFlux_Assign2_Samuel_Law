package com.samuellaw.springbootwebflux_assign2_samuel_law.service;

import com.samuellaw.springbootwebflux_assign2_samuel_law.model.Checking;
import com.samuellaw.springbootwebflux_assign2_samuel_law.repository.CheckingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CheckingService {

    @Autowired
    private CheckingRepository checkingRepository;

    public Flux<Checking> getAll() {
        return checkingRepository.findAll();
    }

    public Mono<Checking> getById(String id) {
        return checkingRepository.findById(id);
    }

    public Mono<Checking> create(Checking checking) {
        return checkingRepository.save(checking);
    }

    public Mono<Checking> update(String id, Checking checking) {
        return checkingRepository.findById(id).flatMap(existing -> {
            existing.setAccountHolder(checking.getAccountHolder());
            existing.setBalance(checking.getBalance());
            existing.setInsufficientFundFee(checking.getInsufficientFundFee());
            return checkingRepository.save(existing);
        });
    }

    public Mono<Void> delete(String id) {
        return checkingRepository.deleteById(id);
    }

    public Mono<Checking> processCheck(String id, double checkAmount) {
        return checkingRepository.findById(id).flatMap(existing -> {
            existing.processingCheck(checkAmount);
            return checkingRepository.save(existing);
        });
    }
}
