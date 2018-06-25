package com.example.brons.calc;

/**
 * Abstract class that holds the Roman Numeral, integer equivalent, and the converted values of both.
 * Also holds the unique numerals with their corresponding values in arrays.
 * @author Tommy Pham (348559527)
 * @since 2018/06/13
 */
public abstract class romanObject {
    protected int romanInt, romanIntConvert = 0;
    protected String romanNumeral = "";
    protected StringBuilder romanNumeralConvert = new StringBuilder();
    protected Character[] numeralList = {'M','D', 'C', 'L', 'X', 'V', 'I', ' '};
    protected Integer[] numeralValueList = {1000, 500, 100, 50, 10, 5, 1, 0};
}
