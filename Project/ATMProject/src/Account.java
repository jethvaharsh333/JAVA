import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountNumber;
    private double balance;
    private double cashBalance;
    private double chequeBalance;
    private List<String> transactionHistory;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.cashBalance = 0.0;
        this.chequeBalance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public double getCashBalance() {
        return cashBalance;
    }

    public double getChequeBalance() {
        return chequeBalance;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrawal: -$" + amount);
        } else {
            throw new InsufficientFundsException("Invalid withdrawal amount or insufficient balance.");
        }
    }

    public void depositCash(double amount) {
        if (amount > 0) {
            cashBalance += amount;
            balance += amount;
            transactionHistory.add("Cash Deposit: +$" + amount);
        } else {
            throw new IllegalArgumentException("Invalid cash deposit amount.");
        }
    }

    public void depositCheque(double amount) {
        if (amount > 0) {
            chequeBalance += amount;
            balance += amount;
            transactionHistory.add("Cheque Deposit: +$" + amount);
        } else {
            throw new IllegalArgumentException("Invalid cheque deposit amount.");
        }
    }

    public void transfer(double amount, Account recipient) throws InsufficientFundsException {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            recipient.balance += amount;
            recipient.transactionHistory.add("Transfer from " + accountNumber + ": +$" + amount);
            transactionHistory.add("Transfer to " + recipient.accountNumber + ": -$" + amount);
        } else {
            throw new InsufficientFundsException("Invalid transfer amount or insufficient balance.");
        }
    }
}
