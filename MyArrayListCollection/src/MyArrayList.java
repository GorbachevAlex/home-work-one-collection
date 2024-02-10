public class MyArrayList<E> {
    private E[] elements;
    private int size;

    public MyArrayList() {
        elements = (E[]) new Object[10];
    }

    public MyArrayList(int capacity) {
        elements = (E[]) new Object[capacity];
    }

    public E get(int index) {
        return elements[index];
    }

    public int size() {
        int count = 0;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == null) {
                count++;
            }
        }
        return elements.length - count;
    }

    public boolean add(E elem) {
        if (size >= elements.length) {
            elements = incrementArraySize();
        }
        elements[size++] = elem;
        return true;
    }

    public boolean add(int index, E elem) {

        E[] saveArray = elements;

        if (index < 0) return false;

        if (size >= elements.length || index > size) {
            elements = incrementArraySize();
        }
        System.arraycopy(saveArray, index, elements, index + 1, elements.length - 1 - index);
        elements[index] = elem;
        return true;
    }

    private E[] incrementArraySize() {
        E[] saveArray = (E[]) new Object[(int) (elements.length * 1.5)];
        for (int i = 0; i < elements.length; i++) {
            saveArray[i] = elements[i];
        }
        return saveArray;
    }
}
