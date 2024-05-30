import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.sequence.Sequence;
import components.sequence.Sequence1L;
import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Tests for all methods used in the Glossary class.
 */
public class GlossaryTest {

    /**
     * Construct and return a {@code Set<Character>} containing the given
     * {@code chars}s.
     *
     * @param args
     *            the {@code char}s to put in the set
     * @return {@code Set<Character>} of the given {@code char}s
     * @ensures createFromArgs = [the Set<Character> of the given chars]
     */
    private static Set<Character> createCharSetFromArgs(char... args) {
        Set<Character> set = new Set1L<Character>();
        for (char c : args) {
            set.add(c);
        }
        return set;
    }

    /**
     * Construct and return a {@code Set<String>} containing the given
     * {@code String}s.
     *
     * @param args
     *            the {@code String}s to put in the set
     * @return {@code Set<String>} of the given {@code String}s
     * @ensures createFromArgs = [the Set<String> of the given Strings]
     */
    private static Set<String> createStringSetFromArgs(String... args) {
        Set<String> set = new Set1L<String>();
        for (String s : args) {
            set.add(s);
        }
        return set;
    }

    /**
     * Construct and return a {@code Sequence<String>} containing the given
     * {@code String}s.
     *
     * @param args
     *            the {@code String}s to put in the sequence
     * @return {@code Sequence<String>} of the given {@code String}s
     * @ensures createFromArgs = [the Sequence<String> of the given Strings]
     */
    private static Sequence<String> createStringSequenceFromArgs(
            String... args) {
        Sequence<String> sequence = new Sequence1L<String>();
        int counter = 0;
        for (String s : args) {
            sequence.add(counter, s);
            counter++;
        }
        return sequence;
    }

    /**
     * Tests for initializeSequences() method.
     *
     * Breakdown of each test: reader for .txt file declared, sequences for
     * terms and definitions with expected values are initialized, sequences for
     * terms and definitions to test are declared, initializeSequences is called
     * using the reader and 2 test sequences, assertEquals is used to compare
     * the expected and test sequences for both term and definition
     */

    /**
     * Tests initializeSequences() using 1 term/definition pair, with a 1 line
     * definition, and 1 line at the end of the file (boundary/routine).
     */
    @Test
    public void initializeSequencesTest1() {
        SimpleReader in = new SimpleReader1L("data/testFile1.txt");
        Sequence<String> expectedTermSequence = createStringSequenceFromArgs(
                "one");
        Sequence<String> expectedDefinitionSequence = createStringSequenceFromArgs(
                "The first number.");
        Sequence<String> testTermSequence = new Sequence1L<String>();
        Sequence<String> testDefinitionSequence = new Sequence1L<String>();
        Glossary.initializeSequences(in, testTermSequence,
                testDefinitionSequence);

        assertEquals(expectedTermSequence, testTermSequence);
        assertEquals(expectedDefinitionSequence, testDefinitionSequence);
    }

    /**
     * Tests initializeSequences() using 2 term/definition pairs, with 2 line
     * definitions, and 2 lines at the end of the file (routine).
     */
    @Test
    public void initializeSequencesTest2() {
        SimpleReader in = new SimpleReader1L("data/testFile2.txt");
        Sequence<String> expectedTermSequence = createStringSequenceFromArgs(
                "two", "b");
        Sequence<String> expectedDefinitionSequence = createStringSequenceFromArgs(
                "The second number, equal to 1 + 1. It represents the letter b.",
                "The second letter, representing the number 2. It appears in "
                        + "\"banana\" once.");
        Sequence<String> testTermSequence = new Sequence1L<String>();
        Sequence<String> testDefinitionSequence = new Sequence1L<String>();
        Glossary.initializeSequences(in, testTermSequence,
                testDefinitionSequence);

        assertEquals(expectedTermSequence, testTermSequence);
        assertEquals(expectedDefinitionSequence, testDefinitionSequence);
    }

