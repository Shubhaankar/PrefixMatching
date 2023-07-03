package com.tc.prefixmatcher.config;

/**
 * This class contains constant values that are used across the project.
 * It is divided into two inner classes:
 * ErrorMessage and ConsoleMessage.
 * ErrorMessage contains error messages that are displayed when exceptions occur or invalid input is given.
 * ConsoleMessage contains strings that are displayed in the console for user interaction.
 * Since all members of this class are constant values and this class is not expected to be instantiated,
 * it is declared as final.
 */
public final class Constants {

    /**
     * This inner class contains error messages that are displayed in the console when exceptions occur
     * or when invalid input is given to the program.
     */
    public static class ErrorMessage {

        public static final String INVALID_ARGUMENT = "Please provide prefix file name as program argument! Ex: java -jar PrefixMatching.jar absolute-path-to-input.txt";
        public static final String FAILED_TO_READ_FILE = "Failed to read prefix file";
        public static final String INVALID_CHAR = "Invalid character in prefix: ";
    }

    /**
     * This inner class contains console messages that guide the user in using the program and display the results
     * of the prefix matching operation.
     */
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
