package tests;

import enums.MinusData;
import calculate.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CalculatorTests extends BaseTest {

    @BeforeEach
    public void printBeforeEachThread() {
        System.out.println("Thread ID: " + Thread.currentThread().getId() + " started");
    }
    @Disabled
    @ParameterizedTest
    @MethodSource("methodSourse.SumArguments#dataForPlus")
    public void checkPlus(int a, int b, int expected) {
        System.out.println("Plus test start...");
        System.out.println("a value: " + a + ", b value: " + b + ", expected value: " + expected);
        assertEquals(Calculator.plus(a,b), expected);
    }
    @ParameterizedTest
    @ValueSource(ints = {0})
    void checkZeroZeroSum(int number) {
        assertEquals(Calculator.plus(number, number), number);
    }
    @ParameterizedTest
    @EnumSource(value = enums.MinusData.class, names = {"FIRST"})
//    @EnumSource(enums.MinusData.class)
    public void checkMinus(MinusData data) throws InterruptedException {
        int a = data.getA();
        int b = data.getB();
        int expected = data.getExpected();

        System.out.println("Minus test start... with enum parametrization");
        System.out.println("a value: " + a + ", b value: " + b + ", expected value: " + expected);
//        Thread.sleep(3000);
        assertEquals(Calculator.minus(a, b), expected );
    }
    @ParameterizedTest
    @CsvSource(value = {"1:2:2", "2:0:0"}, delimiter = ':')
    public void checkMultiply(int a, int b, int expected) throws InterruptedException {
        System.out.println("* test start... with CSV source parametrization");
        System.out.println("a value: " + a + ", b value: " + b + ", expected value: " + expected);
//        Thread.sleep(5000);
        assertEquals(Calculator.multiplay(a, b), expected);
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/testDataFiles/Division.csv", numLinesToSkip = 1)
    public void checkDivision(int a, int b, double expected) {
        System.out.println("Division test start... with CSV source parametrization");
        System.out.println("a value: " + a + ", b value: " + b + ", expected value: " + expected);
        assertEquals(Calculator.division(a, b), expected, 0.1);
    }
    @Test
    void checkDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> Calculator.division(10, 0));
    }
    @AfterEach
    void printAfterEach() {
        System.out.println("---------TEST END------------");
    }

}
