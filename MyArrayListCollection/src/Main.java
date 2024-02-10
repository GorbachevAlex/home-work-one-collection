public class Main {
    public static void main(String[] args) {

        MyArrayList<String> str = new MyArrayList<>();
        str.add ("My");
        str.add ("Name");
        str.add ("is");
        str.add ("A - Alexey");

        for (int i = 0; i < str.size(); i++) {
            System.out.print(str.get(i) + " ");
        }
    }
}