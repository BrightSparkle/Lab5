package org.example;

/**
 * Реализация интерфейса {@link SomeInterface}.
 * Выводит символ 'A' при вызове {@link #doSomething()}.
 */
class SomeImpl implements SomeInterface {
    @Override
    public void doSomething() {
        System.out.print("A");
    }
}