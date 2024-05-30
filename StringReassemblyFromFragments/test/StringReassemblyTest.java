import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 *
 */
public class StringReassemblyTest {

    /**
     * Construct and return a {@code Set<String>} containing the given
     * {@code String}s.
     *
     * @param args
     *            the {@code String}s to put in the set
     * @return {@code Set<String>} of the given {@code String}s
     * @ensures createFromArgs = [the Set<String> of the given Strings]
     */
    private static Set<String> createFromArgs(String... args) {
        Set<String> set = new Set1L<String>();
        for (String s : args) {
            set.add(s);
        }
        return set;
    }

    /**
     * Tests for overlap method
     */

    /*
     * Description of code for each overlap test:
     *
     * Declare strings, gets overlap using function, declare constant for
     * expected overlap, check if strings remain the same and overlap = expected
     * overlap
     */

    /**
     * Tests overlap for "noble" and "blend" (routine - 5 letter words).
     */
    @Test
    public void testOverlap1() {
        String s1 = "noble";
        String s2 = "blend";
        int overlap = StringReassembly.overlap(s1, s2);
        final int expectedOverlap = 3;

        assertEquals("noble", s1);
        assertEquals("blend", s2);
        assertEquals(expectedOverlap, overlap);
    }

    /**
     * Tests overlap for "throne" and "neatly" (routine - 6 letter words).
     */
    @Test
    public void testOverlap2() {
        String s1 = "throne";
        String s2 = "neatly";
        int overlap = StringReassembly.overlap(s1, s2);

        assertEquals("throne", s1);
        assertEquals("neatly", s2);
        assertEquals(2, overlap);
    }

    /**
     * Tests overlap for "bowling" and "lingers" (routine - 7 letter words).
     */
    @Test
    public void testOverlap3() {
        String s1 = "bowling";
        String s2 = "lingers";
        int overlap = StringReassembly.overlap(s1, s2);
        final int expectedOverlap = 4;

        assertEquals("bowling", s1);
        assertEquals("lingers", s2);
        assertEquals(expectedOverlap, overlap);
    }

    /**
     * Tests overlap for "advanced" and "dreaming" (routine - 8 letter words).
     */
    @Test
    public void testOverlap4() {
        String s1 = "advanced";
        String s2 = "dreaming";
        int overlap = StringReassembly.overlap(s1, s2);

        assertEquals("advanced", s1);
        assertEquals("dreaming", s2);
        assertEquals(1, overlap);
    }

    /**
     * Tests overlap for "no" and "on" (boundary - 2 letter words).
     */
    @Test
    public void testOverlap5() {
        String s1 = "no";
        String s2 = "on";
        int overlap = StringReassembly.overlap(s1, s2);

        assertEquals("no", s1);
        assertEquals("on", s2);
        assertEquals(1, overlap);
    }

    /**
     * Tests overlap for "Sirichoktanasup" and
     * "supercalifragilisticexpialidocious" (boundary - long words).
     */
    @Test
    public void testOverlap6() {
        String s1 = "Sirichoktanasup";
        String s2 = "supercalifragilisticexpialidocious";
        int overlap = StringReassembly.overlap(s1, s2);
        final int expectedOverlap = 3;

        assertEquals("Sirichoktanasup", s1);
        assertEquals("supercalifragilisticexpialidocious", s2);
        assertEquals(expectedOverlap, overlap);
    }

    /**
     * Tests overlap for "rectangle" and "incorrect" (challenging - wrong
     * order).
     */
    @Test
    public void testOverlap7() {
        String s1 = "rectangle";
        String s2 = "incorrect";
        int overlap = StringReassembly.overlap(s1, s2);

        assertEquals("rectangle", s1);
        assertEquals("incorrect", s2);
        assertEquals(0, overlap);
    }

    /**
     * Tests overlap for "Ohio State" and "State University" (challenging -
     * words with spaces).
     */
    @Test
    public void testOverlap8() {
        String s1 = "Ohio State";
        String s2 = "State University";
        int overlap = StringReassembly.overlap(s1, s2);
        final int expectedOverlap = 5;

        assertEquals("Ohio State", s1);
        assertEquals("State University", s2);
        assertEquals(expectedOverlap, overlap);
    }

    /**
     * Tests for combination method
     */

    /*
     * Description of code for each combination test:
     *
     * Declare strings to compare, get overlap using overlap method, declare
     * constant for expected overlap, Set string equal to the return value of
     * the combination method, assert if all input parameters remain the same
     * after method call and resulting combination string is correct
     */

