package com.pierwsze_zadania;

class Substract {
    public double substractAfromB(double a, double b) {
        return a - b;
    }
}

class Add {
    public double addAtoB(double a, double b) {
        return a + b;
    }
}

class Ratio {
    public double addAtoB(double a, double b) {
        return a * b;
    }
}

class Application7 {
    public static void main (String[] args) {
        Substract goSub = new Substract();
        Add goAdd = new Add();
        Ratio goRat = new Ratio();
        int result1 = goSub.hashCode();
        int result2 = goSub.hashCode();
        int result3 = goAdd.hashCode();
        int result4 = goRat.hashCode();
        System.out.println("class Substract: " + result1);
        System.out.println("class Substract: " + result2);
        System.out.println("class Add: " + result3);
        System.out.println("class Rat: " + result4);
    }
}
