import org.w3c.dom.ranges.RangeException;

public class LinkedList<T> {
    private Element<T> first = null;
    private Element<T> last = null;
    private int count = 0;
    public static final int ELEMENT_NOT_FOUND = -1;

    public void add(T value) {
        var element = new Element<T>(value);

        if (first == null) {
            first = element;
        } else {
            element.prev = last;
            last.next = element;
        }

        last = element;

        ++count;
    }

    public void push(T value) {
        var element = new Element<T>(value);

        if (first == null) {
            last = element;
        } else {
            element.next = first;
            first.prev = element;
        }

        first = element;

        ++count;
    }

    public void insertAt(T value, int position) throws RangeException {
        checkRange(position);

        Element<T> cursor = getCursorAtPosition(position);
        Element<T> element = new Element<T>(value);

        connectElements(cursor, element, cursor.next);
        ++count;
    }

    public void remove(int position) {
        checkRange(position);

        Element<T> cursor = getCursorAtPosition(position);
        disconnectElement(cursor);
        --count;
    }

    public void remove(T value) {
        int i = 0;
        Element<T> cursor = first;
        Element<T> save = null;

        while (i < count) {
            if (cursor.value == value) {
                save = cursor.next;
                disconnectElement(cursor);
                cursor = save;
            }
            ++i;
        }
    }

    public T get(int position) {
        checkRange(position);

        Element<T> cursor = getCursorAtPosition(position);

        return cursor.value;
    }

    public int findFirst(T value) {
        int i = 0;
        Element<T> cursor = first;

        while (i < count) {
            if (cursor.value == value) {
                return i;
            }
            ++i;
        }
        return ELEMENT_NOT_FOUND;
    }

    public int findLast(T value) {
        int i = count;
        Element<T> cursor = first;

        while (i > 0) {
            if (cursor.value == value) {
                return i;
            }
            --i;
        }
        return ELEMENT_NOT_FOUND;
    }

    public int size() {
        return count;
    }

    private void checkRange(int position) throws RangeException {
        if (position > count) throw new RangeException(RangeException.BAD_BOUNDARYPOINTS_ERR, "Error, adding an element out of the list isn't allowed.");
    }

    private void connectElements(Element<T> before, Element<T> between, Element<T> after) {
        between.prev = before;
        between.next = after;

        if (before != null)
            before.next = between;

        if (after != null)
            after.prev = between;
    }

    private void disconnectElement(Element<T> toDisconnect) {
        if (toDisconnect.next != null) {
            toDisconnect.next.prev = toDisconnect.prev;
        }

        if (toDisconnect.prev != null) {
            toDisconnect.prev.next = toDisconnect.next;
        }

        toDisconnect.next = null;
        toDisconnect.prev = null;
    }

    private Element<T> getCursorAtPosition(int position) {
        int i = 0;
        Element<T> cursor = first;

        while (i < position) {
            cursor = cursor.next;
            ++i;
        }

        return cursor;
    }
}