    /**
     * Tests initializeSequences() using 3 term/definition pairs, with 3 line
     * definitions, and 3 lines at the end of the file (sequence).
     */
    @Test
    public void initializeSequencesTest3() {
        SimpleReader in = new SimpleReader1L("data/testFile3.txt");
        Sequence<String> expectedTermSequence = createStringSequenceFromArgs(
                "three", "c", "March");
        Sequence<String> expectedDefinitionSequence = createStringSequenceFromArgs(
                "The third number, equal to 1 + 2. It represents the position "
                        + "of the month March in a year. The number three "
                        + "represents the letter c.",
                "Letter number three of the alphabet. It sounds like the word "
                        + "\"sea\". The letter c appears in \"March\" once.",
                "A month containing the letter \"c\". It is month number three "
                        + "of the year. March can also mean to walk in "
                        + "synchronization.");
        Sequence<String> testTermSequence = new Sequence1L<String>();
        Sequence<String> testDefinitionSequence = new Sequence1L<String>();
        Glossary.initializeSequences(in, testTermSequence,
                testDefinitionSequence);

        assertEquals(expectedTermSequence, testTermSequence);
        assertEquals(expectedDefinitionSequence, testDefinitionSequence);
    }

    /**
     * Tests initializeSequences() using 4 term/definition pairs, with 4 line
     * definitions, and 4 lines at the end of the file (sequence).
     */
    @Test
    public void initializeSequencesTest4() {
        SimpleReader in = new SimpleReader1L("data/testFile4.txt");
        Sequence<String> expectedTermSequence = createStringSequenceFromArgs(
                "four", "d", "April", "Wednesday");
        Sequence<String> expectedDefinitionSequence = createStringSequenceFromArgs(
                "The fourth number, equal to 2 * 2. It represents the letter "
                        + "\"d\" in the alphabet. April is month number four "
                        + "of the year. In a week, Wednesday is the fourth "
                        + "day.",
                "A letter that does not appear in the word \"April\". It also "
                        + "does not appear in the word \"May\". However, in "
                        + "the word \"Wednesday\", it appears twice. It is "
                        + "letter number four of the alphabet.",
                "A month that typically contains four instances of a "
                        + "Wednesday. April is also month number four of the "
                        + "year. This month is when Easter occurs. April does "
                        + "not contain the letter \"d\".",
                "Day number four of the week. The word \"Wednesday\" contains "
                        + "the letter d twice. Wednesday usually occurs four "
                        + "times in the month of April. Wednesday is in the "
                        + "middle of the school week.");
        Sequence<String> testTermSequence = new Sequence1L<String>();
        Sequence<String> testDefinitionSequence = new Sequence1L<String>();
        Glossary.initializeSequences(in, testTermSequence,
                testDefinitionSequence);

        assertEquals(expectedTermSequence, testTermSequence);
        assertEquals(expectedDefinitionSequence, testDefinitionSequence);
    }

    /**
     * Tests initializeSequences() using 4 term/definition pairs, with each
     * definition being a different length (challenging).
     */
    @Test
    public void initializeSequencesTest5() {
        SimpleReader in = new SimpleReader1L("data/testFile5.txt");
        Sequence<String> expectedTermSequence = createStringSequenceFromArgs(
                "five", "e", "May", "Thursday");
        Sequence<String> expectedDefinitionSequence = createStringSequenceFromArgs(
                "The fifth number, equal to 10 / 2. It represents the letter "
                        + "\"e\" in the alphabet. May is month number five of "
                        + "the year. Day number five of the week is Thursday.",
                "A letter that is at the end of the word \"five\". It is the "
                        + "most common letter of the alphabet.",
                "Out of twelve months of the year, May is number five. May "
                        + "usually has a Thursday 4 times. The letter \"e\" is "
                        + "not present in May.",
                "Day number five, usually appearing in May 4 times.");
        Sequence<String> testTermSequence = new Sequence1L<String>();
        Sequence<String> testDefinitionSequence = new Sequence1L<String>();
        Glossary.initializeSequences(in, testTermSequence,
                testDefinitionSequence);

        assertEquals(expectedTermSequence, testTermSequence);
        assertEquals(expectedDefinitionSequence, testDefinitionSequence);
    }

