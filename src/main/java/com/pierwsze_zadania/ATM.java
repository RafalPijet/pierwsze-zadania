package com.pierwsze_zadania;

import java.util.*;

interface ATM {
    public void paymantOfMoney(double sum);
    public void moneyPaymant(double sum);
    default boolean isConnection() {
        System.out.println("I check the connection...");
        Random r = new Random();
        double randomNum = Math.round(10 * (r.nextDouble()));
        if (randomNum > 3) {
            System.out.println("Status online");
            return true;
        } else
            return false;
    }
    static void endingOperation() {
        System.out.println("Operacja została zakończona pomyślnie");
    }
}
class ATMImpl implements ATM {
    public void paymantOfMoney(double sum) {
        System.out.println("Wpłaciłeś kwotę " + sum + " PLN");
    }
    public void moneyPaymant(double sum) {
        System.out.println("Wypłaciłeś kwotę " + sum + " PLN");
    }
}

class Application11 {
    public static void main(String[] args) {
        ATMImpl myATM = new ATMImpl();
        double cashInsite = 1450.76;
        double cashOutsite = 350.5;
        boolean check = myATM.isConnection();
        if (check) {
            myATM.paymantOfMoney(cashInsite);
            ATM.endingOperation();
            System.out.println();
            myATM.moneyPaymant(cashOutsite);
            ATM.endingOperation();
        } else {
            System.out.println("Error of connection...");
            System.out.println("Status: offline");
        }
    }
}
