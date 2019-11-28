public class LinkedList<T> {
    private Element<T> first = null;
    private Element<T> last = null;
    private int count = 0;

    public void add(T value) {

        ++count;
    }

    public void push(T value) {

        ++count;
    }

    public void insert(T value, int position) {

    }

    public void remove(int position) {

    }

    public void remove(T value) {

    }

    public T get(int position) {

        return first.value;
    }

    public int findFirst(T value) {
        return 0;
    }

    public int findLast(T value) {
        return 0;
    }

    public int size() {
        return count;
    }
}