    /**
     * Tests for sortSequences() method.
     *
     * Breakdown of each method: reader declared for .txt file, expected
     * sequences are initialized for term and definition, test sequences are
     * declared and initialized based on the .txt file using
     * initializeSequences, test sequences are sorted using sortSequences(),
     * assertEquals is used to check if the expected and test sequences match
     * for both term and definition
     */

    /**
     * Tests sortSequences() using 1 term/definition pair, a 1 line definition,
     * and 1 blank line at the end of the file (boundary/routine).
     */
    @Test
    public void sortSequencesTest1() {
        SimpleReader in = new SimpleReader1L("data/testFile1.txt");
        Sequence<String> expectedTermSequence = createStringSequenceFromArgs(
                "one");
        Sequence<String> expectedDefinitionSequence = createStringSequenceFromArgs(
                "The first number.");
        Sequence<String> testTermSequence = new Sequence1L<String>();
        Sequence<String> testDefinitionSequence = new Sequence1L<String>();
        Glossary.initializeSequences(in, testTermSequence,
                testDefinitionSequence);
        Glossary.sortSequences(testTermSequence, testDefinitionSequence);
        assertEquals(expectedTermSequence, testTermSequence);
        assertEquals(expectedDefinitionSequence, testDefinitionSequence);
    }

    /**
     * Tests sortSequences() using 2 term/definition pairs, 2 line definitions,
     * and 2 blank lines at the end of the file (routine).
     */
    @Test
    public void sortSequencesTest2() {
        SimpleReader in = new SimpleReader1L("data/testFile2.txt");
        Sequence<String> expectedTermSequence = createStringSequenceFromArgs(
                "b", "two");
        Sequence<String> expectedDefinitionSequence = createStringSequenceFromArgs(
                "The second letter, representing the number 2. It appears in "
                        + "\"banana\" once.",
                "The second number, equal to 1 + 1. It represents the letter "
                        + "b.");
        Sequence<String> testTermSequence = new Sequence1L<String>();
        Sequence<String> testDefinitionSequence = new Sequence1L<String>();
        Glossary.initializeSequences(in, testTermSequence,
                testDefinitionSequence);
        Glossary.sortSequences(testTermSequence, testDefinitionSequence);
        assertEquals(expectedTermSequence, testTermSequence);
        assertEquals(expectedDefinitionSequence, testDefinitionSequence);
    }

    /**
     * Tests sortSequences() using 3 term/definition pairs, 3 line definitions,
     * and 3 blank lines at the end of the file (routine).
     */
    @Test
    public void sortSequencesTest3() {
        SimpleReader in = new SimpleReader1L("data/testFile3.txt");
        Sequence<String> expectedTermSequence = createStringSequenceFromArgs(
                "c", "March", "three");
        Sequence<String> expectedDefinitionSequence = createStringSequenceFromArgs(
                "Letter number three of the alphabet. It sounds like the word "
                        + "\"sea\". The letter c appears in \"March\" once.",
                "A month containing the letter \"c\". It is month number three "
                        + "of the year. March can also mean to walk in "
                        + "synchronization.",
                "The third number, equal to 1 + 2. It represents the position "
                        + "of the month March in a year. The number three "
                        + "represents the letter c.");
        Sequence<String> testTermSequence = new Sequence1L<String>();
        Sequence<String> testDefinitionSequence = new Sequence1L<String>();
        Glossary.initializeSequences(in, testTermSequence,
                testDefinitionSequence);
        Glossary.sortSequences(testTermSequence, testDefinitionSequence);
        assertEquals(expectedTermSequence, testTermSequence);
        assertEquals(expectedDefinitionSequence, testDefinitionSequence);
    }

