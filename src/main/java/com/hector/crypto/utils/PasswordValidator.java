/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hector.crypto.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Hector
 */
public class PasswordValidator {
    
    private static PasswordValidator INSTANCE = new PasswordValidator();
    private static String pattern = null;
 
    /**
     * No one can make a direct instance
     * */
    private PasswordValidator()
    {
        //do nothing
    }
 
    /**
     * Force the user to build a validator using this way only
     * */
    public static PasswordValidator buildValidator( boolean forceSpecialChar,
                                                    boolean forceCapitalLetter,
                                                    boolean forceNumber,
                                                    int minLength,
                                                    int maxLength)
    {
        StringBuilder patternBuilder = new StringBuilder("((?=.*[a-zA-Z0-9@#$%+_.-])");
 
        if (forceSpecialChar)
        {
            patternBuilder.append("(?=.*[@#$%+_.-])");
        }
 
        if (forceCapitalLetter)
        {
            patternBuilder.append("(?=.*[A-Z])");
        }
 
        if (forceNumber)
        {
            patternBuilder.append("(?=.*[0-9])");
        }
 
        patternBuilder.append(".{" + minLength + "," + maxLength + "})");
        pattern = patternBuilder.toString();
 
        return INSTANCE;
    }
 
    /**
     * Here we will validate the password
     * */
    public static boolean validatePassword(final String password){
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(password);
        return m.matches();
    }
}
