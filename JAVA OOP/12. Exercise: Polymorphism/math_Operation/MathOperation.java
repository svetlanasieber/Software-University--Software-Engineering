package math_Operation;

public class MathOperation {
    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
//        return a+b+c;

        return add(add(a, b), c);
    }

    public int add(int a, int b, int c, int d) {
//        return a+b+c+d;

        return add(add(a, b), add(c, d));

    }
}