    /**
     * Tests sortSequences() using 4 term/definition pairs, 4 line definitions,
     * and 4 blank lines at the end of the file (routine).
     */
    @Test
    public void sortSequencesTest4() {
        SimpleReader in = new SimpleReader1L("data/testFile4.txt");
        Sequence<String> expectedTermSequence = createStringSequenceFromArgs(
                "April", "d", "four", "Wednesday");
        Sequence<String> expectedDefinitionSequence = createStringSequenceFromArgs(
                "A month that typically contains four instances of a "
                        + "Wednesday. April is also month number four of the "
                        + "year. This month is when Easter occurs. April does "
                        + "not contain the letter \"d\".",
                "A letter that does not appear in the word \"April\". It also "
                        + "does not appear in the word \"May\". However, in "
                        + "the word \"Wednesday\", it appears twice. It is "
                        + "letter number four of the alphabet.",
                "The fourth number, equal to 2 * 2. It represents the letter "
                        + "\"d\" in the alphabet. April is month number four "
                        + "of the year. In a week, Wednesday is the fourth "
                        + "day.",
                "Day number four of the week. The word \"Wednesday\" contains "
                        + "the letter d twice. Wednesday usually occurs four "
                        + "times in the month of April. Wednesday is in the "
                        + "middle of the school week.");
        Sequence<String> testTermSequence = new Sequence1L<String>();
        Sequence<String> testDefinitionSequence = new Sequence1L<String>();
        Glossary.initializeSequences(in, testTermSequence,
                testDefinitionSequence);
        Glossary.sortSequences(testTermSequence, testDefinitionSequence);
        assertEquals(expectedTermSequence, testTermSequence);
        assertEquals(expectedDefinitionSequence, testDefinitionSequence);
    }

    /**
     * Tests sortSequences() using 4 term/definition pairs with varying
     * definitions lengths. Most importantly, each term begins with the same
     * letter (challenging).
     */
    @Test
    public void sortSequencesTest5() {
        SimpleReader in = new SimpleReader1L("data/testFile6.txt");
        Sequence<String> expectedTermSequence = createStringSequenceFromArgs(
                "Peter", "pick", "pickle", "pipe");
        Sequence<String> expectedDefinitionSequence = createStringSequenceFromArgs(
                "The greatest Asian in CSE. Peter enjoys ping-pong, Clash "
                        + "Royale, and math. He is fluent in Chinese, Java, "
                        + "C++, and Python.",
                "Can be denoted as choosing between a few choices. Example: "
                        + "Peter wanted to pick CSE as his major. Also can be "
                        + "used to denote a form of extraction. Example: Peter "
                        + "likes to pick his nose using a pipe.",
                "A vegetable (or fruit?) that tastes sour and salty.",
                "A hollow tube. A pipe can be used to transfer water, or for "
                        + "Peter to drink bubble tea.");
        Sequence<String> testTermSequence = new Sequence1L<String>();
        Sequence<String> testDefinitionSequence = new Sequence1L<String>();
        Glossary.initializeSequences(in, testTermSequence,
                testDefinitionSequence);
        Glossary.sortSequences(testTermSequence, testDefinitionSequence);
        assertEquals(expectedTermSequence, testTermSequence);
        assertEquals(expectedDefinitionSequence, testDefinitionSequence);
    }

    /**
     * Tests for generateElements()
     *
     * Breakdown of each test: set containing expected characters is
     * initialized, test string to make the test set is initialized, test set is
     * declared, generateElements is declared using the test string and test
     * set, the new test set, which should contain all characters from the
     * string without repeats, is compared to the expected set using
     * assertEquals.
     */

