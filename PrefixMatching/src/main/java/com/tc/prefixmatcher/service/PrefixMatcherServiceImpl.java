package com.tc.prefixmatcher.service;

import com.tc.prefixmatcher.PrefixMatcherApplication;
import com.tc.prefixmatcher.model.PrefixMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation of the PrefixMatcherService interface that utilizes a PrefixMatcher.
 *
 * This service implementation provides a way to add prefixes and find the longest matching prefix
 * for a given string using a PrefixMatcher object. The case sensitivity of the matching process
 * is determined by a flag provided when finding the longest matching prefix.
 *
 * This class uses a logger to provide debug level logging for prefix matching operations.
 *
 * Constructor:
 * - PrefixMatcherServiceImpl(PrefixMatcher prefixMatcher): Constructs a new PrefixMatcherServiceImpl
 *   with the specified PrefixMatcher. The prefixMatcher argument specifies the PrefixMatcher that
 *   this service will use to manage prefixes and perform matching operations.
 *
 * Methods:
 * - longestMatchingPrefix(String str, boolean isCaseSensitive): Converts the input string to lower case
 *   if the isCaseSensitive flag is false. Logs a debug message indicating the state of the isCaseSensitive
 *   flag. Then calls the longestMatchingPrefix method of the PrefixMatcher with the processed string.
 *   Returns the longest matching prefix, or an empty string if no match is found.
 *
 * - addPrefix(String prefix): Calls the addPrefix method of the PrefixMatcher with the specified prefix.
 */
public class PrefixMatcherServiceImpl implements PrefixMatcherService {

    private static Logger logger = LoggerFactory.getLogger(PrefixMatcherServiceImpl.class);

    private final PrefixMatcher prefixMatcher;

    public PrefixMatcherServiceImpl(PrefixMatcher prefixMatcher) {
        super();
        this.prefixMatcher = prefixMatcher;
    }

    @Override
    public String longestMatchingPrefix(String str, boolean isCaseSensitive) {
        if (!isCaseSensitive) {
            str = str.toLowerCase();
        }

        logger.debug("Searching the string with case sensitive flag set to {}",isCaseSensitive);
        return prefixMatcher.longestMatchingPrefix(str);
    }

    @Override
    public void addPrefix(String prefix) {
        prefixMatcher.addPrefix(prefix);
    }

}
