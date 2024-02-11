import java.util.Arrays;
public class MyArrayList<E> implements MyList<E> {
    private E[] elements;
    private int size;

    public MyArrayList() {
        elements = (E[]) new Object[10];
    }

    public MyArrayList(int capacity) {
        elements = (E[]) new Object[capacity];
    }

    public MyArrayList(MyList<? extends E> elem) {
        elements = (E[]) new Object[elem.size()];
        for (int i = 0; i < elem.size(); i++) {
            add(elem.get(i));
        }
    }

    @Override
    public E get(int index) {
        return elements[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E elem) {
        if (size >= elements.length) {
            incrementArraySize();
        }
        elements[size++] = elem;
        return true;
    }

    @Override
    public boolean add(int index, E elem) {
        E[] saveArray = elements;
        if (index < 0) return false;
        if (size >= elements.length || index > size) {
            incrementArraySize();
        }
        System.arraycopy(saveArray, index, elements, index + 1, elements.length - 1 - index);
        elements[index] = elem;
        size++;
        return true;
    }

    @Override
    public E remove(int index) {
        E[] saveArray = elements;
        if (index < 0) return null;
        elements[index] = null;
        System.arraycopy(saveArray, index + 1, elements, index, elements.length - 1 - index);
        size--;
        return elements[index];
    }

    @Override
    public boolean remove(E elem) {
        E[] saveArray = elements;
        for (int i = 0; i < saveArray.length; i++) {
            if (saveArray[i] == elem) {
                saveArray[i] = null;
                System.arraycopy(saveArray, i + 1, elements, i, elements.length - 1 - i);
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(MyList<? extends E> elem) {

        if (size == 0) return false;

        E[] saveArray = elem.toArray();
        for (int i = 0; i < saveArray.length; i++) {
            if (size >= elements.length) {
                incrementArraySize();
            }
            elements[size++] = saveArray[i];
        }
        return true;
    }

    @Override
    public boolean addAll(int index, MyList<? extends E> elem) {

        if (index < 0 || size == 0) return false;

        int saveIndex = index;
        E[] saveArray = Arrays.copyOf(elements, size);
        E[] saveArrayElem = elem.toArray();
        for (int i = 0; i < saveArrayElem.length; i++) {
            if (size >= elements.length) {
                incrementArraySize();
            }
            elements[index++] = saveArrayElem[i];
            size++;
        }
        System.arraycopy(saveArray, saveIndex, elements, index, elements.length - 1 - index);
        return true;
    }

    @Override
    public E[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    @Override
    public E set(int index, E elem) {
        if (index < 0) return null;

        E[] saveArray = elements;
        return saveArray[index] = elem;
    }

    @Override
    public String toString() {
        return "elements=" + Arrays.toString(elements) +
                ", size=" + size +
                '}';
    }

    private E[] incrementArraySize() {
        E[] saveArray = (E[]) new Object[(int) (elements.length * 1.5)];
        for (int i = 0; i < elements.length; i++) {
            saveArray[i] = elements[i];
        }
        elements = saveArray;
        return elements;
    }
}
