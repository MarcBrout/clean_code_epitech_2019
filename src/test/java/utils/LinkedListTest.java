package utils;

import org.junit.jupiter.api.Test;
import org.w3c.dom.ranges.RangeException;

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

    private String buildSentence(LinkedList<String> words) {
        StringBuilder sentence = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            sentence.append(words.get(i));
            if (i < words.size() - 1) {
                sentence.append(" ");
            }
        }
        return sentence.toString();
    }

    @Test
    void addAt() {
        LinkedList<String> words = new LinkedList<>();

        assertThrows(RangeException.class, () -> words.addAt("10", 10));
        assertThrows(RangeException.class, () -> words.addAt("10", -10));

        words.addAt("is", 0);
        assertEquals("is", buildSentence(words));

        words.addAt("This", 0);
        assertEquals("This is", buildSentence(words));

        words.addAt("a", 2);
        assertEquals("This is a", buildSentence(words));

        words.addAt("List", 3);
        assertEquals("This is a List", buildSentence(words));

        words.addAt("Linked", 3);
        assertEquals("This is a Linked List", buildSentence(words));
    }

    @Test
    void removeAt() {
        LinkedList<String> words = new LinkedList<>();

        words.addAt("is", 0);
        words.addAt("This", 0);
        words.addAt("a", 2);
        words.addAt("List", 3);
        words.addAt("Linked", 3);

        assertThrows(RangeException.class, () -> words.removeAt(10));
        assertThrows(RangeException.class, () -> words.removeAt(-10));

        words.removeAt(1);
        assertEquals("This a Linked List", buildSentence(words));

        words.removeAt(1);
        assertEquals("This Linked List", buildSentence(words));

        words.removeAt(2);
        assertEquals("This Linked", buildSentence(words));

        words.removeAt(0);
        assertEquals("Linked", buildSentence(words));

        words.removeAt(0);
        assertEquals(0, words.size());
    }

    @Test
    void remove() {
        LinkedList<String> words = new LinkedList<>();

        words.addEnd("This");
        words.addEnd("e");
        words.addEnd("is");
        words.addEnd("e");
        words.addEnd("a");
        words.addEnd("e");
        words.addEnd("Linked");
        words.addEnd("e");
        words.addEnd("List");
        words.addEnd("e");

        assertEquals("This e is e a e Linked e List e", buildSentence(words));
        words.remove("e");
        assertEquals("This is a Linked List", buildSentence(words));
    }

    @Test
    void get() {
        LinkedList<Integer> numbers = new LinkedList<>();
        numbers.addEnd(1);
        numbers.addEnd(2);
        numbers.addEnd(3);
        numbers.addEnd(4);

        assertThrows(RangeException.class, () -> numbers.get(-10));
        assertThrows(RangeException.class, () -> numbers.get(10));

        assertEquals(new Integer(1), numbers.get(0));
        assertEquals(new Integer(2), numbers.get(1));
        assertEquals(new Integer(3), numbers.get(2));
        assertEquals(new Integer(4), numbers.get(3));
    }

    @Test
    void findFirst() {
        LinkedList<String> words = new LinkedList<>();

        words.addEnd("This");
        words.addEnd("e");
        words.addEnd("is");
        words.addEnd("e");
        words.addEnd("a");
        words.addEnd("e");
        words.addEnd("Linked");
        words.addEnd("e");
        words.addEnd("List");
        words.addEnd("e");

        assertEquals(6, words.findFirst("Linked"));
        assertEquals(1, words.findFirst("e"));
        assertEquals(0, words.findFirst("This"));
        assertEquals(LinkedList.ELEMENT_NOT_FOUND, words.findFirst("lol"));
    }

    @Test
    void findLast() {
        LinkedList<String> words = new LinkedList<>();

        words.addEnd("This");
        words.addEnd("e");
        words.addEnd("is");
        words.addEnd("e");
        words.addEnd("a");
        words.addEnd("e");
        words.addEnd("Linked");
        words.addEnd("e");
        words.addEnd("List");
        words.addEnd("e");

        assertEquals(6, words.findLast("Linked"));
        assertEquals(9, words.findLast("e"));
        assertEquals(0, words.findLast("This"));
        assertEquals(LinkedList.ELEMENT_NOT_FOUND, words.findLast("lol"));
    }

    @Test
    void size() {
        LinkedList<Integer> numbers = new LinkedList<>();

        assertEquals(0, numbers.size());

        numbers.addEnd(1);
        numbers.addEnd(2);
        numbers.addEnd(3);
        numbers.addEnd(4);

        assertEquals(4, numbers.size());

        numbers.removeAt(0);
        numbers.removeAt(0);
        numbers.removeAt(0);
        numbers.removeAt(0);

        assertEquals(0, numbers.size());
    }
}