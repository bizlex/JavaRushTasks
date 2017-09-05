package com.javarush.task.task10.lesson02.home01;

import java.lang.*;
import java.math.BigInteger;

/* Конвертер систем счислений
Реализуйте логику метода convertNumberToOtherNumerationSystem, который должен переводить число number.getDigit()
из одной системы счисления(numerationSystem) в другую (expectedNumerationSystem)
бросьте NumberFormatException, если переданное число некорректно, например, число "120" с системой счисления 2
Валидация для - number.getDigit() - целое не отрицательное
Метод main не участвует в тестировании
*/

public class Solution {
    public static void main(String[] args) {
        Number number = new Number(NumerationSystemType._10, "6");
        Number result = convertNumberToOtherNumerationSystem(number, NumerationSystemType._2);
        System.out.println(result);    //expected 110
    }

    public static Number convertNumberToOtherNumerationSystem(Number number, NumerationSystem expectedNumerationSystem) {
        BigInteger res = null;
        try {
            res = new BigInteger(number.getDigit(), number.getNumerationSystem().getNumerationSystemIntValue());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return new Number(expectedNumerationSystem, res.toString(expectedNumerationSystem.getNumerationSystemIntValue()));
    }
}
