package com.tc.prefixmatcher.model;


/**
 * A class representing a node in a Trie data structure.
 *
 * Each TrieNode has an array of child nodes and a boolean flag indicating whether it represents
 * the end of a prefix. The array of children is an array of 95 elements representing ASCII characters
 * from 32 to 127, each pointing to a child TrieNode or null. The isEndOfPrefix flag
 * indicates whether this node represents the end of a prefix in the Trie.
 *
 * Methods:
 * - getChildren(): Returns the array of child nodes.
 * - setEndOfPrefix(boolean isEndOfPrefix): Sets the isEndOfPrefix flag.
 */
public class TrieNode {
    TrieNode[] children;
    boolean isEndOfPrefix;

    TrieNode() {
        this.children = new TrieNode[95]; // 32-127
        this.isEndOfPrefix = false;
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public void setEndOfPrefix(boolean isEndOfPrefix) {
        this.isEndOfPrefix = isEndOfPrefix;
    }
}
