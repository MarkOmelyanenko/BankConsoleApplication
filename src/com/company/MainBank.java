package com.company;

// interface to highlight common features between Personal, Deposit, Credit classes
interface MainBank {
    // get current balance
    void getBalanceInfo();

    // withdraw money
    void withdraw(double amount);

    // deposit money
    void deposit(double amount) throws InterruptedException;

    // show account information
    void showAccount();
}
