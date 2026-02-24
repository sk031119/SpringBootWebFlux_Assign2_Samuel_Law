package com.samuellaw.springbootwebflux_assign2_samuel_law.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "checking")
public class Checking implements Account {

    @Id
    private String id;
    private String accountHolder;
    private double balance;
    private double insufficientFundFee;

    @Override
    public void deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public void withdrawal(double amount) {
        if (amount > this.balance) {
            this.balance -= insufficientFundFee;
        } else {
            this.balance -= amount;
        }
    }

    @Override
    public void updateBalance(double newBalance) {
        this.balance = newBalance;
    }

    // process a check by deducting the check amount
    public void processingCheck(double check) {
        withdrawal(check);
    }
}