    /**
     * Tests combination for "olden" and "dents" (routine - 5 letter words).
     */
    @Test
    public void testCombination1() {
        String s1 = "olden";
        String s2 = "dents";
        int overlap = StringReassembly.overlap(s1, s2);
        final int expectedOverlap = 3;
        String combination = StringReassembly.combination(s1, s2, overlap);

        assertEquals("olden", s1);
        assertEquals("dents", s2);
        assertEquals(expectedOverlap, overlap);
        assertEquals("oldents", combination);
    }

    /**
     * Tests combination for "France" and "cellar" (routine - 6 letter words).
     */
    @Test
    public void testCombination2() {
        String s1 = "France";
        String s2 = "cellar";
        int overlap = StringReassembly.overlap(s1, s2);
        String combination = StringReassembly.combination(s1, s2, overlap);

        assertEquals("France", s1);
        assertEquals("cellar", s2);
        assertEquals(2, overlap);
        assertEquals("Francellar", combination);
    }

    /**
     * Tests combination for "creeper" and "reverse" (routine - 7 letter words).
     */
    @Test
    public void testCombination3() {
        String s1 = "creeper";
        String s2 = "reverse";
        int overlap = StringReassembly.overlap(s1, s2);
        String combination = StringReassembly.combination(s1, s2, overlap);

        assertEquals("creeper", s1);
        assertEquals("reverse", s2);
        assertEquals(1, overlap);
        assertEquals("creepereverse", combination);
    }

    /**
     * Tests combination for "reusable" and "blending" (routine - 8 letter
     * words).
     */
    @Test
    public void testCombination4() {
        String s1 = "reusable";
        String s2 = "blending";
        int overlap = StringReassembly.overlap(s1, s2);
        final int expectedOverlap = 3;
        String combination = StringReassembly.combination(s1, s2, overlap);

        assertEquals("reusable", s1);
        assertEquals("blending", s2);
        assertEquals(expectedOverlap, overlap);
        assertEquals("reusablending", combination);
    }

    /**
     * Tests combination for "pi" and "in" (boundary - 2 letter words).
     */
    @Test
    public void testCombination5() {
        String s1 = "pi";
        String s2 = "in";
        int overlap = StringReassembly.overlap(s1, s2);
        String combination = StringReassembly.combination(s1, s2, overlap);

        assertEquals("pi", s1);
        assertEquals("in", s2);
        assertEquals(1, overlap);
        assertEquals("pin", combination);
    }

    /**
     * Tests combination for "It's been an honor" and
     * "honorificabilitudinitatibus" (boundary - long words/statements).
     */
    @Test
    public void testCombination6() {
        String s1 = "It's been an honor";
        String s2 = "honorificabilitudinitatibus";
        int overlap = StringReassembly.overlap(s1, s2);
        final int expectedOverlap = 5;
        String combination = StringReassembly.combination(s1, s2, overlap);

        assertEquals("It's been an honor", s1);
        assertEquals("honorificabilitudinitatibus", s2);
        assertEquals(expectedOverlap, overlap);
        assertEquals("It's been an honorificabilitudinitatibus", combination);
    }

    /**
     * Tests combination for "education" and "failed" (challenging - wrong
     * order).
     */
    @Test
    public void testCombination7() {
        String s1 = "education";
        String s2 = "failed";
        int overlap = StringReassembly.overlap(s1, s2);
        String combination = StringReassembly.combination(s1, s2, overlap);

        assertEquals("education", s1);
        assertEquals("failed", s2);
        assertEquals(0, overlap);
        assertEquals("educationfailed", combination);
    }

    /**
     * Tests combination for "Software I totally" and "totally isn't hard..."
     * (challenging - spaces in statements).
     */
    @Test
    public void testCombination8() {
        String s1 = "Software I totally";
        String s2 = "totally isn't hard...";
        int overlap = StringReassembly.overlap(s1, s2);
        final int expectedOverlap = 7;
        String combination = StringReassembly.combination(s1, s2, overlap);

        assertEquals("Software I totally", s1);
        assertEquals("totally isn't hard...", s2);
        assertEquals(expectedOverlap, overlap);
        assertEquals("Software I totally isn't hard...", combination);
    }

    /**
     * Tests for addToSetAvoidingSubstrings method
     */

