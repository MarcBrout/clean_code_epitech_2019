package utils;

public class Element<T> {
    public T value;
    public Element<T> next = null;
    public Element<T> prev = null;

    public Element(T value) {
        this.value = value;
    }
    public Element() {}

    public void setPreviousAndNextElements(Element<T> elementBefore, Element<T> elementAfter) {
        if (elementBefore != null) {
            elementBefore.next = this;
        }

        if (elementAfter != null) {
            elementAfter.prev = this;
        }

        this.prev = elementBefore;
        this.next = elementAfter;
    }

    public void disconnect() {
        if (this.prev != null) {
            this.prev.next = this.next;
        }

        if (this.next != null) {
            this.next.prev = this.prev;
        }

        this.next = null;
        this.prev = null;
    }
}