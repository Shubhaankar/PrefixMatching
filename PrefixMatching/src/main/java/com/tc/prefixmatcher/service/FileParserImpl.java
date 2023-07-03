package com.tc.prefixmatcher.service;

import com.tc.prefixmatcher.config.Constants;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Implementation of the FileParser interface.
 *
 * This class provides an implementation of the FileParser interface. It uses a PrefixMatcherService
 * to add prefixes from a provided file to a PrefixMatcher.
 * The case sensitivity of the prefixes is determined by a flag provided during initialization.
 *
 * This class uses Java's try-with-resources construct to ensure that the stream opened on the file
 * is closed after use, even if an exception is thrown. If the file cannot be read, an unchecked
 * RuntimeException is thrown with a relevant error message.
 *
 * Constructor:
 * - FileParserImpl(PrefixMatcherService prefixMatcherService): Creates a new FileParserImpl instance.
 *   The PrefixMatcherService argument specifies the service to use for adding prefixes.
 *
 * Method:
 * - initialize(String filename, boolean isCaseSensitive): Initializes the parser with a specific file
 *   and a case sensitivity flag. The filename argument specifies the file to parse and the
 *   isCaseSensitive argument determines whether the parser should be case sensitive.
 */
public class FileParserImpl implements FileParser {

    private final PrefixMatcherService prefixMatcherService;

    public FileParserImpl(PrefixMatcherService prefixMatcherService) {
        super();
        this.prefixMatcherService = prefixMatcherService;
    }

    @Override
    public void initialize(String filename, boolean isCaseSensitive) {

        try (Stream<String> lines = Files.lines(Paths.get(filename))) {
            lines.forEach(line -> {
                if (!line.isBlank()) {

                    if (!isCaseSensitive) {
                        line = line.toLowerCase();
                    }
                    prefixMatcherService.addPrefix(line.trim());
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(Constants.ErrorMessage.FAILED_TO_READ_FILE, e);
        }
    }

}
