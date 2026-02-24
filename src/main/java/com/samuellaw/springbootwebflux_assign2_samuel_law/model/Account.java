package com.samuellaw.springbootwebflux_assign2_samuel_law.model;

public interface Account {

    String getAccountHolder();

    double getBalance();

    void deposit(double amount);

    void withdrawal(double amount);

    void updateBalance(double newBalance);
}
