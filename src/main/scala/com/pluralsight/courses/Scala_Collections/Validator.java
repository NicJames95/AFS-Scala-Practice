package com.pluralsight.courses.Scala_Collections;

public class Validator {
    public boolean validate(String number) {
        int sum = 0;
        boolean isSecond = false;

        for (int index = number.length() - 1; index >= 0; index--) {
            // get current string digit, converting to an int
            int digit = number.charAt(index) - '0';

            if (isSecond)
                digit = digit * 2;

            // Add two digits to handle products > 9
            sum += digit / 10;
            sum += digit % 10;

            isSecond = !isSecond;
        }
        return (sum % 10 == 0);
    }
}
