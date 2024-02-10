public class Main {
    public static void main(String[] args) {

        MyArrayList<String> str = new MyArrayList<>();
        str.add ("My");
        str.add ("Name");
        str.add ("is");
        str.add ("A - Alexey");

        str.add (0, "Hi");

        System.out.println(str.size());

        for (int i = 0; i < str.size(); i++) {
            System.out.println(str.get(i));
        }
    }
}