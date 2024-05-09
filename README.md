# Simple Bank System in Java

This repository contains a simple implementation of a bank system in Java.

## Classes

The system is comprised of three main classes:

1. `Account`: Represents a bank account with basic functionalities such as deposit and withdraw.

2. `Transaction`: Represents a transaction between two accounts.

3. `Bank`: Represents a bank that manages multiple accounts and transactions.

## Usage

To run the program, you need to compile and run the `Bank` class. Here are the steps:

1. Open a terminal or command prompt in the directory where your `Bank.java` file is located.

2. Compile the Java file using the `javac` command:

```bash
javac Bank.java

Run the compiled Java program using the java command:
java Bank

The main method in this class sets up a simple scenario with two accounts and performs a transaction between them.

Java

public static void main(String[] args) {
    Bank myBank = new Bank("My Bank", 10.0, 5.0);
    myBank.createAccount("A123", "Alice");
    myBank.createAccount("B456", "Bob");

    // Deposit an initial amount into Alice's account
    Account aliceAccount = myBank.getAccount("A123");
    aliceAccount.deposit(200.0);

    myBank.performTransaction("A123", "B456", 100.0, "transfer");
    System.out.println("Alice's balance: $" + myBank.getAccountBalance("A123"));
    System.out.println("Bob's balance: $" + myBank.getAccountBalance("B456"));
    System.out.println("Total transaction fee: $" + myBank.getTotalTransactionFee());
    System.out.println("Total transfer amount: $" + myBank.getTotalTransferAmount());
}
