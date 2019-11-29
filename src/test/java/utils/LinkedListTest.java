package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void isEmpty() {
        LinkedList<String> words = new LinkedList<>();
        assertTrue(words.isEmpty());

        words.addFirst("Test");
        assertFalse(words.isEmpty());

        words.remove("Test");
        assertTrue(words.isEmpty());
    }

    @Test
    void isNotEmpty() {
        LinkedList<String> words = new LinkedList<>();
        assertFalse(words.isNotEmpty());

        words.addFirst("Test");
        assertTrue(words.isNotEmpty());

        words.remove("Test");
        assertFalse(words.isNotEmpty());
    }

    @Test
    void addEnd() {
        LinkedList<String> numbers = new LinkedList<>();

        numbers.addEnd("1");
        numbers.addEnd("2");
        numbers.addEnd("3");
        numbers.addEnd("4");

        assertEquals("1", numbers.get(0));
        assertEquals("2", numbers.get(1));
        assertEquals("3", numbers.get(2));
        assertEquals("4", numbers.get(3));
    }

    @Test
    void addFirst() {
        LinkedList<String> numbers = new LinkedList<>();

        numbers.addFirst("1");
        numbers.addFirst("2");
        numbers.addFirst("3");
        numbers.addFirst("4");

        assertEquals("4", numbers.get(0));
        assertEquals("3", numbers.get(1));
        assertEquals("2", numbers.get(2));
        assertEquals("1", numbers.get(3));
    }

    @Test
    void addAt() {
    }

    @Test
    void removeAt() {
    }

    @Test
    void remove() {
    }

    @Test
    void get() {
    }

    @Test
    void findFirst() {
    }

    @Test
    void findLast() {
    }

    @Test
    void size() {
    }
}