package org.example;
import java.lang.annotation.*;

/**
 * Аннотация для пометки полей, которые должны быть автоматически
 * инициализированы инжектором зависимостей.
 *
 * @see Injector
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface AutoInjectable {}