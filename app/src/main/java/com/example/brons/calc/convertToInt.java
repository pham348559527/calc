package com.example.brons.calc;

/**
 * Converts a Roman Numeral to its integer equivalent, if applicable.
 * @author Tommy Pham (348559527)
 * @since 2018/06/13
 */
public class convertToInt extends romanObject {

    protected convertToInt () {
        /*
         * If no input: returns error message
         */
        System.out.println("No string was given");
    }

    /**
     * Converts a Roman Numeral to its integer equivalent.
     * @param numeral A Roman Numeral.
     */
    protected convertToInt (String numeral) {

        this.romanNumeral = numeral;

        try {
            if (numeral.equals("")) {
                // If input was blank: returns error message (no numeral idenfitied)
                throw new RomanExceptions(numeral);
            }
            else {
                for (int i = 0; i < numeral.length(); i++) {
                    if (numeralGetIndex(numeral.charAt(i)) == -1) {
                        // if a numeral is found to not be a valid numeral (for numerals between 1-4999), throws exception
                        throw new RomanExceptions(numeral);
                    }

                    for (int j = 0; j < numeralList.length; j++) {
                        if (numeral.charAt(i) == numeralList[j]) {
                            if (j - 2 >= 0 && i + 1 < numeral.length()) {
                                if (numeralValueList[numeralGetIndex(numeral.charAt(i))] < numeralValueList[j-2] && numeral.charAt(i+1) == numeralList[j-2]) {
                                    /*
                                     * checks for subtraction principle (for integers of 9 * 10 ^ x where x is any whole number between 0 and 2)
                                     * 9000 (9 * 10 ^ 3) is outside the range of this project so is invalid
                                     */
                                    romanIntConvert += (numeralValueList[j-2]-numeralValueList[numeralGetIndex(numeral.charAt(i))]);
                                    i++;
                                    break;
                                }
                                if (numeralValueList[numeralGetIndex(numeral.charAt(i))] < numeralValueList[j-2] && numeral.charAt(i+1) == numeralList[j-1]) {
                                    /*
                                     * checks for subtraction principle (for integers of 4 * 10 ^ x where x is any whole number between 0 and 2)
                                     * MMMM or 4000 is a special case so is not included
                                     */
                                    romanIntConvert += (numeralValueList[j-1]-numeralValueList[numeralGetIndex(numeral.charAt(i))]);
                                    i++;
                                    break;
                                }
                            }
                            /*
                            if no subtraction principle, calculates as normal
                            adds the value of the numeral found
                            by comparing it against a list with the numeral's equivalent integer
                            */
                            romanIntConvert += numeralValueList[j];
                            break;
                        }
                    }
                }
            }

            /*
             * These catch statements catch their respective exceptions
             * and print out statements based on the exception encountered.
             */
        } catch (NullPointerException e) {
            System.out.println("Number format exception");
        } catch (RomanExceptions e) {
            System.out.println("No numeral identified");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Out of bounds exception");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Out of bounds exception");
        }
    }

    /*
     * Shortcut to get the index of an object inside an array.
     * @param n The char that needs to be found.
     * @return The index of the found char.
     */
    protected Integer numeralGetIndex (char n) {
        return java.util.Arrays.asList(numeralList).indexOf(n);
    }

    // Returns the result of the conversion process.
    protected Integer convertedToInt () {
        return this.romanIntConvert;
    }

    protected boolean checkRoman (int x) {
        try {
            if (x > 0 && x <= 4000) {
                convertToInt convertInt = new convertToInt(this.romanNumeralConvert.toString());
                if (this.romanInt == convertInt.convertedToInt()) {
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
