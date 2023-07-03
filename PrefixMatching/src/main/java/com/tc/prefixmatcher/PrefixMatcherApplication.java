package com.tc.prefixmatcher;

import com.tc.prefixmatcher.config.Constants;
import com.tc.prefixmatcher.model.PrefixMatcher;
import com.tc.prefixmatcher.service.FileParser;
import com.tc.prefixmatcher.service.FileParserImpl;
import com.tc.prefixmatcher.service.PrefixMatcherService;
import com.tc.prefixmatcher.service.PrefixMatcherServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

import static java.lang.System.exit;

public class PrefixMatcherApplication {

    private static final Logger logger = LoggerFactory.getLogger(PrefixMatcherApplication.class);

    public static void main(String[] args) {

        // Checks whether file name is provided or not.
        if (args.length < 1) {
            System.err.println(Constants.ErrorMessage.INVALID_ARGUMENT);
            exit(0);
        }

        // Starts a prompt for the user to interact with.
        startPrompt(args[0]);
    }

    private static void startPrompt(String fileName) {

        // Default case sensitivity for search is set to false.
        boolean isCaseSensitiveSearch = false;

        System.out.println(Constants.ConsoleMessage.INPUT_CASE_SENSITIVE_OPTIONS);
        System.out.println(Constants.ConsoleMessage.EXIT_PROMPT_HELP);

        Scanner scanner = new Scanner(System.in);
        String response = scanner.nextLine().trim().toLowerCase();

        // Check user response and act accordingly
        if (response.equals(Constants.ConsoleMessage.INPUT_YES) || response.equals(Constants.ConsoleMessage.INPUT_YES_SHORT)) {
            isCaseSensitiveSearch = true;
            logger.debug("Case sensitive search is chosen.");
        }
        PrefixMatcher prefixMatcher = new PrefixMatcher();
        PrefixMatcherService prefixMatcherService = new PrefixMatcherServiceImpl(prefixMatcher);

        logger.debug("Beginning the file initialization.");
        FileParser fileParser = new FileParserImpl(prefixMatcherService);
        fileParser.initialize(fileName, isCaseSensitiveSearch);
        logger.debug("File initialization complete.");

        System.out.println(Constants.ConsoleMessage.INPUT_PREFIX);

        // Read user input and continues to do so until the input is "quit()".
        String input = scanner.nextLine();
        while (!input.equalsIgnoreCase(Constants.ConsoleMessage.EXIT_PROMPT)) {
            String longestMatchingPrefix = prefixMatcherService.longestMatchingPrefix(input, isCaseSensitiveSearch);

            // If a matching prefix is found, print it to the console. If not, print a message indicating no prefix was found.
            if (longestMatchingPrefix.isBlank()) {
                System.err.println(Constants.ConsoleMessage.PREFIX_NOT_FOUND);
            } else {
                System.out.println(Constants.ConsoleMessage.PREFIX_FOUND + longestMatchingPrefix);
            }

            // Prompt for a new prefix.
            System.out.println(Constants.ConsoleMessage.INPUT_PREFIX);
            input = scanner.nextLine();
        }
        // Finally, close the scanner.
        scanner.close();
    }
}