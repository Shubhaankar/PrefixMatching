package com.tc.prefixmatcher.service;

// Import statements

import com.tc.prefixmatcher.config.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)  // This annotation integrates the Mockito framework with JUnit 5
public class FileParserImplTest {

    private static final String TEST_FILE_PATH = "input_test.txt";
    private static final String EMPTY_FILE_PATH = "empty_input.txt";
    private static final String SPACES_FILE_PATH = "empty_input_spaces.txt";

    private static final String SYMBOLS_FILE_PATH = "input_special_chars.txt";

    // Creates a mock instance of the PrefixMatcherService class
    @Mock
    private PrefixMatcherService prefixMatcherService;

    private FileParser fileParser;

    // Specifies that the method should be run before each test
    @BeforeEach
    public void setUp() {
        fileParser = new FileParserImpl(prefixMatcherService);
    }

    @Test
    public void testInitialize_withValidFile() {
        String filename = TEST_FILE_PATH;
        fileParser.initialize(filename, true);
        // The file has 20 lines, verify that the addPrefix method was called 20 times
        verify(prefixMatcherService, times(20)).addPrefix(anyString());
    }

    @Test
    public void testInitialize_withInvalidFile() {
        String filename = "invalidFile.txt";
        // Asserts that an exception of type RuntimeException is thrown with a specific message
        Exception exception = assertThrows(RuntimeException.class, () -> fileParser.initialize(filename, true));
        assertTrue(exception.getMessage().contains(Constants.ErrorMessage.FAILED_TO_READ_FILE));
    }

    @Test
    public void testInitialize_withIOExceptionThrown() {
        String filename = TEST_FILE_PATH;
        doThrow(new RuntimeException(Constants.ErrorMessage.FAILED_TO_READ_FILE))
                .when(prefixMatcherService)
                .addPrefix(anyString());
        Exception exception = assertThrows(RuntimeException.class, () -> fileParser.initialize(filename, true));
        assertTrue(exception.getMessage().contains(Constants.ErrorMessage.FAILED_TO_READ_FILE));
    }

    @Test
    public void testInitialize_withCaseInsensitive() {
        String filename = TEST_FILE_PATH;
        fileParser.initialize(filename, false);
        // The file has 20 lines, verify that the addPrefix method was called 20 times
        verify(prefixMatcherService, times(20)).addPrefix(anyString());
    }

    @Test
    public void testInitialize_EmptyFile() throws IOException {
        String filePath = EMPTY_FILE_PATH;
        fileParser.initialize(filePath, true);

        //Verify method is not called for empty file.
        verify(prefixMatcherService, never()).addPrefix(anyString());
    }

    @Test
    public void testInitialize_FileWithEmptyLinesOrSpaces() throws IOException {
        String filePath = SPACES_FILE_PATH;
        String[] expectedPrefixes = {"Test", "Prefix", "Matcher"};
        fileParser.initialize(filePath, true);
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        //Verify method is not called for empty lines.
        verify(prefixMatcherService, times(3)).addPrefix(captor.capture());
        assertArrayEquals(expectedPrefixes, captor.getAllValues().toArray());
    }

    @Test
    public void testInitialize_FileWithSpecialCharacters() throws IOException {
        String filePath = SYMBOLS_FILE_PATH;
        String[] expectedPrefixes = {"Tes$#", "Pre&*%", "Mat@!^"};
        fileParser.initialize(filePath, true);
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        //Verify method is called for each entry in the file.
        verify(prefixMatcherService, times(3)).addPrefix(captor.capture());
        assertArrayEquals(expectedPrefixes, captor.getAllValues().toArray());
    }
}