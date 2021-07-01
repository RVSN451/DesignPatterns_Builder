package com.kostakov;

public class IllegalStateException extends Exception{
    public IllegalStateException(String value) {
        super(String.format("Поле '%s' обязательно к заполнению.", value));
    }
}
