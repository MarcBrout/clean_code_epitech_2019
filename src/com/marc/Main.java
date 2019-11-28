package com.marc;

import com.marc.utils.LinkedList;

public class Main {
    public static void main(String[] argv) {

        System.out.println("Instantiating...");
        LinkedList<String> words = new LinkedList<>();

        System.out.println("Adding words...");
        words.addEnd("a");
        words.addFirst("is");
        words.addEnd("Linked");
        words.addFirst("This");
        words.addEnd("List");

        System.out.println("Accessing and Testing values");
        assert words.get(0).equals("This");
        assert words.get(1).equals("is");
        assert words.get(2).equals("a");
        assert words.get(3).equals("Linked");
        assert words.get(4).equals("List");

        int i = 0;
        while (i < words.size()) {
            System.out.println(words.get(i));
            ++i;
        }
    }
}
