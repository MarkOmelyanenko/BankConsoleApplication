package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("----------Banking Application Started----------");

        Scanner sc = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<>();
        int activeAccountIndex = -1; // index of active account

        int choice;
        do {
            System.out.println("""
                    
                    1. Create a new account
                    2. Switch to another account
                    3. Show account details
                    4. Get balance info
                    5. Withdraw
                    6. Deposit
                    7. Remove account
                    8. Exit""");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("""
                    
                    1. Personal
                    2. Deposit
                    3. Credit
                    Select account type:\040""");

                    int accountType = sc.nextInt();


                    if (accountType != 3) {
                        System.out.print("Enter your name: ");
                        String name = sc.next();
                        System.out.print("Enter initial balance: ");
                        double initialBalance = sc.nextDouble();

                        switch (accountType) {
                            case 1:
                                if (initialBalance < 0) System.out.println("Balance can't be negative.");
                                else {
                                    accounts.add(new Personal(name, "Personal", generateAccountNumber(), initialBalance));
                                }
                                break;
                            case 2:
                                if (initialBalance < 0) System.out.println("Balance can't be negative.");
                                else {
                                    accounts.add(new Deposit(name, "Deposit", generateAccountNumber(), initialBalance));
                                }
                                break;
                            default:
                                System.out.println("Wrong choice.");
                        }
                    } else {
                        System.out.print("Enter your name: ");
                        String name = sc.next();

                        accounts.add(new Credit(name, "Credit", generateAccountNumber(), 0));
                    }
                    break;

                case 2:
                    if (!accounts.isEmpty()) {
                        System.out.println("List of accounts: ");

                        for (int i = 0; i < accounts.size(); i++) {
                            System.out.println((i + 1) + ". " + accounts.get(i).accountType +
                                    " " + accounts.get(i).accountNumber);
                        }

                        System.out.print("Enter account index: ");
                        int switchAccountIndex = sc.nextInt() - 1;

                        if (switchAccountIndex >= 0 && switchAccountIndex < accounts.size()) {
                            activeAccountIndex = switchAccountIndex;
                            System.out.println("Switched to account: " + accounts.get(activeAccountIndex).accountType +
                                    " " + accounts.get(activeAccountIndex).accountNumber);
                        } else System.out.println("\nNo accounts available. Please create an account first.");
                        break;
                    }

                case 3:
                    if (activeAccountIndex != -1) {
                        MainBank activeAccount = (MainBank) accounts.get(activeAccountIndex);
                        activeAccount.showAccount();
                    } else System.out.println("\nNo active account. Please switch to an account first.");
                    break;
                case 4:
                    if (activeAccountIndex != -1) {
                        MainBank activeAccount = (MainBank) accounts.get(activeAccountIndex);
                        activeAccount.getBalanceInfo();
                    } else System.out.println("\nNo active account. Please switch to an account first.");
                    break;
                // withdraw
                    case 5:
                    if (activeAccountIndex != -1) {
                        MainBank activeAccount = (MainBank) accounts.get(activeAccountIndex);

                        // if credit account is active
                        if (activeAccount instanceof Credit) {
                            System.out.print("""
                            
                            !!!Remember: the credit rate is 10% upon return!!!
                            Enter amount to withdraw from credit account:\040""");

                            double amount = sc.nextDouble();

                            activeAccount.withdraw(amount);
                        } else {
                            System.out.print("Enter amount to withdraw from account: ");
                            double amount = sc.nextDouble();
                            activeAccount.withdraw(amount);
                        }
                    } else System.out.println("\nNo active account. Please switch to an account first.");
                    break;
                // deposit
                case 6:
                    if (activeAccountIndex != -1) {
                        MainBank activeAccount = (MainBank) accounts.get(activeAccountIndex);
                        System.out.print("Enter amount to deposit: ");
                        int amount = sc.nextInt();
                        activeAccount.deposit(amount);
                    } else System.out.println("\nNo active account. Please switch to an account first.");
                    break;
                // delete account
                case 7:
                    System.out.println("Select the account from you want to delete from the list: ");

                    for (int i = 0; i < accounts.size(); i++) {
                        System.out.println((i + 1) + ". " + accounts.get(i).accountType +
                                " " + accounts.get(i).accountNumber);
                    }

                    System.out.print("Enter account index: ");
                    int deleteAccountIndex = sc.nextInt() - 1;

                    if (deleteAccountIndex >= 0 && deleteAccountIndex < accounts.size()) {
                        System.out.println("Deleted account: " + accounts.get(deleteAccountIndex).accountType +
                                " " + accounts.get(deleteAccountIndex).accountNumber + "\n");
                        accounts.remove(deleteAccountIndex);
                    } else System.out.println("Wrong choice.");

                    break;
                case 8:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Wrong choice.");
                    break;
            }
        } while (choice != 8);

        sc.close();
    }

    // number account generating
    private static String generateAccountNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(16);

        for (int i = 0; i < 16; i++) {
            sb.append(random.nextInt(10));
        }

        return sb.toString();
    }
}
