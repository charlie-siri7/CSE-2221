import components.sequence.Sequence;
import components.sequence.Sequence1L;
import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Creates a glossary of terms with links to other terms within each page.
 *
 * @author Charles Sirichoktanasup
 *
 */
public final class Glossary {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Glossary() {
    }

    /**
     * Loops through the given file, adding terms or definitions into their
     * respective sequences.
     *
     * @param in
     *            reader for the file to get terms and definitions from
     * @param termSequence
     *            sequence containing the terms from the input
     * @param definitionSequence
     *            sequence containing definitions from the input
     * @requires the input file is formatted with the repeating order of term,
     *           definition (can be many lines), blank line; File must end on a
     *           blank line; no added spaces at the end of each line; terms must
     *           not contain any whitespace characters.
     * @ensures termSequence contains the terms and definitionSequence contains
     *          the definitions in the order they appear in the file
     */
    public static void initializeSequences(SimpleReader in,
            Sequence<String> termSequence,
            Sequence<String> definitionSequence) {
        /* Initialize string of line of input file and index */
        String stringIterator = "";
        int index = 0;
        /*
         * Loops through each line of input file until at end, adding the first
         * line to the current index of the sequence of terms, concatenating
         * subsequent lines into a definition to add to the sequence of
         * definitions (done using a string builder 'defBuilder' in order to
         * avoid concatenating long strings), and restarting the process when a
         * blank line is detected, making the next non-blank line a term. The
         * index of the term and definition altered in the sequence is increased
         * for each iteration. For definitions of several lines, the program
         * adds a space after each definition and gets rid of the extra space at
         * the end using substring.
         *
         */
        while (!in.atEOS()) {
            stringIterator = in.nextLine();
            if (stringIterator.length() > 0) {
                termSequence.add(index, stringIterator);
                stringIterator = in.nextLine();

                String definition = stringIterator;
                StringBuilder defBuilder = new StringBuilder(definition);
                int definitionFragmentCounter = 1;
                while (!in.atEOS() && stringIterator.length() > 0) {
                    stringIterator = in.nextLine();
                    defBuilder.append(" ");
                    defBuilder.append(stringIterator);
                    definitionFragmentCounter++;
                }
                definition = defBuilder.toString();
                if (definitionFragmentCounter > 1) {
                    definition = definition.substring(0,
                            definition.length() - 1);
                }
                definitionSequence.add(index, definition);
                index++;
            }
        }
    }

    /**
     * Sorts the term sequence in alphabetical order and the definition sequence
     * so its terms match with the term sequence.
     *
     * @param termSequence
     *            the sequence of terms to be alphabetized
     * @param definitionSequence
     *            the sequence of definitions to be sorted to correlate to the
     *            alphabetized sequence of terms
     * @requires termSequence and definitionSequence are of the same size
     * @ensures termSequence will be sorted in alphabetical order, and
     *          definitionSequence's values will be rearranged to align with the
     *          new ordering of the terms
     */
    public static void sortSequences(Sequence<String> termSequence,
            Sequence<String> definitionSequence) {
        /*
         * Initialize variables for if termSequence is in order and if it is
         * valid. 2 variables are declared because inOrder will initially be set
         * to true, and it may change to false within the while loop. isValid is
         * set to inOrder after the while loop ends
         */
        boolean inOrder = false;
        boolean isValid = false;
        /*
         * While loop runs until the it finishes with inOrder equaling true.
         * inOrder is set to true at first, and it is changed to false if the
         * for loop changes the value
         */
        while (!isValid) {
            inOrder = true;
            for (int i = 0; i < termSequence.length() - 1; i++) {
                /*
                 * Loop runs for each pair of subsequent terms in the sequence -
                 * checks if they are in alphabetical order. If the 2 terms
                 * aren't in alphabetical order, inOrder is set to false and the
                 * 2 terms are swapped using a temporary string for storage. The
                 * 2 corresponding definitions are also swapped using the same
                 * method.
                 */
                if ((termSequence.entry(i).toLowerCase()).compareTo(
                        termSequence.entry(i + 1).toLowerCase()) > 0) {
                    inOrder = false;

                    String tempTerm = termSequence.entry(i);
                    termSequence.replaceEntry(i, termSequence.entry(i + 1));
                    termSequence.replaceEntry(i + 1, tempTerm);

                    String tempDefinition = definitionSequence.entry(i);
                    definitionSequence.replaceEntry(i,
                            definitionSequence.entry(i + 1));
                    definitionSequence.replaceEntry(i + 1, tempDefinition);
                }
            }
            /*
             * isValid is set to the value of inOrder after the for loop runs
             * through each pair
             */
            isValid = inOrder;
        }
    }

