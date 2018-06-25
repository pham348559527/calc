package com.example.brons.calc;

/**
 * Converts an integer to its Roman Numeral, if applicable.
 * @author Tommy Pham (348559527)
 * @since 2018/06/14
 */
public class convertToString extends romanObject {

    protected convertToString () {
        /*
         * If no input: returns error message
         */
        System.out.println("No integer was given");
    }

    /**
     * Converts an integer to its Roman numeral equivalent.
     * @param romanInt An integer.
     */
    protected convertToString (Integer romanInt) {
        this.romanInt = romanInt;
        Integer tempInt = romanInt;

        /*
         * Checks the integer for possible Roman numerals,
         * if a Roman numeral is identified
         * (by checking if the integer is greater than a certain value),
         * appends that Roman numeral to a String.
         */
        while (tempInt != 0) {
            for (int j = 0; j < romanInt; j++) {
                if (tempInt >= numeralValueList[j]) {
                    if (tempInt - numeralValueList[j+1] * 9 >= 0 && Integer.toString(numeralValueList[j+1]).charAt(0) == '1') {
                        // check for subtraction principle
                        tempInt = tempInt - (numeralValueList[j+1] * 9);
                        romanNumeralConvert.append(numeralList[j+1]).append(numeralList[j-1]);
                        break;
                    }
                    else if (tempInt - numeralValueList[j] * 4 >= 0 && Integer.toString(numeralValueList[j]).charAt(0) == '1') {
                        // check for subtraction principle
                        if (tempInt - numeralValueList[j] * 4 >= 0 && romanInt >= 4000) {
                            tempInt = tempInt - numeralValueList[j];
                            romanNumeralConvert.append(numeralList[j]);
                            break;
                        }
                        tempInt = tempInt - (numeralValueList[j] * 4);
                        romanNumeralConvert.append(numeralList[j]).append(numeralList[j-1]);
                        break;
                    }
                    else {
                        /*
                        if no subtraction principle, calculates as normal
                        adds the numeral found
                        by comparing it against a list with the integer's equivalent numeral
                         */
                        tempInt = tempInt - numeralValueList[j];
                        romanNumeralConvert.append(numeralList[j]);
                        break;
                    }
                }
            }
        }
    }

    // Returns the result of the conversion process.
    protected String convertedToNumeral () {
        return this.romanNumeralConvert.toString();
    }

    protected boolean checkRoman (String s) {
        try {
            if (!"".equals(s)) {
                convertToString convertStr = new convertToString(this.romanIntConvert);
                if (this.romanNumeral.equals(convertStr.convertedToNumeral())) {
                    // Double-checks with the other convert to see if the conversion was correct
                    return true;
                }
                else {
                    /*
                     * If the conversion did not succeed on both sides,
                     * then the given input is confirmed to be invalid
                     * and throws an exception to show this
                     */
                    throw new RomanExceptions();
                }
            }

        } catch (RomanExceptions e) {
            System.out.println("Something went wrong: double-check if the inputted roman numeral is valid");
            return false;
        }
        return false;
    }
}

