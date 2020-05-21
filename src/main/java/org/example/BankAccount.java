package org.example;

public class BankAccount {

    private String accountNumber;
    private Double balance;
    private UserRunnable user;

    public BankAccount(String pAccountNumber, Double pBalance) {
        accountNumber = pAccountNumber;
        balance = pBalance;
    }

    public synchronized String getAccountNumber() throws InterruptedException {
        return accountNumber;

    }

    public synchronized Double getBalance() throws InterruptedException {
        return balance;
    }
    //se le agrega synchronized al metodo para que los cambios en el estado del objeto sean vistos para todos los hilos

    public void setBalance(Double balance) {
        this.balance = balance;
    }


}
