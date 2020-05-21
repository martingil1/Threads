package org.example;

public class BankManager implements Runnable {

    private BankAccount account;

    public BankManager(BankAccount pAccount) {
        account = pAccount;
    }


    @Override
    public void run() {
        try {
            System.out.println("Soy el gerente y la cuenta ahora tiene: $"+account.getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
