package com.company;

public class Personal extends Account implements MainBank {
    public Personal(String name, String accountType, String accountNumber, double initialBalance) {
        super(name,accountType, accountNumber, initialBalance);
    }

    @Override
    public void getBalanceInfo() {
        System.out.printf("Balance: $%.2f", balance);
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
        System.out.printf("""
                You have withdrawn $%d
                Your new balance: $%d
                """, amount, balance);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.printf("""
                You have deposited $%d
                Your new balance: $%d
                """, amount, balance);
    }

    @Override
    public void showAccount() {
        System.out.printf("""
                Name: %s
                Account type: %s
                Account number: %s
                Balance: $%.2f
                """, name, accountType, accountNumber, balance);
    }
}
