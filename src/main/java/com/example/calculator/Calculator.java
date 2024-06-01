package com.example.calculator;

import org.springframework.stereotype.Service;

/**
 * calculator
 */
@Service
public class Calculator {
    int sum(int a, int b){
        return a+b;
    }
}
