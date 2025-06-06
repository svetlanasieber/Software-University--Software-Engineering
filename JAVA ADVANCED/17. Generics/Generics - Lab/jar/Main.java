package jar;

public class Main {
    public static void main(String[] args) {

        Jar<String> jar = new Jar();

        jar.add("Apple");
        jar.add("Banana");
        jar.add("Orange");
        System.out.println(jar.remove());
        System.out.println(jar.remove());




    }
}