    /**
     * Generates the set of characters in the given {@code String} into the
     * given {@code Set}.
     *
     * @param str
     *            the given {@code String}
     * @param charSet
     *            the {@code Set} to be replaced
     * @replaces charSet
     * @ensures charSet = entries(str)
     */
    public static void generateElements(String str, Set<Character> charSet) {
        assert str != null : "Violation of: str is not null";
        assert charSet != null : "Violation of: charSet is not null";
        /*
         * For each character of the string, check if charSet doesn't contain it
         * and add it to the set if it isn't already present
         */
        for (int i = 0; i < str.length(); i++) {
            if (!charSet.contains(str.charAt(i))) {
                charSet.add(str.charAt(i));
            }
        }

    }

    /**
     * Returns the first "word" (maximal length string of characters not in
     * {@code separators}) or "separator string" (maximal length string of
     * characters in {@code separators}) in the given {@code text} starting at
     * the given {@code position}.
     *
     * @param text
     *            the {@code String} from which to get the word or separator
     *            string
     * @param position
     *            the starting index
     * @param separators
     *            the {@code Set} of separator characters
     * @return the first word or separator string found in {@code text} starting
     *         at index {@code position}
     * @requires 0 <= position < |text|
     * @ensures <pre>
     * nextWordOrSeparator =
     *   text[position, position + |nextWordOrSeparator|)  and
     * if entries(text[position, position + 1)) intersection separators = {}
     * then
     *   entries(nextWordOrSeparator) intersection separators = {}  and
     *   (position + |nextWordOrSeparator| = |text|  or
     *    entries(text[position, position + |nextWordOrSeparator| + 1))
     *      intersection separators /= {})
     * else
     *   entries(nextWordOrSeparator) is subset of separators  and
     *   (position + |nextWordOrSeparator| = |text|  or
     *    entries(text[position, position + |nextWordOrSeparator| + 1))
     *      is not subset of separators)
     * </pre>
     */
    public static String nextWordOrSeparator(String text, int position,
            Set<Character> separators) {
        assert text != null : "Violation of: text is not null";
        assert separators != null : "Violation of: separators is not null";
        assert 0 <= position : "Violation of: 0 <= position";
        assert position < text.length() : "Violation of: position < |text|";
        /*
         * Initialize returnString to nothing and pos to the given position;
         * runs the if condition corresponding to whether the next character of
         * the string at the index is in the separator set or not. If it is a
         * separator, then a string builder is used to concatenate subsequent
         * characters as long as they are also separators. Otherwise a string
         * builder is used to concatenate subsequent characters as long as they
         * aren't separators. After the longest string of separators or
         * non-separators in contained in the string builder, the result is
         * transformed into a string and then returned.
         */
        StringBuilder returnStringBuilder = new StringBuilder();
        int pos = position;
        if (separators.contains(text.charAt(pos))) {
            while (pos < text.length()
                    && separators.contains(text.charAt(pos))) {
                returnStringBuilder.append(text.charAt(pos));
                pos++;
            }
        } else {
            while (pos < text.length()
                    && !separators.contains(text.charAt(pos))) {
                returnStringBuilder.append(text.charAt(pos));
                pos++;
            }
        }
        return returnStringBuilder.toString();
    }

