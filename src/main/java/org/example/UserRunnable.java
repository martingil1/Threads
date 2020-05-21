package org.example;

public class UserRunnable implements Runnable {

    private Double deposit;
    private Double withdraw;
    private BankAccount account;

    public UserRunnable(Double pDeposit, Double pWithdraw, BankAccount pAccount) {
        deposit = pDeposit;
        withdraw = pWithdraw;
        account = pAccount;
    }

    public Double getDeposit() {
        return deposit;
    }


    public Double getWithdraw() {
        return withdraw;
    }


    @Override
    public void run() {

        try {
            if (getWithdraw() < account.getBalance()) {
                Double aux = account.getBalance() + getDeposit() - getWithdraw();
                account.setBalance(aux);
                System.out.println("Cliente depositó $" + getDeposit() + " y retiró: $" + getWithdraw() + " Saldo: $" + account.getBalance());
            }else{
                System.out.println("Saldo insuficiente.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
