package com.tc.prefixmatcher.model;

import com.tc.prefixmatcher.config.Constants;

public class PrefixMatcher {
    private final TrieNode root;

    public PrefixMatcher() {
        root = new TrieNode();
    }

    public void addPrefix(String prefix) {
//        if (!prefix.matches(Constants.Regex.PREFIX_REGEX)) {
//            throw new IllegalArgumentException(Constants.ErrorMessage.INVALID_CHAR + prefix);
//        }

        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 32;

            if (index < 0) {
                throw new IllegalArgumentException(Constants.ErrorMessage.INVALID_CHAR + c);
            }
            if (node.getChildren()[index] == null) {
                node.getChildren()[index] = new TrieNode();
            }
            node = node.getChildren()[index];
        }
        node.setEndOfPrefix(true);
    }

    public String longestMatchingPrefix(String str) {
        TrieNode node = root;
        StringBuilder prefixBuilder = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            int index = c - 32;
            if (index < 0 || node.getChildren()[index] == null) {
                break; // stop if encounter an invalid character
            }

            prefixBuilder.append(c);
            node = node.getChildren()[index];

            if (node.isEndOfPrefix) {
                result = new StringBuilder(prefixBuilder);
            }
        }
        return result.toString();
    }
}