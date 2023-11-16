package com.company;

public class Deposit extends Account implements MainBank {
    private final double depositRate = 0.05;

    public Deposit(String name, String accountType, String accountNumber, double initialBalance) {
        super(name, accountType, accountNumber, initialBalance);
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
        } else System.out.println("\nThere are not enough funds on the account");
    }

    @Override
    public void deposit(double amount) throws InterruptedException {
        balance += amount;

        System.out.println("!!!Every 1 second up to 5 seconds your " +
                "deposit will increase by 5%!!!");

        // earning % on deposit funds(every second +5%)
        for (int i = 1; i <= 5; i++) {
            Thread.sleep(1000);
            System.out.println(i + "s passed...");
            balance += balance * depositRate;
        }

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
                        Deposit rate: %.2f%%
                        """, name, accountType, accountNumber,
                balance, depositRate * 100);
    }
}
