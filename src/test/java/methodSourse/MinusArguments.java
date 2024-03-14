package methodSourse;

import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;

public class MinusArguments {
    public static Stream<Arguments> dataForMinus() {
        return Stream.of(
                Arguments.of(1, 0, 1),
                Arguments.of(10, -1, 11)
        );
    }
}
