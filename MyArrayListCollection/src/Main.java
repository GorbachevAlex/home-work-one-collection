public class Main {
    public static void main(String[] args) {

        MyArrayList<String> str = new MyArrayList<>();
        str.add("My");
        str.add("Name");
        str.add("is");
        str.add("A - Alexey");
        str.add("check");
        str.add("this");
        str.add("MyArrayList");
        System.out.println(str);

        MyArrayList<Integer> i = new MyArrayList<>();
        i.add(15);
        i.add(1);
        i.add(0);
        i.add(3);
        i.add(-5);
        MyList.sort(i);
        System.out.println(i);
    }
}