    /**
     * Returns a sequence made up of words and separators from the given text,
     * using values from the separators set to indicate separators.
     *
     * @param text
     *            the text to split into words and separators to add to a
     *            sequence
     * @param separators
     *            set of separators to determine if a fragment of the string is
     *            a word or separator
     * @return a sequence with words and separators from the original string
     * @requires text is a valid string and the set of separators contains the
     *           characters the user intends to be separators
     * @ensures sequence is returned containing an the separated words and
     *          separators of the original string in sequential order
     */
    public static Sequence<String> makeWordOrSeparatorSequence(String text,
            Set<Character> separators) {
        /*
         * Initialize wordOrSeparator (string for each respective word or
         * separator), position (position of the start of the current word or
         * separator in the text), counter (counter for the number of words and
         * separators), and sequence to store words and separators
         */
        String wordOrSeparator;
        int position = 0;
        int counter = 0;
        Sequence<String> wordOrSeparatorSequence = new Sequence1L<String>();
        /*
         * Loops through the text, adding each word or separator to the new
         * sequence at increasing indices. It uses the length of each added word
         * or separator to determine where the index of the next one begins.
         */
        while (position < text.length()) {
            wordOrSeparator = nextWordOrSeparator(text, position, separators);
            wordOrSeparatorSequence.add(counter, wordOrSeparator);
            counter++;
            position += wordOrSeparator.length();
        }
        /* Return the sequence of words and separators */
        return wordOrSeparatorSequence;
    }

    /**
     * Prints an instance of a word or separator via the given SimpleWriter, and
     * adds a hyperlink if a word is another term from the glossary.
     *
     * @param out
     *            the SimpleWriter to the destination page of the definition
     *            fragment
     * @param instance
     *            an instance of a word or line separator to be printed
     * @param isAnotherTerm
     *            boolean representing if the word or separator is another term
     * @requires out leads to a location where HTML can be printed, instance is
     *           a proper word or separator, isAnotherTerm determines if
     *           instance is another term in the glossary
     * @ensures instance will be printed to the SimpleWriter location and will
     *          have a link to another term's page if it is another term
     */
    public static void printNextDefinitionFragment(SimpleWriter out,
            String instance, boolean isAnotherTerm) {
        if (isAnotherTerm) {
            /*
             * If the current word in the definition is another term, print the
             * word as a link to the HTML page of the term
             */
            out.print("<a href=\"");
            out.print(instance);
            out.print(".html\">");
            out.print(instance);
            out.print("</a>");
        } else {
            /* Otherwise, just print the word or separator as normal */
            out.print(instance);
        }
    }

