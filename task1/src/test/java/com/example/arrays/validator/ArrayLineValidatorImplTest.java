package com.example.arrays.validator;

import com.example.arrays.validator.impl.ArrayLineValidatorImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArrayLineValidatorImplTest {

    private static final String VALID_SEMICOLON_LINE = "1; 2; 3";
    private static final String VALID_COMMA_LINE = "1, 2, 3";
    private static final String VALID_DASH_LINE = "1 - 2 - 3";
    private static final String VALID_SPACE_LINE = "3 4 7";
    private static final String EMPTY_LINE = "";
    private static final String INVALID_LINE = "1y1 21 32";

    private ArrayLineValidator validator;

    @BeforeEach
    void setUp() {
        validator = new ArrayLineValidatorImpl();
    }

    @Test
    void isValidShouldReturnTrueForSemicolonLine() {
        assertTrue(validator.isValid(VALID_SEMICOLON_LINE));
    }

    @Test
    void isValidShouldReturnTrueForCommaLine() {
        assertTrue(validator.isValid(VALID_COMMA_LINE));
    }

    @Test
    void isValidShouldReturnTrueForDashLine() {
        assertTrue(validator.isValid(VALID_DASH_LINE));
    }

    @Test
    void isValidShouldReturnTrueForSpaceLine() {
        assertTrue(validator.isValid(VALID_SPACE_LINE));
    }

    @Test
    void isValidShouldReturnTrueForEmptyLine() {
        assertTrue(validator.isValid(EMPTY_LINE));
    }

    @Test
    void isValidShouldReturnFalseForInvalidLine() {
        assertFalse(validator.isValid(INVALID_LINE));
    }
}