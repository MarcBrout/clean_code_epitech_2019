package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementTest {
    @Test
    void setPreviousAndNextElements() {
        Element<String> element = new Element<>();
        Element<String> previous = new Element<>();
        Element<String> next = new Element<>();

        element.setPreviousAndNextElements(previous, next);

        assertEquals(previous, element.prev);
        assertEquals(next, element.next);

        assertEquals(element, previous.next);
        assertEquals(element, next.prev);
    }

    @Test
    void disconnect() {
    }
}