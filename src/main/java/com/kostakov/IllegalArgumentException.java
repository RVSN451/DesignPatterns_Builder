package com.kostakov;

public class IllegalArgumentException extends  Exception{
    public IllegalArgumentException(String value) {
        super(String.format("Введено недопустимое значение поля '%s'.", value));
    }
}
