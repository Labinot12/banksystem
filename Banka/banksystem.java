import java.util.HashMap;
import java.util.Map;

class Account {
    private String account_id;
    private String user_name;
    private double balance;

    public Account(String account_id, String user_name, double initial_balance) {
        this.account_id = account_id;
        this.user_name = user_name;
        this.balance = initial_balance;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Insufficient funds");
        }
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}

class Transaction {
    private double amount;
    private String originating_account_id;
    private String resulting_account_id;
    private String reason;

    public Transaction(double amount, String originating_account_id, String resulting_account_id, String reason) {
        this.amount = amount;
        this.originating_account_id = originating_account_id;
        this.resulting_account_id = resulting_account_id;
        this.reason = reason;
    }
}

class Bank {
    private String bank_name;
    private Map<String, Account> accounts;
    private double total_transaction_fee_amount;
    private double total_transfer_amount;
    private double transaction_flat_fee_amount;
    private double transaction_percent_fee_value;

    public Bank(String bank_name, double transaction_flat_fee, double transaction_percent_fee) {
        this.bank_name = bank_name;
        this.accounts = new HashMap<>();
        this.total_transaction_fee_amount = 0.0;
        this.total_transfer_amount = 0.0;
        this.transaction_flat_fee_amount = transaction_flat_fee;
        this.transaction_percent_fee_value = transaction_percent_fee;
    }

    public void createAccount(String account_id, String user_name) {
        if (accounts.containsKey(account_id)) {
            throw new IllegalArgumentException("Account ID already exists");
        }
        accounts.put(account_id, new Account(account_id, user_name, 0.0));
    }

    public Account getAccount(String account_id) {
        if (!accounts.containsKey(account_id)) {
            throw new IllegalArgumentException("Invalid account ID");
        }
        return accounts.get(account_id);
    }

    public Transaction performTransaction(String originating_account_id, String resulting_account_id,
                                          double amount, String reason) {
        if (!accounts.containsKey(originating_account_id) || !accounts.containsKey(resulting_account_id)) {
            throw new IllegalArgumentException("Invalid account ID");
        }

        Account originatingAccount = accounts.get(originating_account_id);
        Account resultingAccount = accounts.get(resulting_account_id);

        double transaction_fee = transaction_flat_fee_amount +
                (transaction_percent_fee_value * amount / 100);

        originatingAccount.withdraw(amount + transaction_fee);
        resultingAccount.deposit(amount);

        total_transaction_fee_amount += transaction_fee;
        total_transfer_amount += amount;

        return new Transaction(amount, originating_account_id, resulting_account_id, reason);
    }

    public double getAccountBalance(String account_id) {
        if (!accounts.containsKey(account_id)) {
            throw new IllegalArgumentException("Invalid account ID");
        }
        return accounts.get(account_id).getBalance();
    }

    public double getTotalTransactionFee() {
        return total_transaction_fee_amount;
    }

    public double getTotalTransferAmount() {
        return total_transfer_amount;
    }

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
}
