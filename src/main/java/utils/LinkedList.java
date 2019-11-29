package utils;

import org.w3c.dom.ranges.RangeException;

public class LinkedList<T> {
    public static final int ELEMENT_NOT_FOUND = -1;

    private Element<T> dummyStart = new Element<>();
    private Element<T> dummyEnd = new Element<>();
    private int size = 0;
    
    public LinkedList() {
        dummyEnd.prev = dummyStart;
        dummyStart.next = dummyEnd;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isNotEmpty() {
        return size > 0;
    }

    public void addEnd(T value) {
        Element<T> elementToAdd = new Element<T>(value);
        elementToAdd.setPreviousAndNextElements(dummyEnd.prev, dummyEnd);

        ++size;
    }

    public void addFirst(T value) {
        Element<T> elementToAdd = new Element<T>(value);
        elementToAdd.setPreviousAndNextElements(dummyStart, dummyStart.next);

        ++size;
    }

    public void addAt(T value, int position) throws RangeException {
        gardAgainstOutOfRangePosition(position);

        Element<T> currentElementAtPosition = getElementAtPositionForInsertion(position);
        Element<T> elementToAdd = new Element<>(value);
        elementToAdd.setPreviousAndNextElements(currentElementAtPosition, currentElementAtPosition.next);

        ++size;
    }

    public void removeAt(int position) {
        gardAgainstOutOfRangePosition(position);

        Element<T> currentElementAtPosition = getElementAtPositionForRead(position);
        currentElementAtPosition.disconnect();

        --size;
    }

    public void remove(T value) {
        Element<T> currentElement = dummyStart.next;
        Element<T> next = null;

        while (currentElement != dummyEnd) {
            if (currentElement.value.equals(value)) {
                next = currentElement.next;
                currentElement.disconnect();
                currentElement = next;
                --size;
            } else {
                currentElement = currentElement.next;
            }
        }
    }

    public T get(int position) {
        gardAgainstOutOfRangePosition(position);

        return getElementAtPositionForRead(position).value;
    }

    public int findFirst(T value) {
        Element<T> currentElement = dummyStart.next;
        int position = 0;

        while (currentElement != dummyEnd) {
            if (currentElement.value == value) {
                return position;
            }
            currentElement = currentElement.next;
            ++position;
        }
        return ELEMENT_NOT_FOUND;
    }

    public int findLast(T value) {
        Element<T> currentElement = dummyEnd.prev;
        int position = size - 1;

        while (currentElement != dummyStart) {
            if (currentElement.value == value) {
                return position;
            }
            currentElement = currentElement.prev;
            --position;
        }
        return ELEMENT_NOT_FOUND;
    }

    public int size() {
        return size;
    }

    private void gardAgainstOutOfRangePosition(int position) throws RangeException {
        if (position > size || position < 0) throw new RangeException(RangeException.BAD_BOUNDARYPOINTS_ERR, "Error, adding an element out of the list isn't allowed.");
    }

    private Element<T> getElementAtPositionFrom(Element<T> from, int position) {
        Element<T> elementAtPosition = from;
        int i = 0;

        while (i < position) {
            elementAtPosition = elementAtPosition.next;
            ++i;
        }

        return elementAtPosition;
    }

    private Element<T> getElementAtPositionForInsertion(int position) {
        return getElementAtPositionFrom(dummyStart, position);
    }

    private Element<T> getElementAtPositionForRead(int position) {
        return getElementAtPositionFrom(dummyStart.next, position);
    }
}
