package com.tc.prefixmatcher.model;

import com.tc.prefixmatcher.config.Constants;



/**
 * This class is the core of the prefix matching solution. It encapsulates a Trie data structure
 * represented by a root TrieNode. The class provides methods to add prefixes to the trie and find
 * the longest matching prefix for a given string. The PrefixMatcher is used to build the trie
 * structure based on the provided prefixes and perform prefix matching operations.
 * It uses the TrieNode class to create the nodes of the trie.
 */
public class PrefixMatcher {
    private final TrieNode root;

    public PrefixMatcher() {
        root = new TrieNode();
    }

    /**
     * This method adds a prefix to the trie. It iterates over each character in the prefix
     * and creates a new TrieNode for each character if it doesn't already exist in the trie.
     * It uses the ASCII value of the character to index into the children array of the TrieNode.
     * The last node in the prefix path is marked as the end of a prefix.
     *
     * @param prefix The prefix string to be added to the trie.
     * @throws IllegalArgumentException if a character in the prefix is not in the ASCII range 32 to 126.
     */
    public void addPrefix(String prefix) {
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

    /**
     * This method finds the longest matching prefix in the trie for a given string.
     * It traverses the trie based on the characters in the string. If a node is marked as
     * the end of a prefix, it updates the result. The traversal stops if it encounters a character
     * that is not in the trie or is not in the ASCII range 32 to 126.
     *
     * @param str The string for which to find the longest matching prefix.
     * @return The longest matching prefix. If no matching prefix is found, an empty string is returned.
     */
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