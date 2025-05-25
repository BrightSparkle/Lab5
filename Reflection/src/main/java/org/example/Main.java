package org.example;
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.io.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws Exception {
        SomeBean sb = new Injector().inject(new SomeBean());
        sb.foo();
    }
}