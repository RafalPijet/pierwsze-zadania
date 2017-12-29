package com.pierwsze_zadania;

import java.util.*;
import java.time.*;

class Book {
    private String title;
    private String author;
    private LocalDate publicationDate;

    public Book(String title, String author, int pubYear, int pubMonth, int pubDay) {
        this.title = title;
        this.author = author;
        this.publicationDate = LocalDate.of(pubYear, pubMonth, pubDay);
    }

    @Override
    public int hashCode() {
        if ((publicationDate.getMonthValue() >= 1) && (publicationDate.getMonthValue() <= 3)) {
            return publicationDate.getYear() * 1000 + 1;
        }
        if ((publicationDate.getMonthValue() >= 4) && (publicationDate.getMonthValue() <= 6)) {
            return publicationDate.getYear() * 1000 + 2;
        }
        if ((publicationDate.getMonthValue() >= 7) && (publicationDate.getMonthValue() <= 9)) {
            return publicationDate.getYear() * 1000 + 3;
        }
        if ((publicationDate.getMonthValue() >= 10) && (publicationDate.getMonthValue() <= 12)) {
            return publicationDate.getYear() * 1000 + 4;
        }
        else {
            return 0;
        }
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public LocalDate getPubDate() {
        return this.publicationDate;
    }

    @Override
    public boolean equals(Object o) {
        Book b = (Book) o;
        return (title.equals(b.getTitle())) && (author.equals(b.getAuthor())) && (publicationDate.getYear() == b.getPubDate().getYear()) && (publicationDate.getMonthValue() == b.getPubDate().getMonthValue()) && (publicationDate.getDayOfMonth() == b.getPubDate().getDayOfMonth());
    }

    @Override
    public String toString() {
        return "tytul: \"" + title.toUpperCase() + "\", autor: " + author + ", data wydania: " + publicationDate.getDayOfMonth() + "-" + publicationDate.getMonthValue() + "-" + publicationDate.getYear();
    }
}

class Application3 {
    public static void main(String[] args) {
        Book book1 = new Book("50 shades of Grey", "E.L. James", 2012, 5, 25);
        Book book2 = new Book("Sherlock Holmes", "Arthur Conan Doyle", 1945, 2, 4);
        Book book3 = new Book("The Last Mohikan", "James Fenimore Cooper", 1966, 7, 22);
        Book book4 = new Book("A Journey Into the Earth", "Jules Verne", 1973, 4, 22);
        Book book5 = new Book("50000 miles undersea journey", "	Jules Verne", 2011, 7, 13);
        Book book6 = new Book("Neverending Story", "Michael Ende", 2006, 2, 4);
        Book book7 = new Book("Book of Jungle", "Rudyard Kipling", 2006, 4, 15);
        Book book8 = new Book("Begining", " Brown Dan", 2006, 8, 11);
        Book book9 = new Book("Behind the closed door", "Paris B.A.", 2006, 11, 30);
        Book book10 = new Book("To the ends of the world", "Davies Norman", 2006, 10, 24);
        HashSet<Book> library = new HashSet<Book>();
        library.add(book1);
        library.add(book2);
        library.add(book3);
        library.add(book4);
        library.add(book5);
        library.add(book6);
        library.add(book7);
        library.add(book8);
        library.add(book9);
        library.add(book10);
        System.out.println("Wyswietlenie calej kolekcji obiektow klasy 'Book' zapisanej w zbiorze typu HashSet:\n");
        for (Book book : library) {
            System.out.println(book);
        }
        System.out.println("\nWyswietlenie ksiazek wydanych przed rokiem 2010:\n");
        for (Book book : library) {
            if (book.getPubDate().getYear() < 2010) {
                System.out.println(book);
            }
        }
        System.out.println("\nWyswietlenie ksiazek pogrupowane wedlug 'hashCode()'");
        for (Book book : library) {
            if (book.hashCode() == 2006001) {
                System.out.println("rok: 2006, kwartal: 1 --> " + book);
            }
            if (book.hashCode() == 2006002) {
                System.out.println("rok: 2006, kwartal: 2 --> " + book);
            }
            if (book.hashCode() == 2006003) {
                System.out.println("rok: 2006, kwartal: 3 --> " + book);
            }
            if (book.hashCode() == 2006004) {
                System.out.println("rok: 2006, kwartal: 4 --> " + book);
            }
        }
        System.out.println("\nProba dodania obiektu typu 'Book' o takich samych wartosciach atrybutow:");
        Book book11 = new Book("To the ends of the world", "Davies Norman", 2006, 10, 24);
        library.add(book11);
        for (Book book : library) {
            System.out.println(book);
        }
        System.out.println("\nJak widac, obiekt 'book11' nie zostal dodany do kolekcji...");
        System.out.println("...WNIOSEK: unikalnosc obiektow w zbiorze typu HashSet jest faktem.");
    }
}


