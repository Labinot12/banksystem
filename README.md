Bank System Console Application
This console application simulates a basic bank system with multiple user accounts and transaction functionality. Users can create accounts, perform transactions (including flat fee and percent fee transactions), check balances, and view transaction history.

Features
Account Management:
Create new accounts.
Deposit money into an account.
Withdraw money from an account.
Transaction Handling:
Perform transactions between accounts (transfer, deposit, withdrawal).
Collect transaction fees (flat fee or percent fee).
Bank Information:
View account balances.
List all accounts.
Check total transaction fees.
Check total transfer amount.
Getting Started
Prerequisites:
Java Development Kit (JDK) installed on your system.
Clone the Repository:
git clone https://github.com/Labinot12/bank-system.git
cd bank-system

Compile and Run:
javac BankSystemApp.java
java BankSystemApp

Usage:
Follow the prompts to create accounts and perform transactions.
Use account IDs (e.g., “A123”) to reference specific accounts.
Implementation Details
The Bank class manages accounts, transactions, and fees.
The Account class represents individual user accounts.
The Transaction class stores transaction details.
Exceptions are thrown for invalid inputs (e.g., insufficient funds, invalid account IDs).
Example Usage
Java

public static void main(String[] args) {
    Bank myBank = new Bank("My Bank", 10.0, 5.0);
    myBank.createAccount("A123", "Alice");
    myBank.createAccount("B456", "Bob");

    myBank.performTransaction("A123", "B456", 100.0, "transfer");
    System.out.println("Alice's balance: $" + myBank.getAccountBalance("A123"));
    System.out.println("Bob's balance: $" + myBank.getAccountBalance("B456"));
    System.out.println("Total transaction fee: $" + myBank.getTotalTransactionFee());
    System.out.println("Total transfer amount: $" + myBank.getTotalTransferAmount());
}
