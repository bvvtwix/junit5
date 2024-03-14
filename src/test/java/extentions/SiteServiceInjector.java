package extentions;

import org.example.MainService;
import org.example.SiteService;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

import javax.inject.Inject;
import java.lang.reflect.Field;

public class SiteServiceInjector implements TestInstancePostProcessor {

    @Override
    public void postProcessTestInstance(Object testInstance, ExtensionContext extensionContext) throws Exception {
        Field[] fields = testInstance.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class) &&
                    field.getType().isAssignableFrom(SiteService.class)) {
                field.setAccessible(true);
                field.set(testInstance, new MainService());
            }
        }
    }
}