    /**
     * Prints the HTML code that occurs before any variables are used using the
     * given writer to a file.
     *
     * @param out
     *            writer to a file to print HTML code to
     * @requires the intended title of the page is 'glossary', and the glossary
     *           page to print out is the 'index' page.
     * @ensures the glossary header is printed on the page
     */
    public static void printIndexHeader(SimpleWriter out) {
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Glossary</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Glossary</h2>");
        out.println("<hr>");
        out.println("<h3>Index</h3>");
        out.println("<ul>");
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     * @requires user inputs an input file and output folder that both exist
     *           with correct path
     * @ensures HTML document of the glossary made from the input file will be
     *          generated under the name 'index' within the designated output
     *          folder
     */
    public static void main(String[] args) {
        /*
         * Gets user input for the address of input file and name of the output
         * folder
         */
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        out.print("Enter an input file: ");
        String fileString = in.nextLine();

        out.print("Enter an output folder: ");
        String folderString = in.nextLine();
        SimpleReader fileInput = new SimpleReader1L(fileString);
        fileInput.close();
        fileInput = new SimpleReader1L(fileString);
        /*
         * Declares sequences based on the number of spaces (each block of terms
         * and definitions has a space after it), calls initializeSequences to
         * insert terms and definitions into respective sequences, and calls
         * sortSequence to sort the sequences based on alphabetical order of
         * terms
         */
        Sequence<String> termSequence = new Sequence1L<String>();
        Sequence<String> definitionSequence = new Sequence1L<String>();

        initializeSequences(fileInput, termSequence, definitionSequence);
        sortSequences(termSequence, definitionSequence);
        /*
         * 3 sets are initialized: 1 to store terms, 1 to store separators, 1 to
         * store instances of both in a definition. Actions performed on sets:
         * items from termSequence are looped through to add to termSet,
         * separators are declared and added to separatorSet
         */
        Set<String> termSet = new Set1L<String>();
        Set<Character> separatorSet = new Set1L<>();
        Set<String> wordOrSeparatorSet = new Set1L<String>();

        for (int i = 0; i < termSequence.length(); i++) {
            if (!termSet.contains(termSequence.entry(i))) {
                termSet.add(termSequence.entry(i));
            }
        }
        final String separators = " \t, ~_./\\;\"";
        generateElements(separators, separatorSet);
        /*
         * Writer declared for the index HTML file, sequence of writers
         * initialized for HTML page of each term. Header and start of unordered
         * list printed to index HTML file using printIndexHeader
         */
        SimpleWriter indexWriter = new SimpleWriter1L(
                folderString + "/index.html");
        Sequence<SimpleWriter> termWriterSequence = new Sequence1L<SimpleWriter>();
        printIndexHeader(indexWriter);
        /* Loops through each term */
        for (int i = 0; i < termSequence.length(); i++) {
            /*
             * Print sequence item for each term with link to respective HTML
             * page, Declare SimpleWriter for the current term's HTML page,
             * prints header with proper format, indents paragraph before
             * definition is written
             */
            indexWriter.println("<li><a href=\"" + termSequence.entry(i)
                    + ".html" + "\">" + termSequence.entry(i) + "</a></li>");

            termWriterSequence.add(i, new SimpleWriter1L(
                    folderString + "/" + termSequence.entry(i) + ".html"));
            termWriterSequence.entry(i).println("<html>");
            termWriterSequence.entry(i).println("<head>");
            termWriterSequence.entry(i)
                    .println("<title>" + termSequence.entry(i) + "</title>");
            termWriterSequence.entry(i).println("</head>");
            termWriterSequence.entry(i).println("<body>");
            termWriterSequence.entry(i).println("<h2><b><i><font color=\"red\">"
                    + termSequence.entry(i) + "</font></i></b></h2>");
            termWriterSequence.entry(i).print("<p>&emsp;&emsp;&ensp;");
            /*
             * Calls makeWordOrSeparatorSequence on the current term's
             * definition to break the definition up into a sequence of words
             * and separators, for loop iterates over each word or separator in
             * current definition
             */
            Sequence<String> wordOrSeparatorSeqeunce = makeWordOrSeparatorSequence(
                    definitionSequence.entry(i), separatorSet);
            for (int j = 0; j < wordOrSeparatorSeqeunce.length(); j++) {
                /*
                 * Calls printNextDefinitionFragment to print each word or
                 * separator of the definition to the paragraph on the current
                 * term's HTML page, adding links to the pages of other terms if
                 * they show up in the definition and making sure links aren't
                 * shown if the name of the current term reappears.
                 */
                printNextDefinitionFragment(termWriterSequence.entry(i),
                        wordOrSeparatorSeqeunce.entry(j),
                        termSet.contains(wordOrSeparatorSeqeunce.entry(j))
                                && !wordOrSeparatorSeqeunce.entry(j)
                                        .equals(termSequence.entry(i)));
            }
            /*
             * Print the end of the paragraph, horizontal line, and link to go
             * back to glossary on the current term's HTML page, close current
             * writer, and reset wordOrSeparator set for the next term
             */
            termWriterSequence.entry(i).println("</p>");
            termWriterSequence.entry(i).println("<hr>");
            termWriterSequence.entry(i).println(
                    "<p>Return to <a href=\"index.html\">index</a>.</p>");
            termWriterSequence.entry(i).println("</body>");
            termWriterSequence.entry(i).println("</html>");

            termWriterSequence.entry(i).close();
            wordOrSeparatorSet.clear();
        }
        indexWriter.println("</ul>");
        indexWriter.println("</body>");
        indexWriter.println("</html>");
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
        indexWriter.close();
    }

}
