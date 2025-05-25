import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Properties;

public class InjectorTest {
    private Injector injector;
    private Properties testProperties;

    @BeforeEach
    void setUp() throws Exception {
        testProperties = new Properties();
        // Создаем тестовые properties вместо файла
        testProperties.put("org.example.SomeInterface", "org.example.SomeImpl");
        testProperties.put("org.example.SomeOtherInterface", "org.example.SODoer");

        injector = new Injector(testProperties);
    }

    @Test
    void testDependencyInjection() throws Exception {
        SomeBean bean = new SomeBean();
        injector.inject(bean);

        assertNotNull(bean.getField1());
        assertNotNull(bean.getField2());
    }

    @Test
    void testMethodOutput() {
        SomeBean bean = assertDoesNotThrow(() -> injector.inject(new SomeBean()));
        assertDoesNotThrow(() -> {
            bean.foo(); // Должно вывести "AC"
        });
    }

    @Test
    void testMissingImplementation() {
        Properties brokenProps = new Properties();
        // Не указываем реализацию для SomeInterface
        brokenProps.remove("org.example.SomeInterface");

        Injector brokenInjector = new Injector(brokenProps);
        assertThrows(RuntimeException.class, () ->
                brokenInjector.inject(new SomeBean())
        );
    }
}
