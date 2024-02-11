public interface MyList<E> {
    E get(int index);

    int size();

    boolean add(E elem);

    boolean add(int index, E elem);

    E remove(int index);

    boolean remove(E elem);

    boolean addAll(MyList<? extends E> elem);

    boolean addAll(int index, MyList<? extends E> elem);

    E[] toArray();

    E set(int index, E elem);

    static <E extends Comparable<E>> void sort(MyList<E> list) {
        boolean flag = false;
        while (!flag) {
            flag = true;
            E temp;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                    temp = list.get(i);
                    list.add(i, list.get(i + 1));
                    list.remove(i + 1);
                    list.add(i + 1, temp);
                    list.remove(i + 2);
                    flag = false;
                }
            }
        }
    }
}
