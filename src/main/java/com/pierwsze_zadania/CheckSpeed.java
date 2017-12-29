package com.pierwsze_zadania;

import java.util.*;

class Books {
    private String title;
    private String author;

    public Books(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "tutul: \"" + title.toUpperCase() + "\", autor: " + author;
    }

    @Override
    public boolean equals(Object obj) {
        Books b = (Books) obj;
        return (title.equals(b.title)) && (author.equals(b.author));
    }

    @Override
    public int hashCode() {
        return title.length();
    }
}

class Collection {
    private LinkedList<Books> booksList;
    private HashMap<Books, String> booksMap;
    private int quantityBooks;
    Random randGen = new Random();

    public Collection(int quantityBooks) {
        this.quantityBooks = quantityBooks;
        booksList = new LinkedList<Books>();
        booksMap = new HashMap<Books, String>();
    }

    public void createList() {
        String letters[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "w", "x", "y", "z", " "};
        for (int j = 0; j < quantityBooks; j++) {
            String bookTitle = "";
            String bookAuthor = "";
            for (int i = 0; i < (randGen.nextInt(20)) + 5; i++) {
                bookTitle += letters[randGen.nextInt(letters.length)];
                bookAuthor += letters[randGen.nextInt(letters.length)];
            }
            booksList.add(new Books(bookTitle, bookAuthor));
        }
        System.out.println("\nZostala stworzona lista typu LinkedList zawierajaca " + quantityBooks + " obiektow.");
    }
    public void createMap() {
        String reviews[] = {"interesujaca", "ciekawa", "nudna", "krzepiaca", "fatalna", "wyjatkowa", "zjawiskowa", "przejmujaca"};
        if (!booksList.isEmpty()) {
            for (int i = 0; i < booksList.size(); i++) {
                booksMap.put(booksList.get(i), reviews[randGen.nextInt(reviews.length)]);
            }
        }
        System.out.println("Zostala stworzona mapa typu HashMap zawierajaca " + quantityBooks + " obiektow.");
    }

    public LinkedList<Books> getBooksList() {
        return booksList;
    }

    public HashMap<Books, String> getBooksMap() {
        return booksMap;
    }

    public void showBooksMap() {
        for (Map.Entry entry : booksMap.entrySet()) {
            System.out.println(entry.getKey() + " --> " + entry.getValue());
        }
    }

    public void showBookList() {
        for (Books book : booksList) {
            System.out.println(book);
        }
    }
}

class CheckSpeed {
    private int indexNumber;
    private int quantity;
    private Collection colection;
    private Books checkKey = new Books("Neverending Story", "Michael Ende");

    public CheckSpeed(int quantity) {
        this.quantity = quantity;
        this.colection = new Collection(quantity);
    }

    public Collection getColection() {
        return colection;
    }

    public String eraseListObject(int indexNumber) {
        if (colection.getBooksList().size() > indexNumber) {
            long begin = System.nanoTime();
            System.out.println(colection.getBooksList().remove(indexNumber));
            long end = System.nanoTime();
            return "czas operacji = " + (end - begin) + " ns, dla " + (colection.getBooksList().size() + 1) + " obiektow listy";
        } else {
            return "niedozwolona wartosc indeksu!!!";
        }
    }

    public String additionListObject(int indexNumber) {
        long begin = System.nanoTime();
        colection.getBooksList().add(indexNumber, checkKey);
        long end = System.nanoTime();
        System.out.println(colection.getBooksList().get(indexNumber));
        return "czas operacji = " + (end - begin) + " ns, dla " + (colection.getBooksList().size()) + " obiektow listy";
    }

    public String searchListObject(int indexNumber) {
        if (colection.getBooksList().size() > indexNumber) {
            long begin = System.nanoTime();
            System.out.println(colection.getBooksList().get(indexNumber));
            long end = System.nanoTime();
            return "czas operacji = " + (end - begin) + " ns, dla " + (colection.getBooksList().size() + 1) + " obiektow listy";
        } else {
            return "niedozwolona wartosc indeksu!!!";
        }
    }

    public String additionMapObject() {
        boolean check = false;
        for (Map.Entry entry : colection.getBooksMap().entrySet()) {
            if (entry.getKey().equals(checkKey)) {
                check = true;
                return "niedozwolona operacja!!! klucz o tej wartosci juz istnieje !!!";
            }
        }
        if (!check) {
            System.out.println(checkKey + " --> ciekawa");
            long begin = System.nanoTime();
            colection.getBooksMap().put(checkKey, "ciekawa");
            long end = System.nanoTime();
            return "czas opereacji = " + (end - begin) + " ns, dla " + (colection.getBooksMap().size()) + " obiektow listy";
        } else {
            return null;
        }
    }

    public String searchMapObject() {
        long begin = System.nanoTime();
        System.out.println(checkKey + " --> " + colection.getBooksMap().get(checkKey));
        long end = System.nanoTime();
        return "czas opereacji = " + (end - begin) + " ns, dla " + (colection.getBooksMap().size()) + " obiektow listy";
    }

    public String eraseMapObject() {
        long begin = System.nanoTime();
        System.out.println(checkKey + " --> " + colection.getBooksMap().remove(checkKey));
        long end = System.nanoTime();
        return "czas opereacji = " + (end - begin) + " ns, dla " + (colection.getBooksMap().size()) + " obiektow listy";
    }
}

class Application {
    public static void main(String[] args) {
        CheckSpeed speedList = new CheckSpeed(1000000);
        speedList.getColection().createList();
        System.out.println("\nUsuwanie obiektu z poczatku listy typu LinkedList: ");
        System.out.println(speedList.eraseListObject(0));
        System.out.println("\nUsuwanie obiektu z konca listy typu LinkedList: ");
        System.out.println(speedList.eraseListObject(speedList.getColection().getBooksList().size() - 1));
        System.out.println("\nDodawanie obiektu na poczatek listy typu LinkedList: ");
        System.out.println(speedList.additionListObject(0));
        System.out.println("\nDodawanie obiektu na koncu listy typu LinkedList: ");
        System.out.println(speedList.additionListObject(speedList.getColection().getBooksList().size()));
        System.out.println("\nWyszukanie obiektu na poczatku listy typu LinkedList: ");
        System.out.println(speedList.searchListObject(0));
        System.out.println("\nWyszukanie obiektu na koncu listy typu LinkedList: ");
        System.out.println(speedList.searchListObject(speedList.getColection().getBooksList().size() - 1));
        CheckSpeed speedMap = new CheckSpeed(10000);
        speedMap.getColection().createList();
        speedMap.getColection().createMap();
        System.out.println("\nDodawanie obiektu do mapy typu HashMap: ");
        System.out.println(speedMap.additionMapObject());
        System.out.println("\nDodawanie tego samego obiektu do mapy typu HashMap: ");
        System.out.println(speedMap.additionMapObject());
        System.out.println("\nWyszukiwanie obiektu w mapie typu HashMap: ");
        System.out.println(speedMap.searchMapObject());
        System.out.println("\nUsuwanie obiektu z mapy typu HashMap: ");
        System.out.println(speedMap.eraseMapObject());
    }
}

