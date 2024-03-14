package methodSource;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class SumArguments {

    public static Stream<Arguments> dataForPlus() {
        return Stream.of(
                Arguments.of(999, 2, 1001),
                Arguments.of(0, 1, 1),
                Arguments.of(10, -1, 9),
                Arguments.of(Integer.MAX_VALUE, 1, Integer.MIN_VALUE)
        );
    }
}
