package org.example;

/**
 * Реализация интерфейса {@link SomeOtherInterface}.
 * Выводит символ 'C' при вызове {@link #doSomeOther()}.
 */
class SODoer implements SomeOtherInterface {
    @Override
    public void doSomeOther() {
        System.out.print("C");
    }
}