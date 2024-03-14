package enums;

public enum MinusData {
    FIRST(1, 0, 1),
    SECOND(2, 2, 0);

    private final int a;
    private final int b;
    private final int expected;

    MinusData(int a, int b, int expected) {
        this.a = a;
        this.b = b;
        this.expected = expected;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getExpected() {
        return expected;
    }
}
