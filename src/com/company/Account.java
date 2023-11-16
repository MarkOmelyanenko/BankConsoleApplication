package com.company;

// class to highlight common variables between Personal, Deposit, Credit classes
class Account {
    protected String name, accountType, accountNumber;
    protected double balance;

    public Account(String name, String accountType, String accountNumber, double balance) {
        this.name = name;
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}