    /**
     * Tests generateElements() for a string containing characters that could be
     * seen as separators (routine).
     */
    @Test
    public void generateElementsTest1() {
        Set<Character> expectedSet = createCharSetFromArgs(' ', '\t', ',', '~',
                '_', '.', '/', '\\', ';', '"');
        String testString = " \t, ~_./\\;\"";
        Set<Character> testSet = new Set1L<Character>();
        Glossary.generateElements(testString, testSet);
        assertEquals(expectedSet, testSet);
    }

    /**
     * Tests generateElements() for a string containing letters and a non-letter
     * symbol at the end (routine).
     */
    @Test
    public void generateElementsTest2() {
        Set<Character> expectedSet = createCharSetFromArgs('T', 'h', 'e', ' ',
                's', 'c', 'o', 'n', 'd', 'l', 't', 'r', '.');
        String testString = "The second letter.";
        Set<Character> testSet = new Set1L<Character>();
        Glossary.generateElements(testString, testSet);
        assertEquals(expectedSet, testSet);
    }

    /**
     * Tests generateElements() for a string containing letters, punctuation
     * symbols, numbers, and operators (routine).
     */
    @Test
    public void generateElementsTest3() {
        Set<Character> expectedSet = createCharSetFromArgs('T', 'h', 'e', ' ',
                't', 'i', 'r', 'd', 'n', 'u', 'm', 'b', ',', 'q', 'a', 'l', 'o',
                '1', '+', '2', '.');
        String testString = "The third number, equal to 1 + 2.";
        Set<Character> testSet = new Set1L<Character>();
        Glossary.generateElements(testString, testSet);
        assertEquals(expectedSet, testSet);
    }

    /**
     * Tests generateElements() for a string with capital letters, quotes, and
     * punctuation (routine).
     */
    @Test
    public void generateElementsTest4() {
        Set<Character> expectedSet = createCharSetFromArgs('A', 'p', 'r', 'i',
                'l', ' ', 'd', 'o', 'e', 's', 'n', 't', 'c', 'a', 'h', '"',
                '.');
        String testString = "April does not contain the letter \"d\".";
        Set<Character> testSet = new Set1L<Character>();
        Glossary.generateElements(testString, testSet);
        assertEquals(expectedSet, testSet);
    }

    /**
     * Tests generateElements() for a string with only 2 different characters
     * (challenging).
     */
    @Test
    public void generateElementsTest5() {
        Set<Character> expectedSet = createCharSetFromArgs('Y', 'o');
        String testString = "Yoooooooooooooooooooooooooooooooooooo";
        Set<Character> testSet = new Set1L<Character>();
        Glossary.generateElements(testString, testSet);
        assertEquals(expectedSet, testSet);
    }

    /**
     * Tests generateElements() for a string of nothing (boundary).
     */
    @Test
    public void generateElementsTest6() {
        Set<Character> expectedSet = createCharSetFromArgs();
        String testString = "";
        Set<Character> testSet = new Set1L<Character>();
        Glossary.generateElements(testString, testSet);
        assertEquals(expectedSet, testSet);
    }

    /**
     * Tests for nextWordOrSeparator()
     *
     * Breakdown of each method: string with separators is declared, set is
     * created, separators are added to set using generateElements(), string to
     * test nextWordOrSeparator on is initialized, expected string after method
     * call is initialized, index of the beginning character of the expected
     * string within the test string is initialized, nextWordOrSeparator is run
     * on the test string at the given index, assertEquals is used to check if
     * the expected and test strings match.
     */

    /**
     * Tests nextWordOrSeparator at the beginning of a simple sentence
     * (routine).
     */
    @Test
    public void nextWordOrSeparatorTest1() {
        String separatorString = " \t, ~_./\\;\"";
        Set<Character> separatorSet = new Set1L<Character>();
        Glossary.generateElements(separatorString, separatorSet);

        String initialString = "The first number.";
        String expectedString = "The";
        int position = 0;

        String testString = Glossary.nextWordOrSeparator(initialString,
                position, separatorSet);
        assertEquals(expectedString, testString);
    }

