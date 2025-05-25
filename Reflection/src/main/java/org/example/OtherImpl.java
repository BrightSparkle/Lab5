package org.example;

/**
 * Альтернативная реализация интерфейса {@link SomeInterface}.
 * Выводит символ 'B' при вызове {@link #doSomething()}.
 */
class OtherImpl implements SomeInterface {
    @Override
    public void doSomething() {
        System.out.print("B");
    }
}