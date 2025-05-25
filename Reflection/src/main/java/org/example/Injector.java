package org.example;
import java.lang.reflect.*;
import java.io.*;
import java.util.Properties;

public class Injector {
    private final Properties properties;

    public Injector(Properties properties) {
        this.properties = properties;
    }

    public Injector() throws IOException {
        properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new FileNotFoundException("Файл config.properties не найден");
            }
            properties.load(input);
        }
    }

    public <T> T inject(T obj) throws Exception {
        // Перебираем все поля объекта
        for (Field field : obj.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(AutoInjectable.class)) {
                // Получаем тип поля (интерфейс)
                Class<?> fieldType = field.getType();

                // Ищем реализацию в properties
                String implClassName = properties.getProperty(fieldType.getName());
                if (implClassName == null) {
                    throw new RuntimeException("Реализация для " + fieldType.getName() + " не найдена");
                }

                // Создаем экземпляр класса реализации
                Class<?> implClass = Class.forName(implClassName);
                Object implInstance = implClass.getDeclaredConstructor().newInstance();

                // Устанавливаем значение поля
                field.setAccessible(true);
                field.set(obj, implInstance);
            }
        }
        return obj;
    }
}
