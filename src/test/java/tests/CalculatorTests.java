package tests;

import enums.MinusData;
import calculate.Calculator;
import extentions.CalculatorInjector;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import javax.inject.Inject;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(CalculatorInjector.class)
public class CalculatorTests extends BaseTest {

    @Inject
    Calculator calculator;

    @BeforeEach
    public void printBeforeEachThread() {
        System.out.println("Thread ID: " + Thread.currentThread().getId() + " started");
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("methodSource.SumArguments#dataForPlus")
    public void checkPlus(int a, int b, int expected) {
        System.out.println("Plus test start...");
        System.out.println("a value: " + a + ", b value: " + b + ", expected value: " + expected);
        assertEquals(calculator.plus(a, b), expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {0})
    void checkZeroZeroSum(int number) {
        assertEquals(calculator.plus(number, number), number);
    }

    @ParameterizedTest
    @EnumSource(value = enums.MinusData.class, names = {"FIRST"})
    public void checkMinus(MinusData data) {
        int a = data.getA();
        int b = data.getB();
        int expected = data.getExpected();

        System.out.println("Minus test start... with enum parametrization");
        System.out.println("a value: " + a + ", b value: " + b + ", expected value: " + expected);
        assertEquals(calculator.minus(a, b), expected );
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:2", "2:0:0"}, delimiter = ':')
    public void checkMultiply(int a, int b, int expected) throws InterruptedException {
        System.out.println("* test start... with CSV source parametrization");
        System.out.println("a value: " + a + ", b value: " + b + ", expected value: " + expected);
        assertEquals(calculator.multiplay(a, b), expected);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testDataFiles/Division.csv", numLinesToSkip = 1)
    public void checkDivision(int a, int b, double expected) {
        System.out.println("Division test start... with CSV source parametrization");
        System.out.println("a value: " + a + ", b value: " + b + ", expected value: " + expected);
        assertEquals(calculator.division(a, b), expected, 0.1);
    }

    @Test
    void checkDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.division(10, 0));
    }

    @AfterEach
    void printAfterEach() {
        System.out.println("---------TEST END------------");
    }

}
