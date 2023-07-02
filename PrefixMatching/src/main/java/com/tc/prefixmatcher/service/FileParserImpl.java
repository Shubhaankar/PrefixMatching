package com.tc.prefixmatcher.service;

import com.tc.prefixmatcher.config.Constants;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

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
                if (!isCaseSensitive) {
                    line = line.toLowerCase();
                }
                prefixMatcherService.addPrefix(line);
            });
        } catch (IOException e) {
            throw new RuntimeException(Constants.ErrorMessage.FAILED_TO_READ_FILE, e);
        }
    }

}