    /*
     * Description of code for each addToSetAvoidingSubstrings test:
     *
     * Declare test set and add values, declare expected set and add expected
     * values after method call, declare string to potentially add to testSet
     * via the method, call method with test set and string, check if test set
     * matches expected set and the string entered in the method remains the
     * same
     */

    /**
     * Tests testSet to see if 'four' will be added and no strings removed
     * (routine).
     */
    @Test
    public void addToSetAvoidingSubstring1() {
        Set<String> testSet = createFromArgs("one", "two", "three");
        Set<String> expectedSet = createFromArgs("one", "two", "three", "four");

        String s = "four";

        StringReassembly.addToSetAvoidingSubstrings(testSet, s);
        assertEquals(s, "four");
        assertEquals(expectedSet, testSet);
    }

    /**
     * Tests testSet to see to make sure 'three' won't be added since it is a
     * substring of 'three' (routine).
     */
    @Test
    public void addToSetAvoidingSubstring2() {
        Set<String> testSet = createFromArgs("one", "two", "three");
        Set<String> expectedSet = createFromArgs("one", "two", "three");

        String s = "three";

        StringReassembly.addToSetAvoidingSubstrings(testSet, s);
        assertEquals(s, "three");
        assertEquals(expectedSet, testSet);
    }

    /**
     * Tests testSet to see to make sure 'bones' is added and replaces 'one'
     * because 'one' is a substring of 'bones' (routine).
     */
    @Test
    public void addToSetAvoidingSubstring3() {
        Set<String> testSet = createFromArgs("one", "two", "three");
        Set<String> expectedSet = createFromArgs("bones", "two", "three");

        String s = "bones";

        StringReassembly.addToSetAvoidingSubstrings(testSet, s);
        assertEquals(s, "bones");
        assertEquals(expectedSet, testSet);
    }

    /**
     * Tests testSet to see if 'west' will be added and no strings removed
     * (routine).
     */
    @Test
    public void addToSetAvoidingSubstring4() {
        Set<String> testSet = createFromArgs("north", "south", "east");
        Set<String> expectedSet = createFromArgs("north", "south", "east",
                "west");

        String s = "west";

        StringReassembly.addToSetAvoidingSubstrings(testSet, s);
        assertEquals(s, "west");
        assertEquals(expectedSet, testSet);
    }

    /**
     * Tests testSet to see to make sure 'out' won't be added since it is a
     * substring of 'south' (routine).
     */
    @Test
    public void addToSetAvoidingSubstring5() {
        Set<String> testSet = createFromArgs("north", "south", "east");

        Set<String> expectedSet = createFromArgs("north", "south", "east");

        String s = "out";

        StringReassembly.addToSetAvoidingSubstrings(testSet, s);
        assertEquals(s, "out");
        assertEquals(expectedSet, testSet);
    }

    /**
     * Tests testSet to see to make sure 'feasting' is added and replaces 'east'
     * because 'east' is a substring of 'feasting' (routine).
     */
    @Test
    public void addToSetAvoidingSubstring6() {
        Set<String> testSet = createFromArgs("north", "south", "east");
        Set<String> expectedSet = createFromArgs("north", "south", "feasting");

        String s = "feasting";

        StringReassembly.addToSetAvoidingSubstrings(testSet, s);
        assertEquals(s, "feasting");
        assertEquals(expectedSet, testSet);
    }

    /*
     * Tests for linesFromInput method
     */

    /*
     * Description of code for each linesFromInput test:
     *
     * Open reader for file to test method on, declared test set and set equal
     * to the return value of the linesFromInput method run using the reader,
     * declare expected set and add expected values, check if the test and
     * expected sets are equal, close reader
     */

    /**
     * Tests linesFromInput for a file with no substrings (routine).
     */
    @Test
    public void linesFromInputTest1() {
        SimpleReader inFile = new SimpleReader1L("data/linesFromInputTest.txt");
        Set<String> testSet = StringReassembly.linesFromInput(inFile);
        Set<String> expectedSet = createFromArgs("Line number 1",
                "Line number 2", "Line number 3", "Line number 4");

        assertEquals(expectedSet, testSet);
        inFile.close();
    }

    /**
     * Tests linesFromInput for a file with 1 substring that should be removed
     * (routine).
     */
    @Test
    public void linesFromInputTest2() {
        SimpleReader inFile = new SimpleReader1L(
                "data/linesFromInputTest2.txt");
        Set<String> testSet = StringReassembly.linesFromInput(inFile);
        Set<String> expectedSet = createFromArgs(
                "This line contains a substring", "This line is random",
                "This line is also random");

        assertEquals(expectedSet, testSet);
        inFile.close();
    }

