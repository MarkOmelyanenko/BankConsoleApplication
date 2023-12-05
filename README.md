[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/UcJgT9T0)
[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-718a45dd9cf7e7f842a935f5ebbe5719a5e09af4491e668f4dbf3b35d5cca122.svg)](https://classroom.github.com/online_ide?assignment_repo_id=12366153&assignment_repo_type=AssignmentRepo)
<header>

# Java Application to Implement Bank Functionality

The Java program developed here is to implement bank functionality using OOP. The user can create an account, get balance info, withdraw money, deposit, and also get all account information. At first, I created the interface called MainBank to do a few operations mentioned above. Then I created three subclasss Personal, Deposit, and Cerdit that extend the class Account. Also, I created a class Driver to invoke all the methods.

</header>

## OOP using

I use 3 principles of OOP: Inheritance, Polymorphism, and Encapsulation.

#### Inheritance
I have 3 types of accounts: personal, deposit, and credit. They have common fields such as name, account type, account number, and balance. The Account class has a constructor:
```
public Account(String name, String accountType, String accountNumber, double balance) {
        this.name = name;
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.balance = balance;
}
```
If the base class has a constructor, its subclasses must call it.

Personal:
```
public Personal(String name, String accountType, String accountNumber, double initialBalance) {
        super(name,accountType, accountNumber, initialBalance);
}
```
Deposit:
```
public Deposit(String name, String accountType, String accountNumber, double initialBalance) {
        super(name, accountType, accountNumber, initialBalance);
}
```
Credit:
```
public Credit(String name, String accountType, String accountNumber, double initialBalance) {
        super(name, accountType, accountNumber, initialBalance);
}
```

#### Polymorphism
My classes `Personal`, `Deposit`, and `Credit` have common features, but are implemented differently. So I created the MainBank interface:
```
interface MainBank {
    void getBalanceInfo();
    void withdraw(double amount);
    void deposit(double amount) throws InterruptedException;
    void showAccount();
}
```

#### Encapsulation
I used encapsulation because, for example, the `Credit` class has `debt` and `creditRate` variables, which should not be visible from anywhere in the program. Therefore, I used the access modifier `private`:
```
private double debt = 0;
private final double creditRate = 0.1;
```
Encapsulation is also used in the Deposit class:
```
private final double depositRate = 0.05;
```

## Example of UML diagram:
<p align="center"><img align="center" src="https://github.com/dataproctech/long-term-project-java-MarkOmelyanenko-1/blob/main/uml.png?raw=true" height="300" width="400" /></p>
