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
        return size;
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
        System.arraycopy(saveArray, index, elements, index + 1, elements.length-1 - index);
        elements[index] = elem;
        size ++;
        return true;
    }

    public E remove (int index) {
        E [] saveArray = elements;
        if (index < 0) return null;
        elements[index]=null;
        System.arraycopy(saveArray, index+1, elements, index, elements.length-1-index);
        size--;
        return elements[index];
    }

    public boolean remove (E elem) {
        E [] saveArray = elements;
        for (int i = 0; i < saveArray.length; i++) {
            if (saveArray[i] == elem) {
                saveArray[i] = null;
                System.arraycopy(saveArray, i+1, elements, i, elements.length-1-i);
                size--;
                return true;
            }
        }
        return false;
    }

    private E[] incrementArraySize() {
        E[] saveArray = (E[]) new Object[(int) (elements.length * 1.5)];
        for (int i = 0; i < elements.length; i++) {
            saveArray[i] = elements[i];
        }
        return saveArray;
    }
}
