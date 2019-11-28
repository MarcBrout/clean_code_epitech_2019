public class Element<T> {
    T value;
    Element<T> next = null;
    Element<T> prev = null;

    Element(T value) {
        this.value = value;
    }
}
