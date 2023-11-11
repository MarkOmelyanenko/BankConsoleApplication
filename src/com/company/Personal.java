package com.company;

public class Personal extends Account implements MainBank {
    public Personal(String name, String accountType, String accountNumber, double initialBalance) {
        super(name,accountType, accountNumber, initialBalance);
    }

    @Override
    public void getBalanceInfo() {
        System.out.printf("Balance: $%.2f \n", balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.printf("""
                You have withdrawn $%.2f
                Your new balance: $%.2f
                """, amount, balance);
        } else System.out.println("There are not enough funds on the account");
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.printf("""
                You have deposited $%.2f
                Your new balance: $%.2f
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
