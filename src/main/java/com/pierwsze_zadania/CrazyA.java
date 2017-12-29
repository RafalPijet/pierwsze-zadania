package com.pierwsze_zadania;

import java.util.*;

class CrazyA {
    private ArrayList<String> evenAchar;
    private ArrayList<String> oddAchar;

    public CrazyA() {
        evenAchar = new ArrayList<String>();
        oddAchar = new ArrayList<String>();
    }

    public void parityBinder(ArrayDeque<String> queue) {
        while (queue.size() > 0) {
            if (queue.peek().length() % 2 == 0) {
                evenAchar.add(queue.poll());
            } else {
                oddAchar.add(queue.poll());
            }
        }
    }

    public void showEvenAchar() {
        for (String chars : evenAchar) {
            System.out.println(chars + " --> " + chars.length());
        }
        System.out.println("Ilosc obiektow o dlugosci parzystej na liscie: " + evenAchar.size());
        System.out.println();
    }

    public void showOddAchar() {
        for (String chars : oddAchar) {
            System.out.println(chars + " --> " + chars.length());
        }
        System.out.println("Ilosc obiektow o dlugosci nieparzystej na liscie: " + oddAchar.size());
        System.out.println();
    }

}

class Application1 {
    public static void main(String[] args) {
        ArrayDeque<String> queue = new ArrayDeque<String>();
        String charA = "a";
        String randomText = charA;
        Random randGen = new Random();
        System.out.println("\nWygenerowanie 50-ciu obiektow przechowujacych losowa ilosc znakow 'a':\n");
        for (int j = 0; j < 50; j++) {
            int randomNum = randGen.nextInt(50);
            for (int i = 0; i < randomNum; i++) {
                randomText += charA;
            }
            System.out.println(randomText + " --> " + randomText.length());
            queue.offer(randomText);
            randomText = charA;
        }
        System.out.println("\nKolejka typu FIFO zawiera: " + queue.size() + " elementow\n\n");
        CrazyA crazy = new CrazyA();
        System.out.println("Rozdzielenie obiektow kolejki typu FIFO na ilosci parzyste i nieparzyste!\n");
        crazy.parityBinder(queue);
        System.out.println("\nLista zawierajaca parzyste ilosci znakow 'a':\n");
        crazy.showEvenAchar();
        System.out.println("\nLista zawierajaca nieparzyste ilosci znakow 'a':\n");
        crazy.showOddAchar();
    }
}
