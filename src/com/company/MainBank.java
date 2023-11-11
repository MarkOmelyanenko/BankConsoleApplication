package com.company;

interface MainBank {
    void getBalanceInfo();
    void withdraw(double amount);
    void deposit(double amount) throws InterruptedException;
    void showAccount();
}
