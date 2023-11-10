package com.company;

public class Deposit extends Account implements MainBank {
    public Deposit(String name, String accountType, String accountNumber, double initialBalance) {
        super(name,accountType, accountNumber, initialBalance);
    }

    @Override
    public void getBalanceInfo() {
        System.out.println("Balance: " + balance);
    }

    @Override
    public void withdraw(double amount) {

    }

    @Override
    public void deposit(double amount) {

    }

    @Override
    public void showAccount() {

    }
}
