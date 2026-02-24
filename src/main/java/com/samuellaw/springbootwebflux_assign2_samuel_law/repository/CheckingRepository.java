package com.samuellaw.springbootwebflux_assign2_samuel_law.repository;

import com.samuellaw.springbootwebflux_assign2_samuel_law.model.Checking;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckingRepository extends ReactiveMongoRepository<Checking, String> {
}
