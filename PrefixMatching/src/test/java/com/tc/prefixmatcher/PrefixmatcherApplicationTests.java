package com.tc.prefixmatcher;

import com.tc.prefixmatcher.model.PrefixMatcher;
import com.tc.prefixmatcher.service.FileParser;
import com.tc.prefixmatcher.service.FileParserImpl;
import com.tc.prefixmatcher.service.PrefixMatcherService;
import com.tc.prefixmatcher.service.PrefixMatcherServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrefixmatcherApplicationTests {

	private static final String TEST_FILE_PATH = "input_test.txt";

	@Test
	public void testLongestMatchingPrefix() {
		PrefixMatcher prefixMatcher = new PrefixMatcher();
		PrefixMatcherService prefixMatcherService = new PrefixMatcherServiceImpl(prefixMatcher);
		FileParser fileParser = new FileParserImpl(prefixMatcherService);
		fileParser.initialize(TEST_FILE_PATH, false);
		assertEquals("cwahad9v8z", prefixMatcherService.longestMatchingPrefix("cWAHaD9V8zsrerg", false));
		assertEquals("-uvc5oj", prefixMatcherService.longestMatchingPrefix("-Uvc5oJ", false));
		assertEquals("/nxj7fba", prefixMatcherService.longestMatchingPrefix("/NxJ7fbA5w2ds", false));
		assertEquals("(xfhdh", prefixMatcherService.longestMatchingPrefix("(Xfhdh(Xfhdh", false));
	}

	@Test
	public void testCaseSensitivity() {
		PrefixMatcher prefixMatcher = new PrefixMatcher();
		PrefixMatcherService prefixMatcherService = new PrefixMatcherServiceImpl(prefixMatcher);
		FileParser fileParser = new FileParserImpl(prefixMatcherService);
		fileParser.initialize(TEST_FILE_PATH, false);
		assertEquals("cwahad9v8z", prefixMatcherService.longestMatchingPrefix("cWAHaD9V8zsrerg", false));
		fileParser.initialize(TEST_FILE_PATH, true);
		assertEquals("", prefixMatcherService.longestMatchingPrefix("CARPET", true));
	}

}
