/*
 * This is a program by K.G.Sampath Sandaruwan.
 * Smcmails@gmail.com
 * 0774471293
 * Sandaruwankgs.wordpress.com
 */
package Includes;

/**
 *
 * @author K.G.S.Sandaaruwan
 */
public class InputChecker {

    public static boolean isBusNumber(String busNumber) {
        boolean test = false;
        String[] numberParts = busNumber.split("-");
        int number;
        if (numberParts.length == 2) {
            try {
                if (numberParts[1].length() == 4) {
                    number = Integer.parseInt(numberParts[1]);
                    if (number > 0 && number < 10000) {
                        test = true;
                    }
                }
            } catch (Exception ex) {
                test = false;
            }
        }
        return test;
    }

    public static String modifyBusNumber(String busNumber) {
        String[] numberParts = busNumber.split("-");
        int number = Integer.parseInt(numberParts[1]);

        String secondPart = numberParts[1];
        if (number < 1000) {
            if (number > 99) {
                secondPart = "0" + number;
            } else if (number > 9) {
                secondPart = "00" + number;
            } else if (number > 0) {
                secondPart = "000" + number;
            }
        }

        return numberParts[0] + "-" + secondPart;
    }

    public static boolean isANumber(String numberText) {
        int number;
        boolean isNumber = false;

        try {
            number = Integer.parseInt(numberText);
            if (number > 0) {
                isNumber = true;
            }
        } catch (Exception e) {
        }
        return isNumber;
    }
}