    /**
     * Tests nextWordOrSeparator to get the first space of a sentence (routine).
     */
    @Test
    public void nextWordOrSeparatorTest2() {
        String separatorString = " \t, ~_./\\;\"";
        Set<Character> separatorSet = new Set1L<Character>();
        Glossary.generateElements(separatorString, separatorSet);

        String initialString = "The second number, equal to 1 + 1. ";
        String expectedString = " ";
        final int position = 3;

        String testString = Glossary.nextWordOrSeparator(initialString,
                position, separatorSet);
        assertEquals(expectedString, testString);
    }

    /**
     * Tests nextWordOrSeparator to get the longest word in a sentence, near the
     * end (routine).
     */
    @Test
    public void nextWordOrSeparatorTest3() {
        String separatorString = " \t, ~_./\\;\"";
        Set<Character> separatorSet = new Set1L<Character>();
        Glossary.generateElements(separatorString, separatorSet);

        String initialString = "March can also mean to walk in synchronization.";
        String expectedString = "synchronization";
        final int position = 31;

        String testString = Glossary.nextWordOrSeparator(initialString,
                position, separatorSet);
        assertEquals(expectedString, testString);
    }

    /**
     * Tests nextWordOrSeparator to get the portion of a sentence that contains
     * a closing quote, comma, and space as a separator (routine).
     */
    @Test
    public void nextWordOrSeparatorTest4() {
        String separatorString = " \t, ~_./\\;\"";
        Set<Character> separatorSet = new Set1L<Character>();
        Glossary.generateElements(separatorString, separatorSet);

        String initialString = "However, in the word \"Wednesday\", it appears twice. ";
        String expectedString = "\", ";
        final int position = 31;

        String testString = Glossary.nextWordOrSeparator(initialString,
                position, separatorSet);
        assertEquals(expectedString, testString);
    }

    /**
     * Tests nextWordOrSeparator to get the remaining portion of a word when it
     * already is at an index halfway through it (challenging).
     */
    @Test
    public void nextWordOrSeparatorTest5() {
        String separatorString = " \t, ~_./\\;\"";
        Set<Character> separatorSet = new Set1L<Character>();
        Glossary.generateElements(separatorString, separatorSet);

        String initialString = "nextWordOrSeparatorTest5 will get half of a string";
        String expectedString = "SeparatorTest5";
        final int position = 10;

        String testString = Glossary.nextWordOrSeparator(initialString,
                position, separatorSet);
        assertEquals(expectedString, testString);
    }

    /**
     * Tests nextWordOrSeparator to see if a the next word or separator of a
     * single space is a single space (boundary).
     */
    @Test
    public void nextWordOrSeparatorTest6() {
        String separatorString = " \t, ~_./\\;\"";
        Set<Character> separatorSet = new Set1L<Character>();
        Glossary.generateElements(separatorString, separatorSet);

        String initialString = " ";
        String expectedString = " ";
        final int position = 0;

        String testString = Glossary.nextWordOrSeparator(initialString,
                position, separatorSet);
        assertEquals(expectedString, testString);
    }

    /**
     * Tests for makeWordOrSeparatorSequence()
     *
     * Breakdown of each test case: initialize string to make into separator,
     * declare separator, add characters from separatorString into set using
     * generateElements, Initialize text to break into words and separators,
     * declare sequence of expected words and sequences, declare test sequence
     * and call makeWordOrSeparatorSequence to make it equal to the words and
     * separators from the string, compare expected and test sequences using
     * assertEquals.
     */

    /**
     * Tests makeWordOrSeparatorSequence for a simple, short sentence (boundary,
     * routine).
     */
    @Test
    public void makeWordOrSeparatorSequenceTest1() {
        String separatorString = " \t, ~_./\\;\"";
        Set<Character> separatorSet = new Set1L<Character>();
        Glossary.generateElements(separatorString, separatorSet);

        String text = "The first number.";
        Sequence<String> expectedSequence = createStringSequenceFromArgs("The",
                " ", "first", " ", "number", ".");

        Sequence<String> testSequence = Glossary
                .makeWordOrSeparatorSequence(text, separatorSet);
        assertEquals(expectedSequence, testSequence);
    }

