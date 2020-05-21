package org.example;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {


        BankAccount account = new BankAccount("1234", 500000.00);


        Thread threadUser1 = new Thread(new UserRunnable(10000.00, 125000.00, account));
        Thread threadUser2 = new Thread(new UserRunnable(12000.00, 200000.00, account));
        Thread threadManager = new Thread(new BankManager(account));

        //ReentrantLock reentrantLock = new ReentrantLock();
        //reentrantLock.lock();

        threadUser1.start();

        try {
            threadUser1.join();
        } catch (Exception e) {
            System.out.println("Hilo interrupido");
        }


        threadUser2.start();
        try {
            threadUser2.join();
        } catch (Exception e) {
            System.out.println("Hilo interrupido");
        }


        threadManager.start();
        try {
            threadManager.join();
        } catch (InterruptedException e) {
            System.out.println("Hilo interrupido");
        }



        System.out.println("Finalizacion de todos los hilos");


    }
}
