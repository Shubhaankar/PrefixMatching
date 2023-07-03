# PrefixMatching

This project provides a Java-based solution for efficiently finding the longest matching prefix for a given input string from a set of prefixes.
The implementation is optimized for speed and can handle large volumes of data, making it suitable for a variety of applications, from autocomplete suggestions to URL routing.

## Features

- Efficient prefix matching using a custom implementation of a Trie data structure.
- Case-sensitive and case-insensitive matching options.
- Streamlined file parsing for adding prefixes to the Trie from a text file.
- Simple, intuitive API for adding prefixes and finding matches.
- Detailed logging to track the program's progress.

## How it works

The PrefixMatching program uses a Trie data structure for efficient prefix matching. When the program starts, it reads a file containing the set of prefixes and adds them to the Trie. Each prefix is stored as a path from the root to a node in the Trie.

When the user inputs a string, the program traverses the Trie to find the longest path from the root that matches the prefix of the input string. The matched prefix is then returned to the user.

The program also allows the user to choose between case-sensitive and case-insensitive matching. In case-insensitive mode, the program normalizes the input strings and the prefixes by converting them to lowercase before adding them to the Trie and performing matches.

## Setup and Usage

You will need Java 17 and Maven to build and run this program.

1. Open the project on your local machine.
2. Navigate to the project directory and build the project with Maven: `mvn clean install`.
3. Run the program with the command: `java -jar target/PrefixMatching-0.0.1-SNAPSHOT.jar prefix-file`.
4. The `prefix-file` in above command is the input file containing the set of prefixes when prompted. The file should contain one prefix per line.
5. Next, the program will ask whether you want to perform case-sensitive or case-insensitive matching. Enter `yes` for case-sensitive matching or `no` for case-insensitive matching.
6. The program is now ready to find matching prefixes. Enter a string and the program will return the longest matching prefix.
7. `quit()` can be used to terminate the program.

## Example

Given an input file prefixes.txt containing the following lines:
```
tbBJSoT6
98nNtr1
X6jrII
38ybPMIf
98nNtqL
jhHauc
vbIATbv
```

Run the program:
`java -jar target/PrefixMatching-0.0.1-SNAPSHOT.jar prefix-file`

```text
Do you want case-sensitive behavior? (yes/no): 
Type quit() to exit the prompt
yes
Enter prefix string:
98
Prefix not found
Enter prefix string:
98nNtqL
Prefix found: 98nNtqL
Enter prefix string:
98nNtqLTrail
Prefix found: 98nNtqL
Enter prefix string:
quit
Prefix not found
Enter prefix string:
quit()
```

## Tests

Project utilizes unit tests to ensure the integrity and correctness of the code. Here's how you can run them:

### Running the Tests

To run the tests, navigate to the root directory of the project and execute the following command:

```
mvn test
```

### Testing Strategy

Combination of unit and integration tests is used to validate the code base. Unit tests are used to verify the correctness of small isolated parts of the code. On the other hand, integration tests allow to ensure that various components of the application work correctly together.

### Test Cases

Here are some examples of the test cases that are implemented:

- **testLongestMatchingPrefix_stringFound**: This test validates that the prefix matcher correctly identifies the longest matching prefix in a given string.
- **testCaseSensitivity**: This test checks the case sensitivity functionality of the prefix matcher.

Below is the list of few other test cases:
```text
testInitialize_withValidFile,
testInitialize_withInvalidFile,
testInitialize_withIOExceptionThrown,
testInitialize_withCaseInsensitive,
testInitialize_EmptyFile,
testInitialize_FileWithEmptyLinesOrSpaces,
testInitialize_FileWithSpecialCharacters,
```

### Expected Outcomes

For testLongestMatchingPrefix_stringFound, if the prefix matcher is given a string "input", and the prefix list contains "int", "input", "inp", the expected outcome would be "input" as it is the longest matching prefix.

For testCaseSensitivity, if the case sensitivity is set to true and the prefix matcher is given a string "Input", it should not match the prefix "input".

### Troubleshooting

If you encounter any issues while running the tests, ensure that you have the correct version of Maven installed and that you're in the root directory of the project. If issues persist, try cleaning the project with `mvn clean` and then re-run the tests.


# Future Work

## Radix Tree Implementation

In the current implementation, I used a Trie (Prefix Tree) for matching the prefixes. While this is efficient, I can further improve the performance by implementing a Radix Tree (or Patricia Tree), a space-optimized version of a Trie.

In a Radix Tree, every node with only one child is merged with its parent, which significantly reduces the space required for storage and can potentially speed up the search operation.

I plan to explore this as part of future work to make our prefix-matching algorithm more efficient.

## Contributing

Contributions are welcome! Please reachout with suggestions.

Thank you for your interest in PrefixMatching!



