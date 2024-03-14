package calculate;

public class Calculator {
    public static int plus(int a, int b) {
        return a + b;
    }
    public static int minus(int a, int b) {
        return a - b;
    }
    public static int multiplay(int a, int b) {
        return a * b;
    }
    public static double division(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Error: Division by zero");
        }
        return (double) a / b;
    }
}