package org.fasttrackit.qa4.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class Constants {
    public static final String USER_EMAIL = "test@gmail.com";
    public static final String USER_PASSWORD = "1234567890!Qqqqq";
    public static final String INVALID_USERNAME = "33432324";
    public static final String USER_INVALID_PASSWORD = "TESTTEST";
    public static final String RANDOM_USER_EMAIL = RandomStringUtils.randomAlphanumeric(10) + "@gmail.com";
    public static final String RANDOM_USER_PASSWORD = RandomStringUtils.randomAlphanumeric(15);
    public static final String INVALID_EMAIL_FORMAT= "dasasddas.com";
    public static final String USER_FIRSTNAME = "Dragos";
    public static final String USER_LASTNAME = RandomStringUtils.randomAlphabetic(4,10);
    public static final String USER_STREET_ADDRESS = "Mihai Eminescu 24";
    public static final String USER_CITY_NAME= "Blaj";
    public static final Integer USER_POSTCODE = 415500;
    public static final String USER_PHONE_NUMBER ="0742054340";
    public static final String RANDOM_REVIEW = RandomStringUtils.randomAlphabetic(10) + " Testing the code";
    public static final String ADMIN_USERNAME = "admin";
    public static final String ADMIN_PASSWORD = "parola11";

}
