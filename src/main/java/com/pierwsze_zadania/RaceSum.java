package com.pierwsze_zadania;

import java.util.*;

class RaceSum {
    public static void main(String[] args) {
        int sumA = 1000;
        int sumB = 0;
        int loopCounter = 0;
        Random randGen = new Random();
        while (sumA > sumB) {
            sumA += randGen.nextInt(10);
            sumB += randGen.nextInt(50);
            loopCounter++;
            System.out.println("Petla nr: " + loopCounter + ", sumA = " + sumA + ", sumB = " + sumB);
        }
        System.out.println("\nPo wykonaniu petli nr: " + loopCounter + " warunek wykonywania petli while osiagnal: " + (sumA > sumB));
    }
}
