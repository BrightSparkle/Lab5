package org.example;

/**
 * Класс, использующий автоматическое внедрение зависимостей.
 * <p>
 * Поля {@link #field1} и {@link #field2} инициализируются
 * через механизм рефлексии в {@link Injector}.
 */
public class SomeBean {
    @AutoInjectable
    private SomeInterface field1;
    @AutoInjectable
    private SomeOtherInterface field2;

    /**
     * Выполняет действия, используя внедренные зависимости.
     */
    public void foo() {
        field1.doSomething();
        field2.doSomeOther();
    }

    /**
     * @return Первая зависимость (для тестирования)
     */
    public SomeInterface getField1() { return field1; }

    /**
     * @return Вторая зависимость (для тестирования)
     */
    public SomeOtherInterface getField2() { return field2; }
}