package com.tc.prefixmatcher.service;

/**
 * Interface for services that manage prefixes for matching purposes.
 *
 * The PrefixMatcherService interface provides methods for adding prefixes and finding the longest
 * matching prefix for a given string. Implementations of this interface are intended to manage a
 * collection of prefixes and provide efficient prefix matching functionality.
 *
 * The case sensitivity of the matching process is determined by a flag provided when finding the
 * longest matching prefix.
 *
 * Methods:
 * - addPrefix(String prefix): Adds a prefix to the service. The prefix argument specifies the
 *   prefix to be added.
 *
 * - longestMatchingPrefix(String str, boolean isCaseSensitive): Finds the longest prefix in the
 *   service that matches the start of the specified string. The str argument specifies the string
 *   for which to find the matching prefix. The isCaseSensitive argument determines whether the
 *   matching process should be case sensitive. Returns the longest matching prefix, or an empty
 *   string if no match is found.
 */
public interface PrefixMatcherService {

    void addPrefix(String prefix);

    String longestMatchingPrefix(String str, boolean isCaseSensitive);
}
