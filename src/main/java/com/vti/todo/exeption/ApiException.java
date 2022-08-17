package com.vti.todo.exeption;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ApiException extends RuntimeException{

    private final String messageCode;

}