    /**
     * Tests makeWordOrSeparatorSequence for a sentence that includes quotation
     * marks (routine).
     */
    @Test
    public void makeWordOrSeparatorSequenceTest2() {
        String separatorString = " \t, ~_./\\;\"";
        Set<Character> separatorSet = new Set1L<Character>();
        Glossary.generateElements(separatorString, separatorSet);

        String text = "It appears in \"banana\" once.";
        Sequence<String> expectedSequence = createStringSequenceFromArgs("It",
                " ", "appears", " ", "in", " \"", "banana", "\" ", "once", ".");

        Sequence<String> testSequence = Glossary
                .makeWordOrSeparatorSequence(text, separatorSet);
        assertEquals(expectedSequence, testSequence);
    }

    /**
     * Tests makeWordOrSeparatorSequence for a sentence that includes numbers
     * and operators (routine).
     */
    @Test
    public void makeWordOrSeparatorSequenceTest3() {
        String separatorString = " \t, ~_./\\;\"";
        Set<Character> separatorSet = new Set1L<Character>();
        Glossary.generateElements(separatorString, separatorSet);

        String text = "The third number, equal to 1 + 2.";
        Sequence<String> expectedSequence = createStringSequenceFromArgs("The",
                " ", "third", " ", "number", ", ", "equal", " ", "to", " ", "1",
                " ", "+", " ", "2", ".");

        Sequence<String> testSequence = Glossary
                .makeWordOrSeparatorSequence(text, separatorSet);
        assertEquals(expectedSequence, testSequence);
    }

    /**
     * Tests makeWordOrSeparatorSequence for a sentence that includes quotation
     * marks right before a period (routine).
     */
    @Test
    public void makeWordOrSeparatorSequenceTest4() {
        String separatorString = " \t, ~_./\\;\"";
        Set<Character> separatorSet = new Set1L<Character>();
        Glossary.generateElements(separatorString, separatorSet);

        String text = "April does not contain the letter \"d\".";
        Sequence<String> expectedSequence = createStringSequenceFromArgs(
                "April", " ", "does", " ", "not", " ", "contain", " ", "the",
                " ", "letter", " \"", "d", "\".");

        Sequence<String> testSequence = Glossary
                .makeWordOrSeparatorSequence(text, separatorSet);
        assertEquals(expectedSequence, testSequence);
    }

    /**
     * Tests makeWordOrSeparatorSequence for a sentence that only has 1 chunk of
     * words and 1 chunk of separators (challenging).
     */
    @Test
    public void makeWordOrSeparatorSequenceTest5() {
        String separatorString = " \t, ~_./\\;\"";
        Set<Character> separatorSet = new Set1L<Character>();
        Glossary.generateElements(separatorString, separatorSet);

        String text = "ThereIs1ChunkOfWordsAnd1ChunkOfSeparators\t, ~_./\\;\"";
        Sequence<String> expectedSequence = createStringSequenceFromArgs(
                "ThereIs1ChunkOfWordsAnd1ChunkOfSeparators", "\t, ~_./\\;\"");

        Sequence<String> testSequence = Glossary
                .makeWordOrSeparatorSequence(text, separatorSet);
        assertEquals(expectedSequence, testSequence);
    }

    /**
     * Tests for printNextDefinitionFragment()
     *
     * Breakdown of each test: declare writer for test file, declare readers for
     * expected and test .txt files, declare string to be tested in method,
     * declare set of other terms, call nprintNextDefinitionFragment, taking
     * into account whether the string is a term in the set, use assertEquals to
     * compare the first and only line of the expected and test .txt files,
     * close readers and writers.
     */

