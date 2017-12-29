package com.pierwsze_zadania;

import java.util.*;

class Book1 {
    private String title;
    private String author;
    private int year;

    public Book1(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return "\"" + title.toUpperCase() + "\", " + author + ", (" + year + ")";
    }
}

class Stack {
    private ArrayDeque<Book1> queueBooks;

    public Stack() {
        queueBooks = new ArrayDeque<Book1>();
        createNewStack();
    }

    public int getSize() {
        return queueBooks.size();
    }

    public void eraseAll() {
        for (Book1 book : queueBooks) {
            queueBooks.pop();
        }
    }

    public void eraseAllAndShowLast() {
        Book1 tempBook = null;
        for (Book1 book : queueBooks) {
            tempBook = queueBooks.pop();
        }
        System.out.println(tempBook);
    }

    public void showAll() {
        for (Book1 book : queueBooks) {
            System.out.println(book);
        }
    }

    public Book1 showFirst() {
        return queueBooks.peek();
    }

    public Book1 eraseFirstAndShow() {
        return queueBooks.pop();
    }

    public void createNewStack() {
        queueBooks.push(new Book1("50 shades of Grey", "E.L. James", 2001));
        queueBooks.push(new Book1("Sherlock Holmes", "Arthur Conan Doyle", 2009));
        queueBooks.push(new Book1("The Last Mohikan", "James Fenimore Cooper", 1988));
        queueBooks.push(new Book1("A Journey Into the Earth", "Jules Verne", 1966));
        queueBooks.push(new Book1("Neverending Story", "Michael Ende", 1992));
    }
}

class Application2 {
    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println("1) Stworzono nowy stos - kolejka typu LIFO");
        System.out.println("-------> obecny rozmiar stosu: " + stack.getSize());
        stack.eraseAll();
        System.out.println("Usunieto wszystkie elementy stosu");
        System.out.println("-------> obecny rozmiar stosu: " + stack.getSize());
        stack.createNewStack();
        System.out.println("2) Stworzono nowy stos - kolejka typu LIFO");
        System.out.println("-------> obecny rozmiar stosu: " + stack.getSize());
        System.out.println("Tylko pokaz pierwszy element stosu:\n" + stack.showFirst());
        System.out.println("-------> obecny rozmiar stosu: " + stack.getSize());
        System.out.println("Pokaz i usun pierwszy element stosu:\n" + stack.eraseFirstAndShow());
        System.out.println("-------> obecny rozmiar stosu: " + stack.getSize());
        System.out.println("Pokaz i usun pierwszy element stosu:\n" + stack.eraseFirstAndShow());
        System.out.println("-------> obecny rozmiar stosu: " + stack.getSize());
        System.out.println("Pokaz i usun pierwszy element stosu:\n" + stack.eraseFirstAndShow());
        System.out.println("-------> obecny rozmiar stosu: " + stack.getSize());
        System.out.println("Pokaz i usun pierwszy element stosu:\n" + stack.eraseFirstAndShow());
        System.out.println("-------> obecny rozmiar stosu: " + stack.getSize());
        System.out.println("Pokaz i usun pierwszy element stosu:\n" + stack.eraseFirstAndShow());
        System.out.println("-------> obecny rozmiar stosu: " + stack.getSize());
        stack.createNewStack();
        System.out.println("3) Stworzono nowy stos - kolejka typu LIFO");
        System.out.println("-------> obecny rozmiar stosu: " + stack.getSize());
        System.out.println("Pokaz wszystkie elementy stosu:");
        stack.showAll();
        System.out.println("-------> obecny rozmiar stosu: " + stack.getSize());
        System.out.println("Usun wszystkie elementy stosu i pokaz ostatni usuniety:");
        stack.eraseAllAndShowLast();
        System.out.println("-------> obecny rozmiar stosu: " + stack.getSize());

    }
}
