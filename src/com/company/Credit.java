package com.company;

public class Credit extends Account implements MainBank {
    private double debt = 0;
    private final double creditRate = 0.1;

    public Credit(String name, String accountType, String accountNumber, double initialBalance) {
        super(name,accountType, accountNumber, initialBalance);
    }

    // TODO: print negative balance if user has a debt
    @Override
    public void getBalanceInfo() {
        System.out.println("Your balance: " + balance + "$");
    }

    @Override
    public void withdraw(double amount) {
        if (debt == 0) {
            balance -= amount;
            debt = (amount * creditRate) + amount;
            System.out.printf("""
                
                You have withdrawn $%.2f
                Your debt: $%.2f
                """, amount, debt);
        } else System.out.println("You have a debt! Pay it off first!");
    }

    @Override
    public void deposit(double amount) {
        if (debt == 0) System.out.println("You have no dept to make deposit.");
        else {
            balance += amount;
            debt -= amount;
            System.out.printf("""
                
                You have deposited $%.2f
                Your debt: $%.2f
                """, amount, debt);
        }
    }

    @Override
    public void showAccount() {
        System.out.printf("""
                
                -----Account info-----
                Name: %s
                Account type: %s
                Account number: %s
                Debt: $%.2f
                Credit rate: %.2f%%
                """, name, accountType, accountNumber,
                debt, creditRate * 100);
    }
}
