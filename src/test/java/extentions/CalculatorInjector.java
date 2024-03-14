package extentions;

import calculate.Calculator;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;
import javax.inject.Inject;
import java.lang.reflect.Field;

public class CalculatorInjector implements TestInstancePostProcessor {

    @Override
    public void postProcessTestInstance(Object testInstance, ExtensionContext extensionContext) throws Exception {
        Field[] fields = testInstance.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class) &&
                    field.getType().isAssignableFrom(Calculator.class)) {
                field.setAccessible(true);
                field.set(testInstance, new Calculator());
            }
        }
    }
}
