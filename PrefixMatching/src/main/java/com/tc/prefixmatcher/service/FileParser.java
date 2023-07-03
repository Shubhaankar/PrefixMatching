package com.tc.prefixmatcher.service;

/**
 * Interface for a service that parses files.
 *
 * The FileParser interface defines the structure for a service that handles
 * file parsing. It requires the implementing class to define a method for
 * initializing the parser with a specific file and a case sensitivity flag.
 *
 * Method:
 * - initialize(String filename, boolean isCaseSensitive): Initializes the parser
 *   with a specific file and a case sensitivity flag. The filename argument
 *   specifies the file to parse and the isCaseSensitive argument determines
 *   whether the parser should be case sensitive.
 */
public interface FileParser {

    void initialize(String filename, boolean isCaseSensitive);
}
