package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseTest {

    @BeforeAll
    static void printBeforeAll() {
        System.out.println("Testing started");
    }

    @AfterAll
    static void printAfterAll() {
        System.out.println("Testing finished");
    }
}
