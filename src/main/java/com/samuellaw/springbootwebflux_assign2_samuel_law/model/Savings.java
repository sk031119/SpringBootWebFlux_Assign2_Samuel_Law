package com.samuellaw.springbootwebflux_assign2_samuel_law.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "savings")
public class Savings implements Account {

    @Id
    private String id;
    private String accountHolder;
    private double balance;
    private double interestRate;

    @Override
    public void deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public void withdrawal(double amount) {
        this.balance -= amount;
    }

    @Override
    public void updateBalance(double newBalance) {
        this.balance = newBalance;
    }

    // deposit monthly interest based on interest rate
    public void depositMonthlyInterest() {
        this.balance += this.balance * (this.interestRate / 100);
    }
}
