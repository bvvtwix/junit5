package calculate;

public class Calculator {

    public int plus(int a, int b) {
        return a + b;
    }

    public int minus(int a, int b) {
        return a - b;
    }

    public int multiplay(int a, int b) {
        return a * b;
    }

    public double division(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Error: Division by zero");
        }
        return (double) a / b;
    }
}