    /**
     * Tests linesFromInput for a file with 2 substrings that should be removed
     * (routine).
     */
    @Test
    public void linesFromInputTest3() {
        SimpleReader inFile = new SimpleReader1L(
                "data/linesFromInputTest3.txt");
        Set<String> testSet = StringReassembly.linesFromInput(inFile);
        Set<String> expectedSet = createFromArgs(
                "There are two substrings in this file",
                "This is the second line that isn't a substring");

        assertEquals(expectedSet, testSet);
        inFile.close();
    }

    /**
     * Tests linesFromInput for a file with 3 substrings that should be removed
     * (routine).
     */
    @Test
    public void linesFromInputTest4() {
        SimpleReader inFile = new SimpleReader1L(
                "data/linesFromInputTest4.txt");
        Set<String> testSet = StringReassembly.linesFromInput(inFile);
        Set<String> expectedSet = createFromArgs(
                "This line has 3 substrings in it");

        assertEquals(expectedSet, testSet);
        inFile.close();
    }

    /**
     * Tests linesFromInput for a file with 1 full substring of another
     * (challenging).
     */
    @Test
    public void linesFromInputTest5() {
        SimpleReader inFile = new SimpleReader1L(
                "data/linesFromInputTest5.txt");
        Set<String> testSet = StringReassembly.linesFromInput(inFile);
        Set<String> expectedSet = createFromArgs("Line A", "Line B", "Line C");

        assertEquals(expectedSet, testSet);
        inFile.close();
    }

    /**
     * Tests linesFromInput for a file with every line being a substring of at
     * least 1 other given line except one (challenging).
     */
    @Test
    public void linesFromInputTest6() {
        SimpleReader inFile = new SimpleReader1L(
                "data/linesFromInputTest6.txt");
        Set<String> testSet = StringReassembly.linesFromInput(inFile);
        Set<String> expectedSet = createFromArgs(
                "This line contains substrings nested within substrings");

        assertEquals(expectedSet, testSet);
        inFile.close();
    }

    /**
     * Tests linesFromInput for a file with every line being 1 letter
     * (boundary).
     */
    @Test
    public void linesFromInputTest7() {
        SimpleReader inFile = new SimpleReader1L(
                "data/linesFromInputTest7.txt");
        Set<String> testSet = StringReassembly.linesFromInput(inFile);
        Set<String> expectedSet = createFromArgs("a", "c", "d");

        assertEquals(expectedSet, testSet);
        inFile.close();
    }

    /*
     * Tests for assemble method
     */

    /*
     * Description of code for each assemble test:
     *
     * Declare test set and add initial values, declare expected set and add
     * expected values with overlaps, run assemble method on test set, check if
     * test set equals expected set
     */

    /**
     * Tests assemble for 0 overlaps (routine).
     */
    @Test
    public void assembleTest1() {
        Set<String> testSet = createFromArgs("There aren't any overlaps",
                "Nothing to see here", "Go away", "Bye");
        Set<String> expectedSet = createFromArgs("There aren't any overlaps",
                "Nothing to see here", "Go away", "Bye");

        StringReassembly.assemble(testSet);
        assertEquals(expectedSet, testSet);
    }

    /**
     * Tests assemble for 1 overlap (routine).
     */
    @Test
    public void assembleTest2() {
        Set<String> testSet = createFromArgs("Beginning", "This set overlaps",
                "overlaps another set", "End");

        Set<String> expectedSet = createFromArgs("Beginning",
                "This set overlaps another set", "End");

        StringReassembly.assemble(testSet);
        assertEquals(expectedSet, testSet);
    }

    /**
     * Tests assemble for 2 overlaps (routine).
     */
    @Test
    public void assembleTest3() {
        Set<String> testSet = createFromArgs("There are 2 overlaps in this set",
                "2 overlaps in this set and this is the first one",
                "Second string that isn't an overlap", "an overlap of another");

        Set<String> expectedSet = createFromArgs(
                "There are 2 overlaps in this set and this is the first one",
                "Second string that isn't an overlap of another");

        StringReassembly.assemble(testSet);
        assertEquals(expectedSet, testSet);
    }

