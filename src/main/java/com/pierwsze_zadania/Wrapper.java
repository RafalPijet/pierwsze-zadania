package com.pierwsze_zadania;

class Wrapper {
    public static void main (String[] args) {
        int i = 100;
        Integer iWrap = 100;
        System.out.println("czy wartosci i oraz iWrap sa rowne? --> " + (i == iWrap) + " --> " + iWrap.hashCode());
        float f = 123.56f;
        Float fWrap = 123.56f;
        System.out.println("czy wartosci f oraz fWrap sa rowne? --> " + (f == fWrap) + " --> " + fWrap.hashCode());
        double d = 678.96d;
        Double dWrap = 678.96d;
        System.out.println("czy wartosci d oraz dWrap sa rowne? --> " + (d == dWrap) + " --> " + dWrap.hashCode());
        long l = 12367788L;
        Long lWrap = 12367788L;
        System.out.println("czy wartosci l oraz lWrap sa rowne? --> " + (l == lWrap) + " --> " + lWrap.hashCode());
        short s = -31567;
        Short sWrap = -31567;
        System.out.println("czy wartosci s oraz sWrap sa rowne? --> " + (s == sWrap) + " --> " + sWrap.hashCode());
        byte b = 102;
        Byte bWrap = 102;
        System.out.println("czy wartosci b oraz bWrap sa rowne? --> " + (b == bWrap) + " --> " + bWrap.hashCode());
        char c = 'X';
        Character cWrap = 'X';
        System.out.println("czy wartosci c oraz cWrap sa rowne? --> " + (c == cWrap) + " --> " + cWrap.hashCode());
        boolean trueOrFalse = true;
        Boolean trueOrFalseWrap = true;
        System.out.println("czy wartosci trueOrFalse oraz trueOrFalseWrap sa rowne? --> " + (trueOrFalse == trueOrFalseWrap) + " --> " + trueOrFalseWrap.hashCode());
    }
}