    /**
     * Tests printNextDefinitionFragment for the word "first" when there are no
     * other terms in the glossary (routine).
     */
    @Test
    public void printNextDefinitionFragmentTest1() {
        SimpleWriter out = new SimpleWriter1L("data/testFragment1.txt");
        SimpleReader inTest = new SimpleReader1L("data/testFragment1.txt");
        SimpleReader inExpected = new SimpleReader1L(
                "data/expectedFragment1.txt");
        String instance = "first";
        Set<String> otherTerms = createStringSetFromArgs();
        Glossary.printNextDefinitionFragment(out, instance,
                otherTerms.contains(instance));
        assertEquals(inExpected.nextLine(), inTest.nextLine());
        out.close();
        inTest.close();
        inExpected.close();
    }

    /**
     * Tests printNextDefinitionFragment for the word "b" when "b" is also
     * another term in the glossary (routine).
     */
    @Test
    public void printNextDefinitionFragmentTest2() {
        SimpleWriter out = new SimpleWriter1L("data/testFragment2.txt");
        SimpleReader inTest = new SimpleReader1L("data/testFragment2.txt");
        SimpleReader inExpected = new SimpleReader1L(
                "data/expectedFragment2.txt");
        String instance = "b";
        Set<String> otherTerms = createStringSetFromArgs("b");
        Glossary.printNextDefinitionFragment(out, instance,
                otherTerms.contains(instance));
        assertEquals(inExpected.nextLine(), inTest.nextLine());
        out.close();
        inTest.close();
        inExpected.close();
    }

    /**
     * Tests printNextDefinitionFragment for the word "sea" with the other terms
     * being "three" and "March", neither of which is "sea" (routine).
     */
    @Test
    public void printNextDefinitionFragmentTest3() {
        SimpleWriter out = new SimpleWriter1L("data/testFragment3.txt");
        SimpleReader inTest = new SimpleReader1L("data/testFragment3.txt");
        SimpleReader inExpected = new SimpleReader1L(
                "data/expectedFragment3.txt");
        String instance = "sea";
        Set<String> otherTerms = createStringSetFromArgs("three", "March");
        Glossary.printNextDefinitionFragment(out, instance,
                otherTerms.contains(instance));
        assertEquals(inExpected.nextLine(), inTest.nextLine());
        out.close();
        inTest.close();
        inExpected.close();
    }

    /**
     * Tests printNextDefinitionFragment for the word "April" when it is another
     * term in the glossary (routine).
     */
    @Test
    public void printNextDefinitionFragmentTest4() {
        SimpleWriter out = new SimpleWriter1L("data/testFragment4.txt");
        SimpleReader inTest = new SimpleReader1L("data/testFragment4.txt");
        SimpleReader inExpected = new SimpleReader1L(
                "data/expectedFragment4.txt");
        String instance = "April";
        Set<String> otherTerms = createStringSetFromArgs("four", "d", "April");
        Glossary.printNextDefinitionFragment(out, instance,
                otherTerms.contains(instance));
        assertEquals(inExpected.nextLine(), inTest.nextLine());
        out.close();
        inTest.close();
        inExpected.close();
    }

    /**
     * Tests printNextDefinitionFragment for the "an" when it is a substring of
     * another term, but not exactly the same (challenging).
     */
    @Test
    public void printNextDefinitionFragmentTest5() {
        SimpleWriter out = new SimpleWriter1L("data/testFragment5.txt");
        SimpleReader inTest = new SimpleReader1L("data/testFragment5.txt");
        SimpleReader inExpected = new SimpleReader1L(
                "data/expectedFragment5.txt");
        String instance = "an";
        Set<String> otherTerms = createStringSetFromArgs("bands", "anteater",
                "plan");
        Glossary.printNextDefinitionFragment(out, instance,
                otherTerms.contains(instance));
        assertEquals(inExpected.nextLine(), inTest.nextLine());
        out.close();
        inTest.close();
        inExpected.close();
    }

}