    /**
     * Tests assemble for 3 overlaps (routine).
     */
    @Test
    public void assembleTest4() {
        Set<String> testSet = createFromArgs("This is the start of 3 overlaps",
                "of 3 overlaps, this is the second one",
                "one and two are done, this is the third",
                "third came before, this is the end");

        Set<String> expectedSet = createFromArgs(
                "This is the start of 3 overlaps, this is the second one and two "
                        + "are done, this is the third came before, this is the end");

        StringReassembly.assemble(testSet);
        assertEquals(expectedSet, testSet);
    }

    /**
     * Tests assemble for 2 letter words (boundary).
     */
    @Test
    public void assembleTest5() {
        Set<String> testSet = createFromArgs("to", "of", "it", "is");
        Set<String> expectedSet = createFromArgs("itof", "is");

        StringReassembly.assemble(testSet);
        assertEquals(expectedSet, testSet);
    }

    /**
     * Tests assemble for large overlaps (challenging).
     */
    @Test
    public void assembleTest6() {
        Set<String> testSet = createFromArgs("strain", "trains", "rainstick",
                "sticky");
        Set<String> expectedSet = createFromArgs("strainsticky");

        StringReassembly.assemble(testSet);
        assertEquals(expectedSet, testSet);
    }

    /**
     * Tests assemble for small overlaps (challenging).
     */
    @Test
    public void assembleTest7() {
        Set<String> testSet = createFromArgs("There are very small overlaps",
                "second line of the code", "every line has barely any overlap",
                "please note how little overlap happened");

        Set<String> expectedSet = createFromArgs(
                "There are very small overlapsecond line of the codevery"
                        + " line has barely any overlaplease note how little "
                        + "overlap happened");

        StringReassembly.assemble(testSet);
        assertEquals(expectedSet, testSet);
    }

    /*
     * Tests for printWithLineSeparators method
     */

    /*
     * Description of code for each printWithLineSeparators test:
     *
     * Declare initial string to write to test file, declare writer to the test
     * file, read text from expected file for comparison, call method printing
     * the string to the the test file with line separators, get input from the
     * newly altered file, compare the input from the expected and new test file
     * line by line using assertEquals statements until end of both files are
     * reached.
     */

    /**
     * Tests printWithLineSeparators for 5 letter words on 5 lines (routine).
     */
    @Test
    public void printWithLineSeparatorsTest1() {
        String text = "first~twins~three~fours~fifth";
        SimpleReader expectedInput = new SimpleReader1L(
                "data/lineSeparatorsExpected.txt");
        SimpleWriter testOutput = new SimpleWriter1L("lineSeparatorsTest.txt");

        StringReassembly.printWithLineSeparators(text, testOutput);

        SimpleReader testInput = new SimpleReader1L("lineSeparatorsTest.txt");
        while (!expectedInput.atEOS() && !testInput.atEOS()) {
            assertEquals(expectedInput.nextLine(), testInput.nextLine());
        }

        expectedInput.close();
        testInput.close();
        testOutput.close();
    }

    /**
     * Tests printWithLineSeparators for 6 letter words on 6 lines (routine).
     */
    @Test
    public void printWithLineSeparatorsTest2() {
        String text = "unable~second~triple~fourth~friend~sticky";
        SimpleReader expectedInput = new SimpleReader1L(
                "data/lineSeparatorsExpected2.txt");
        SimpleWriter testOutput = new SimpleWriter1L("lineSeparatorsTest2.txt");

        StringReassembly.printWithLineSeparators(text, testOutput);

        SimpleReader testInput = new SimpleReader1L("lineSeparatorsTest2.txt");
        while (!expectedInput.atEOS() && !testInput.atEOS()) {
            assertEquals(expectedInput.nextLine(), testInput.nextLine());
        }

        expectedInput.close();
        testInput.close();
        testOutput.close();
    }

    /**
     * Tests printWithLineSeparators for 7 letter words on 7 lines (routine).
     */
    @Test
    public void printWithLineSeparatorsTest3() {
        String text = "firstly~doubled~threads~squared~forties~stinger~seventh";
        SimpleReader expectedInput = new SimpleReader1L(
                "data/lineSeparatorsExpected3.txt");
        SimpleWriter testOutput = new SimpleWriter1L("lineSeparatorsTest3.txt");

        StringReassembly.printWithLineSeparators(text, testOutput);

        SimpleReader testInput = new SimpleReader1L("lineSeparatorsTest3.txt");
        while (!expectedInput.atEOS() && !testInput.atEOS()) {
            assertEquals(expectedInput.nextLine(), testInput.nextLine());
        }

        expectedInput.close();
        testInput.close();
        testOutput.close();
    }

