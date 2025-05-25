package org.example;
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.io.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        SomeBean sb = null;
        try {
            sb = new Injector().inject(new SomeBean());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        sb.foo();
    }
}