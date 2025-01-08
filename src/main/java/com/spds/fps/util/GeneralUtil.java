package com.spds.fps.util;

import lombok.extern.slf4j.Slf4j;

import java.security.SecureRandom;


/**
 * @author muhammad talib This class was creaded on 08-Jan-2025.
 */

@Slf4j
public class GeneralUtil {

    private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();

    /**
     * Generates a random alphanumeric string in the format "ABCDE12345",
     * consisting of 5 alphabetic characters followed by 5 numeric digits.
     */
    public static String generateRandomString() {
        StringBuilder sb = new StringBuilder(10);

        for (int i = 0; i < 5; i++) {
            int randomIndex = RANDOM.nextInt(LETTERS.length());
            sb.append(LETTERS.charAt(randomIndex));
        }

        for (int i = 0; i < 5; i++) {
            int randomIndex = RANDOM.nextInt(NUMBERS.length());
            sb.append(NUMBERS.charAt(randomIndex));
        }
        log.info("Generates a random alphanumeric string in the format ABCDE12345,", sb);

        return sb.toString();
    }
}