    /**
     * Tests printWithLineSeparators for 8 letter words on 8 lines (routine).
     */
    @Test
    public void printWithLineSeparatorsTest4() {
        String text = "entrance~twinkled~triangle~fourthly~battling~exercise~desserts";
        SimpleReader expectedInput = new SimpleReader1L(
                "data/lineSeparatorsExpected4.txt");
        SimpleWriter testOutput = new SimpleWriter1L("lineSeparatorsTest4.txt");

        StringReassembly.printWithLineSeparators(text, testOutput);

        SimpleReader testInput = new SimpleReader1L("lineSeparatorsTest4.txt");
        while (!expectedInput.atEOS() && !testInput.atEOS()) {
            assertEquals(expectedInput.nextLine(), testInput.nextLine());
        }

        expectedInput.close();
        testInput.close();
        testOutput.close();
    }

    /**
     * Tests printWithLineSeparators with spaces in between lines (challenging).
     */
    @Test
    public void printWithLineSeparatorsTest5() {
        String text = "3 spaces below~~~~2 spaces below~~~1 space below~~end";
        SimpleReader expectedInput = new SimpleReader1L(
                "data/lineSeparatorsExpected5.txt");
        SimpleWriter testOutput = new SimpleWriter1L("lineSeparatorsTest5.txt");
        StringReassembly.printWithLineSeparators(text, testOutput);
        SimpleReader testInput = new SimpleReader1L("lineSeparatorsTest5.txt");
        while (!expectedInput.atEOS() && !testInput.atEOS()) {
            assertEquals(expectedInput.nextLine(), testInput.nextLine());
        }
        expectedInput.close();
        testInput.close();
        testOutput.close();
    }

    /**
     * Tests printWithLineSeparators with '~' at the beginning and end only
     * (challenging).
     */
    @Test
    public void printWithLineSeparatorsTest6() {
        String text = "~This line is in the middle of nowhere~";
        SimpleReader expectedInput = new SimpleReader1L(
                "data/lineSeparatorsExpected6.txt");
        SimpleWriter testOutput = new SimpleWriter1L("lineSeparatorsTest6.txt");
        StringReassembly.printWithLineSeparators(text, testOutput);
        SimpleReader testInput = new SimpleReader1L("lineSeparatorsTest6.txt");
        testOutput.close();
        while (!expectedInput.atEOS() && !testInput.atEOS()) {
            assertEquals(expectedInput.nextLine(), testInput.nextLine());
        }
        expectedInput.close();
        testInput.close();
    }

    /**
     * Tests printWithLineSeparators with a single letter and no line separators
     * (boundary).
     */
    @Test
    public void printWithLineSeparatorsTest7() {
        String text = "e";
        SimpleReader expectedInput = new SimpleReader1L(
                "data/lineSeparatorsExpected7.txt");
        SimpleWriter testOutput = new SimpleWriter1L("lineSeparatorsTest7.txt");
        StringReassembly.printWithLineSeparators(text, testOutput);
        SimpleReader testInput = new SimpleReader1L("lineSeparatorsTest7.txt");
        testOutput.close();
        while (!expectedInput.atEOS() && !testInput.atEOS()) {
            assertEquals(expectedInput.nextLine(), testInput.nextLine());
        }
        expectedInput.close();
        testInput.close();
    }

    /**
     * Tests printWithLineSeparators to write all the characters of the keyboard
     * (except '~') on their respective lines (boundary).
     */
    @Test
    public void printWithLineSeparatorsTest8() {
        String text = "`1234567890-=~qwertyuiop[]\\~asdfghjkl;'~zxcvbnm,./";
        SimpleReader expectedInput = new SimpleReader1L(
                "data/lineSeparatorsExpected8.txt");
        SimpleWriter testOutput = new SimpleWriter1L("lineSeparatorsTest8.txt");
        StringReassembly.printWithLineSeparators(text, testOutput);
        SimpleReader testInput = new SimpleReader1L("lineSeparatorsTest8.txt");
        testOutput.close();
        while (!expectedInput.atEOS() && !testInput.atEOS()) {
            assertEquals(expectedInput.nextLine(), testInput.nextLine());
        }
        expectedInput.close();
        testInput.close();
    }

}
