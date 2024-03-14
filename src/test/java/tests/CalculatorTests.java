package tests;

import enums.MinusData;
import org.example.SiteService;
import extentions.SiteServiceInjector;
import org.example.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import javax.inject.Inject;
import java.util.stream.Stream;
import static org.junit.Assert.assertEquals;

public class CalculatorTests extends BaseTest {

    @BeforeEach
    public void printBeforeEachThread() {
        System.out.println("Thread ID: " + Thread.currentThread().getId() + " started");
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("dataForPlus")
    public void checkPlus(int a, int b, int expected) {
        System.out.println("Plus test start...");
        System.out.println("a value: " + a + ", b value: " + b + ", expected value: " + expected);
        assertEquals(Calculator.plus(a,b), expected);
    }

    private static Stream<Arguments> dataForPlus() {
        return Stream.of(
                Arguments.of(999, 2, 1001),
                Arguments.of(0, 1, 1),
                Arguments.of(10, -1, 9),
                Arguments.of(Integer.MAX_VALUE, 1, Integer.MIN_VALUE)
        );
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
    private static Stream<Arguments> dataForMinus() {
        return Stream.of(
                Arguments.of(1, 0, 1),
                Arguments.of(10, -1, 11)
        );
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

    @AfterEach
    void printAfterEach() {
        System.out.println("---------TEST END------------");
    }

}
