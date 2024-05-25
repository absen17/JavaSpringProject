package com.infy.validator;

import com.infy.exception.BankException;
import com.infy.model.Login;

public class LoginValidator {
	
	public static void validate(Login login) throws BankException {
        validateMobileNumber(login.getMobileNumber());
        validatePassword(login.getPassword());
    }

    private static void validateMobileNumber(Long mobileNumber) throws BankException {
        String mobileStr = mobileNumber.toString();
        if (mobileStr.length() != 10 || mobileStr.chars().distinct().count() == 1) {
            throw new BankException("Mobile number should be a 10-digit number with all digits not the same.");
        }
    }

    private static void validatePassword(String password) throws BankException {
        if (password.length() < 8 || !password.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*")) {
            throw new BankException("Password should contain at least 8 characters with at least one digit, one upper case letter, one lower case letter, and one special character.");
        }
    }
}