package com.tc.prefixmatcher;

import com.tc.prefixmatcher.config.Constants;
import com.tc.prefixmatcher.model.PrefixMatcher;
import com.tc.prefixmatcher.service.FileParser;
import com.tc.prefixmatcher.service.FileParserImpl;
import com.tc.prefixmatcher.service.PrefixMatcherService;
import com.tc.prefixmatcher.service.PrefixMatcherServiceImpl;

import java.util.Scanner;

import static java.lang.System.exit;

public class PrefixMatcherApplication {

    public static void main(String[] args) {

        if (args.length < 1) {
            System.err.println(Constants.ErrorMessage.INVALID_ARGUMENT);
            exit(0);
        }
        startPrompt(args[0]);
    }

    private static void startPrompt(String fileName) {

        boolean isCaseSensitiveSearch = false;

        System.out.println(Constants.ConsoleMessage.INPUT_CASE_SENSITIVE_OPTIONS);
        System.out.println(Constants.ConsoleMessage.EXIT_PROMPT_HELP);

        Scanner scanner = new Scanner(System.in);
        String response = scanner.nextLine().trim().toLowerCase();

        // Check user response and act accordingly
        if (response.equals(Constants.ConsoleMessage.INPUT_YES) || response.equals(Constants.ConsoleMessage.INPUT_YES_SHORT)) {
            isCaseSensitiveSearch = true;
        }
        PrefixMatcher prefixMatcher = new PrefixMatcher();
        PrefixMatcherService prefixMatcherService = new PrefixMatcherServiceImpl(prefixMatcher);

        FileParser fileParser = new FileParserImpl(prefixMatcherService);
        fileParser.initialize(fileName, isCaseSensitiveSearch);

        System.out.println(Constants.ConsoleMessage.INPUT_PREFIX);

        String input = scanner.nextLine();
        while (!input.equalsIgnoreCase(Constants.ConsoleMessage.EXIT_PROMPT)) {
            String longestMatchingPrefix = prefixMatcherService.longestMatchingPrefix(input, isCaseSensitiveSearch);

            if (longestMatchingPrefix.isBlank()) {
                System.err.println(Constants.ConsoleMessage.PREFIX_NOT_FOUND);
            } else {
                System.out.println(Constants.ConsoleMessage.PREFIX_FOUND + longestMatchingPrefix);
            }

            System.out.println(Constants.ConsoleMessage.INPUT_PREFIX);
            input = scanner.nextLine();
        }
        scanner.close();
    }
}
