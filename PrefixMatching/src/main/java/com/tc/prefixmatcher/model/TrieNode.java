package com.tc.prefixmatcher.model;

public class TrieNode {
    TrieNode[] children;
    boolean isEndOfPrefix;

    TrieNode() {
        this.children = new TrieNode[95]; // 26 letters in lowercase + 26 in uppercase + 10 digits = 62, 'A' is 65, '0' is 48, so 122-65=57 + 1 = 58
        this.isEndOfPrefix = false;
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public void setEndOfPrefix(boolean isEndOfPrefix) {
        this.isEndOfPrefix = isEndOfPrefix;
    }
}
