package com.tc.prefixmatcher.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.tc.prefixmatcher.config.Constants;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class PrefixMatcherTest {
	
	PrefixMatcher prefixMatcher;
	
    @BeforeAll
    public void setUp() {
    	prefixMatcher = new PrefixMatcher();

        // Add different prefixes to the PrefixMatcher object
        prefixMatcher.addPrefix("ABC");
        prefixMatcher.addPrefix("ABCD");
        prefixMatcher.addPrefix("ABCDE");
        prefixMatcher.addPrefix("ABF");
        prefixMatcher.addPrefix("ABCD");
        prefixMatcher.addPrefix("dsABCD");
        prefixMatcher.addPrefix("12ABCD");
    }

    // Testing longestMatchingPrefix method of PrefixMatcher when a matching prefix is found
    @Test
    public void testLongestMatchingPrefix_stringFound() {
        // Run longestMatchingPrefix method on different strings and validate the output

        String result = prefixMatcher.longestMatchingPrefix("ABCDEF");
        assertEquals("ABCDE", result);

        result = prefixMatcher.longestMatchingPrefix("ABCF");
        assertEquals("ABC", result);

        result = prefixMatcher.longestMatchingPrefix("ABCDE");
        assertEquals("ABCDE", result);
    }

    // Testing longestMatchingPrefix method of PrefixMatcher when no matching prefix is found
    @Test
    public void testLongestMatchingPrefix_stringNotFound() {
        // Run longestMatchingPrefix method on different strings and validate the output

        String result = prefixMatcher.longestMatchingPrefix("");
        assertEquals("", result);

        result = prefixMatcher.longestMatchingPrefix("dsABG");
        assertEquals("", result);

        result = prefixMatcher.longestMatchingPrefix("1XYZ");
        assertEquals("", result);

        result = prefixMatcher.longestMatchingPrefix("XYZ");
        assertEquals("", result);
        
        result = prefixMatcher.longestMatchingPrefix("-XYZ");
        assertEquals("", result);
    }

    // Testing addPrefix method of PrefixMatcher
    @Test
    public void testAddPrefix() {
        PrefixMatcher prefixMatcher = new PrefixMatcher();

        // Initially, there are no prefixes, so longestMatchingPrefix should return an empty string
        String result = prefixMatcher.longestMatchingPrefix("ABCDEF");
        assertEquals("", result);

        // After adding a prefix, longestMatchingPrefix should return that prefix if it matches the input string
        prefixMatcher.addPrefix("ABC");
        result = prefixMatcher.longestMatchingPrefix("ABCDEF");
        assertEquals("ABC", result);

        // If we add a longer matching prefix, longestMatchingPrefix should return the longer one
        prefixMatcher.addPrefix("ABCDE");
        result = prefixMatcher.longestMatchingPrefix("ABCDEFGHR");
        assertEquals("ABCDE", result);

        // Adding a non-matching prefix should not affect the output
        prefixMatcher.addPrefix("XYZ");
        result = prefixMatcher.longestMatchingPrefix("ABCDE");
        assertEquals("ABCDE", result);
    }

    // Testing addPrefix method of PrefixMatcher when adding an invalid string
    @Test
    public void testAddPrefixException(){
        // Adding an invalid string
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            prefixMatcher.addPrefix("'\n'");
        });
        assertTrue(exception.getMessage().contains(Constants.ErrorMessage.INVALID_CHAR));
    }
}






