package com.tc.prefixmatcher.config;

public final class Constants {

    public static class Regex {
        public static final String PREFIX_REGEX = "[a-zA-Z0-9+\\-()]*";
    }

    public static class ErrorMessage {

        public static final String INVALID_ARGUMENT = "Please provide prefix file name as run argument! Ex: java -jar PrefixMatching.jar input.txt";
        public static final String FAILED_TO_READ_FILE = "Failed to read prefix file";
        public static final String INVALID_CHAR = "Invalid character in prefix: ";
    }

    public static class ConsoleMessage {

        public static final String INPUT_CASE_SENSITIVE_OPTIONS = "Do you want case-sensitive behavior? (yes/no): ";
        public static final String INPUT_YES = "yes";
        public static final String INPUT_YES_SHORT = "y";
        public static final String INPUT_PREFIX = "Enter prefix string:";
        public static final String EXIT_PROMPT = "quit()";
        public static final String EXIT_PROMPT_HELP = "Type quit() to exit the prompt";

        public static final String PREFIX_FOUND = "Prefix found: ";
        public static final String PREFIX_NOT_FOUND = "Prefix not found";
    }


}
