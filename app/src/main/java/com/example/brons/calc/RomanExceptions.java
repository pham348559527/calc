package com.example.brons.calc;

/**
 * Throws a custom exception.
 * This exception relates to any exceptions relating to Roman Numerals
 * (ex. if there is an invalid numeral).
 * @author Tommy Pham (348559527)
 * @since 2018/06/14
 *
 */
public class RomanExceptions extends Exception {
    protected RomanExceptions () {
    }

    protected RomanExceptions (String message) {
        super (message);
        System.out.print("ERROR: ");
    }
}

