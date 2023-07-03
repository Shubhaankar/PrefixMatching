package com.tc.prefixmatcher.service;

import com.tc.prefixmatcher.model.PrefixMatcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PrefixMatcherServiceImplTest {

	private PrefixMatcher prefixMatcher;
	private PrefixMatcherServiceImpl prefixMatcherService;

	// The @BeforeEach annotation ensures this method is run before each test
	@BeforeEach
	public void setUp() {
		// We create a mock of PrefixMatcher using Mockito
		prefixMatcher = Mockito.mock(PrefixMatcher.class);
		// We instantiate the service we want to test, injecting the mock
		prefixMatcherService = new PrefixMatcherServiceImpl(prefixMatcher);
	}

	// Test for the longestMatchingPrefix() method
	@Test
	public void testLongestMatchingPrefix() {
		// Define the test input and expected output
		String testString = "prefixtest";
		String expectedPrefix = "prefix";

		// Configure the mock to return a specific result when called
		when(prefixMatcher.longestMatchingPrefix(anyString())).thenReturn(expectedPrefix);

		// Call the method under test with case-sensitive approach.
		String result = prefixMatcherService.longestMatchingPrefix(testString, false);

		// Verify that the mock was called with the expected parameters
		verify(prefixMatcher, times(1)).longestMatchingPrefix(testString.toLowerCase());
		// Check that the result is what we expected
		assertEquals(expectedPrefix, result);
	}

	// Test for the addPrefix() method
	@Test
	public void testAddPrefix() {
		// Test input
		String prefix = "prefix";
		// Configure the mock to do nothing when the method is called
		doNothing().when(prefixMatcher).addPrefix(anyString());

		// Call the method under test
		prefixMatcherService.addPrefix(prefix);

		// Verify that the mock was called with the expected parameters
		verify(prefixMatcher, times(1)).addPrefix(prefix);
	}
}
