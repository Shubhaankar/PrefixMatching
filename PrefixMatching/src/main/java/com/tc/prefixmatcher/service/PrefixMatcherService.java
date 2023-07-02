package com.tc.prefixmatcher.service;

public interface PrefixMatcherService {

    void addPrefix(String prefix);

    String longestMatchingPrefix(String str, boolean isCaseSensitive);
}
