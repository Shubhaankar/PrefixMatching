package com.tc.prefixmatcher.service;

import com.tc.prefixmatcher.model.PrefixMatcher;

public class PrefixMatcherServiceImpl implements PrefixMatcherService {

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
        return prefixMatcher.longestMatchingPrefix(str);
    }

    @Override
    public void addPrefix(String prefix) {
        prefixMatcher.addPrefix(prefix);
    }

}
