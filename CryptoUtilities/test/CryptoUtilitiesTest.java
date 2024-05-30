import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * @author Charles Sirichoktanasup
 *
 */
public class CryptoUtilitiesTest {

    /*
     * Breakdown of each test case: - final ints are set to the original and
     * expected values of each function parameter - NaturalNumbers are set to
     * the values of the final ints - function from CryptoUtilities2 is run on
     * the original-value variables - assertEquals calls are made to ensure the
     * changed variables equal their expected values
     */

    /*
     * Tests of reduceToGCD
     */

    /**
     * Tests reduceToGCD for n = 3 and m = 0 (boundary).
     */
    @Test
    public void testReduceToGCDfor3and0() {
        final int nInt = 3;
        NaturalNumber n = new NaturalNumber2(nInt);
        NaturalNumber nExpected = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(0);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    /**
     * Tests reduceToGCD for n = 1 and m = 2 (boundary).
     */
    @Test
    public void testReduceToGCDfor1and2() {
        NaturalNumber n = new NaturalNumber2(1);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber m = new NaturalNumber2(2);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    /**
     * Tests reduceToGCD for n = 15116544 and m = 399679488 (challenging).
     */
    @Test
    public void testReduceToGCDfor15116544and399679488() {
        final int nInt = 15116544;
        final int nExpectedInt = 6912;
        final int mInt = 399679488;
        NaturalNumber n = new NaturalNumber2(nInt);
        NaturalNumber nExpected = new NaturalNumber2(nExpectedInt);
        NaturalNumber m = new NaturalNumber2(mInt);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    /**
     * Tests reduceToGCD for n = 1000003 and m = 99999999 (challenging).
     */
    @Test
    public void testReduceToGCDfor1000003and99999999() {
        final int nInt = 1000003;
        final int mInt = 99999999;
        NaturalNumber n = new NaturalNumber2(nInt);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber m = new NaturalNumber2(mInt);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    /**
     * Tests reduceToGCD for n = 3 and m = 9 (routine: 1 digit numbers).
     */
    @Test
    public void testReduceToGCDfor3and9() {
        final int nInt = 3;
        final int nExpectedInt = 3;
        final int mInt = 9;
        NaturalNumber n = new NaturalNumber2(nInt);
        NaturalNumber nExpected = new NaturalNumber2(nExpectedInt);
        NaturalNumber m = new NaturalNumber2(mInt);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    /**
     * Tests reduceToGCD for n = 37 and m = 12 (routine: 2 digit numbers).
     */
    @Test
    public void testReduceToGCDfor37and12() {
        final int nInt = 37;
        final int nExpectedInt = 1;
        final int mInt = 12;
        NaturalNumber n = new NaturalNumber2(nInt);
        NaturalNumber nExpected = new NaturalNumber2(nExpectedInt);
        NaturalNumber m = new NaturalNumber2(mInt);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    /**
     * Tests reduceToGCD for n = 335 and m = 680 (routine: 3 digit numbers).
     */
    @Test
    public void testReduceToGCDfor335and680() {
        final int nInt = 335;
        final int nExpectedInt = 5;
        final int mInt = 680;
        NaturalNumber n = new NaturalNumber2(nInt);
        NaturalNumber nExpected = new NaturalNumber2(nExpectedInt);
        NaturalNumber m = new NaturalNumber2(mInt);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    /**
     * Tests reduceToGCD for n = 8857 and m = 4050 (routine: 4 digit numbers).
     */
    @Test
    public void testReduceToGCDfor8857and4050() {
        final int nInt = 8857;
        final int nExpectedInt = 1;
        final int mInt = 4050;
        NaturalNumber n = new NaturalNumber2(nInt);
        NaturalNumber nExpected = new NaturalNumber2(nExpectedInt);
        NaturalNumber m = new NaturalNumber2(mInt);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    /*
     * Tests of isEven
     */

    /**
     * Tests testIsEven for n = 0 (boundary).
     */
    @Test
    public void testIsEvenfor0() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(0);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    /**
     * Tests testIsEven for n = 987654321 (challenging).
     */
    @Test
    public void testIsEvenfor987654321() {
        final int nInt = 987654321;
        final int nExpectedInt = 987654321;
        NaturalNumber n = new NaturalNumber2(nInt);
        NaturalNumber nExpected = new NaturalNumber2(nExpectedInt);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(false, result);
    }

    /**
     * Tests testIsEven for n = 8 (routine - 1 digit even).
     */
    @Test
    public void testIsEvenfor8() {
        final int nInt = 8;
        final int nExpectedInt = 8;
        NaturalNumber n = new NaturalNumber2(nInt);
        NaturalNumber nExpected = new NaturalNumber2(nExpectedInt);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    /**
     * Tests testIsEven for n = 7 (routine - 1 digit odd).
     */
    @Test
    public void testIsEvenfor7() {
        final int nInt = 7;
        final int nExpectedInt = 7;
        NaturalNumber n = new NaturalNumber2(nInt);
        NaturalNumber nExpected = new NaturalNumber2(nExpectedInt);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(false, result);
    }

    /**
     * Tests testIsEven for n = 64 (routine - 2 digit even).
     */
    @Test
    public void testIsEvenfor64() {
        final int nInt = 64;
        final int nExpectedInt = 64;
        NaturalNumber n = new NaturalNumber2(nInt);
        NaturalNumber nExpected = new NaturalNumber2(nExpectedInt);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    /**
     * Tests testIsEven for n = 49 (routine - 2 digit odd).
     */
    @Test
    public void testIsEvenfor49() {
        final int nInt = 49;
        final int nExpectedInt = 49;
        NaturalNumber n = new NaturalNumber2(nInt);
        NaturalNumber nExpected = new NaturalNumber2(nExpectedInt);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(false, result);
    }

    /**
     * Tests testIsEven for n = 512 (routine - 3 digit even).
     */
    @Test
    public void testIsEvenfor512() {
        final int nInt = 512;
        final int nExpectedInt = 512;
        NaturalNumber n = new NaturalNumber2(nInt);
        NaturalNumber nExpected = new NaturalNumber2(nExpectedInt);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    /**
     * Tests testIsEven for n = 343 (routine - 3 digit odd).
     */
    @Test
    public void testIsEvenfor343() {
        final int nInt = 343;
        final int nExpectedInt = 343;
        NaturalNumber n = new NaturalNumber2(nInt);
        NaturalNumber nExpected = new NaturalNumber2(nExpectedInt);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(false, result);
    }

    /*
     * Tests of powerMod
     */

    /**
     * Tests testPowerMod for n = 0, p = 0, and m = 2 (boundary).
     */
    @Test
    public void testPowerModforn0p0m2() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber p = new NaturalNumber2(0);
        NaturalNumber pExpected = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(2);
        NaturalNumber mExpected = new NaturalNumber2(2);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    /**
     * Tests testPowerMod for n = 48, p = 123456789, and m = 6 (challenging).
     */
    @Test
    public void testPowerModforn48p123456789m6() {
        final int nInt = 48;
        final int pInt = 123456789;
        final int pExpectedInt = 123456789;
        final int mInt = 6;
        final int mExpectedInt = 6;
        NaturalNumber n = new NaturalNumber2(nInt);
        NaturalNumber nExpected = new NaturalNumber2(0);
        NaturalNumber p = new NaturalNumber2(pInt);
        NaturalNumber pExpected = new NaturalNumber2(pExpectedInt);
        NaturalNumber m = new NaturalNumber2(mInt);
        NaturalNumber mExpected = new NaturalNumber2(mExpectedInt);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    /**
     * Tests testPowerMod for n = 4, p = 987654321, and m = 256 (challenging).
     */
    @Test
    public void testPowerModforn4p987654321m256() {
        final int nInt = 4;
        final int pInt = 987654321;
        final int pExpectedInt = 987654321;
        final int mInt = 256;
        final int mExpectedInt = 256;
        NaturalNumber n = new NaturalNumber2(nInt);
        NaturalNumber nExpected = new NaturalNumber2(0);
        NaturalNumber p = new NaturalNumber2(pInt);
        NaturalNumber pExpected = new NaturalNumber2(pExpectedInt);
        NaturalNumber m = new NaturalNumber2(mInt);
        NaturalNumber mExpected = new NaturalNumber2(mExpectedInt);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    /**
     * Tests testPowerMod for n = 17, p = 18, and m = 19.
     */
    @Test
    public void testPowerModforn17p18m19() {
        final int nInt = 17;
        final int pInt = 18;
        final int pExpectedInt = 18;
        final int mInt = 19;
        final int mExpectedInt = 19;
        NaturalNumber n = new NaturalNumber2(nInt);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber p = new NaturalNumber2(pInt);
        NaturalNumber pExpected = new NaturalNumber2(pExpectedInt);
        NaturalNumber m = new NaturalNumber2(mInt);
        NaturalNumber mExpected = new NaturalNumber2(mExpectedInt);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    /**
     * Tests testPowerMod for n = 1, p = 2, and m = 3 (routine).
     */
    @Test
    public void testPowerModforn1p2m3() {
        final int nInt = 1;
        final int nExpectedInt = 1;
        final int pInt = 2;
        final int pExpectedInt = 2;
        final int mInt = 3;
        final int mExpectedInt = 3;
        NaturalNumber n = new NaturalNumber2(nInt);
        NaturalNumber nExpected = new NaturalNumber2(nExpectedInt);
        NaturalNumber p = new NaturalNumber2(pInt);
        NaturalNumber pExpected = new NaturalNumber2(pExpectedInt);
        NaturalNumber m = new NaturalNumber2(mInt);
        NaturalNumber mExpected = new NaturalNumber2(mExpectedInt);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    /**
     * Tests testPowerMod for n = 2, p = 4, and m = 6 (routine).
     */
    @Test
    public void testPowerModforn2p4m6() {
        final int nInt = 2;
        final int nExpectedInt = 4;
        final int pInt = 4;
        final int pExpectedInt = 4;
        final int mInt = 6;
        final int mExpectedInt = 6;
        NaturalNumber n = new NaturalNumber2(nInt);
        NaturalNumber nExpected = new NaturalNumber2(nExpectedInt);
        NaturalNumber p = new NaturalNumber2(pInt);
        NaturalNumber pExpected = new NaturalNumber2(pExpectedInt);
        NaturalNumber m = new NaturalNumber2(mInt);
        NaturalNumber mExpected = new NaturalNumber2(mExpectedInt);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    /**
     * Tests testPowerMod for n = 3, p = 6, and m = 9 (routine).
     */
    @Test
    public void testPowerModforn3p6m9() {
        final int nInt = 3;
        final int nExpectedInt = 0;
        final int pInt = 6;
        final int pExpectedInt = 6;
        final int mInt = 9;
        final int mExpectedInt = 9;
        NaturalNumber n = new NaturalNumber2(nInt);
        NaturalNumber nExpected = new NaturalNumber2(nExpectedInt);
        NaturalNumber p = new NaturalNumber2(pInt);
        NaturalNumber pExpected = new NaturalNumber2(pExpectedInt);
        NaturalNumber m = new NaturalNumber2(mInt);
        NaturalNumber mExpected = new NaturalNumber2(mExpectedInt);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    /**
     * Tests testPowerMod for n = 5, p = 10, and m = 15 (routine).
     */
    @Test
    public void testPowerModforn5p10m15() {
        final int nInt = 5;
        final int nExpectedInt = 10;
        final int pInt = 10;
        final int pExpectedInt = 10;
        final int mInt = 15;
        final int mExpectedInt = 15;
        NaturalNumber n = new NaturalNumber2(nInt);
        NaturalNumber nExpected = new NaturalNumber2(nExpectedInt);
        NaturalNumber p = new NaturalNumber2(pInt);
        NaturalNumber pExpected = new NaturalNumber2(pExpectedInt);
        NaturalNumber m = new NaturalNumber2(mInt);
        NaturalNumber mExpected = new NaturalNumber2(mExpectedInt);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    /**
     * Tests of isPrime1.
     */

    /**
     * Tests isPrime1 for 2 (boundary).
     */
    @Test
    public void isPrime1for2() {
        final int nInt = 2;
        NaturalNumber n = new NaturalNumber2(nInt);
        boolean isPrime = CryptoUtilities.isPrime1(n);
        assertEquals(isPrime, true);
    }

    /**
     * Tests isPrime1 for 700000002 (challenging).
     */
    @Test
    public void isPrime1for700000002() {
        final int nInt = 700000002;
        NaturalNumber n = new NaturalNumber2(nInt);
        boolean isPrime = CryptoUtilities.isPrime1(n);
        assertEquals(isPrime, false);
    }

    /**
     * Tests isPrime1 for 1000000007 (challenging).
     */
    @Test
    public void isPrime1for1000000007() {
        final int nInt = 1000000007;
        NaturalNumber n = new NaturalNumber2(nInt);
        boolean isPrime = CryptoUtilities.isPrime1(n);
        assertEquals(isPrime, true);
    }

    /**
     * Tests isPrime1 for 9 (routine - 1 digit).
     */
    @Test
    public void isPrime1for9() {
        final int nInt = 9;
        NaturalNumber n = new NaturalNumber2(nInt);
        boolean isPrime = CryptoUtilities.isPrime1(n);
        assertEquals(isPrime, false);
    }

    /**
     * Tests isPrime1 for 41 (routine - 2 digits).
     */
    @Test
    public void isPrime1for41() {
        final int nInt = 41;
        NaturalNumber n = new NaturalNumber2(nInt);
        boolean isPrime = CryptoUtilities.isPrime1(n);
        assertEquals(isPrime, true);
    }

    /**
     * Tests isPrime1 for 322 (routine - 3 digits).
     */
    @Test
    public void isPrime1for322() {
        final int nInt = 322;
        NaturalNumber n = new NaturalNumber2(nInt);
        boolean isPrime = CryptoUtilities.isPrime1(n);
        assertEquals(isPrime, false);
    }

    /**
     * Tests isPrime1 for 1777 (routine - 4 digits).
     */
    @Test
    public void isPrime1for1777() {
        final int nInt = 1777;
        NaturalNumber n = new NaturalNumber2(nInt);
        boolean isPrime = CryptoUtilities.isPrime1(n);
        assertEquals(isPrime, true);
    }

    /**
     * Tests isPrime1 for 68288 (routine - 5 digits).
     */
    @Test
    public void isPrime1for68288() {
        final int nInt = 68288;
        NaturalNumber n = new NaturalNumber2(nInt);
        boolean isPrime = CryptoUtilities.isPrime1(n);
        assertEquals(isPrime, false);
    }

    /**
     * Tests of isPrime2.
     */

    /**
     * Tests isPrime2 for 2 (boundary).
     */
    @Test
    public void isPrime2for2() {
        final int nInt = 2;
        NaturalNumber n = new NaturalNumber2(nInt);
        boolean isPrime = CryptoUtilities.isPrime2(n);
        assertEquals(isPrime, true);
    }

    /**
     * Tests isPrime2 for 999999939 (challenging).
     */
    @Test
    public void isPrime2for999999939() {
        final int nInt = 999999939;
        NaturalNumber n = new NaturalNumber2(nInt);
        boolean isPrime = CryptoUtilities.isPrime2(n);
        assertEquals(isPrime, false);
    }

    /**
     * Tests isPrime2 for 999999937 (challenging).
     */
    @Test
    public void isPrime2for999999937() {
        final int nInt = 999999937;
        NaturalNumber n = new NaturalNumber2(nInt);
        boolean isPrime = CryptoUtilities.isPrime2(n);
        assertEquals(isPrime, true);
    }

    /**
     * Tests isPrime2 for 6 (routine - 1 digit).
     */
    @Test
    public void isPrime2for6() {
        final int nInt = 6;
        NaturalNumber n = new NaturalNumber2(nInt);
        boolean isPrime = CryptoUtilities.isPrime2(n);
        assertEquals(isPrime, false);
    }

    /**
     * Tests isPrime2 for 53 (routine - 2 digits).
     */
    @Test
    public void isPrime2for53() {
        final int nInt = 53;
        NaturalNumber n = new NaturalNumber2(nInt);
        boolean isPrime = CryptoUtilities.isPrime2(n);
        assertEquals(isPrime, true);
    }

    /**
     * Tests isPrime2 for 796 (routine - 3 digits).
     */
    @Test
    public void isPrime2for796() {
        final int nInt = 796;
        NaturalNumber n = new NaturalNumber2(nInt);
        boolean isPrime = CryptoUtilities.isPrime2(n);
        assertEquals(isPrime, false);
    }

    /**
     * Tests isPrime2 for 2371 (routine - 4 digits).
     */
    @Test
    public void isPrime2for2371() {
        final int nInt = 2371;
        NaturalNumber n = new NaturalNumber2(nInt);
        boolean isPrime = CryptoUtilities.isPrime2(n);
        assertEquals(isPrime, true);
    }

    /**
     * Tests isPrime2 for 55723 (routine - 5 digits).
     */
    @Test
    public void isPrime2for55723() {
        final int nInt = 55723;
        NaturalNumber n = new NaturalNumber2(nInt);
        boolean isPrime = CryptoUtilities.isPrime2(n);
        assertEquals(isPrime, false);
    }

    /**
     * Tests of generateNextLikelyPrime.
     */

    /**
     * Tests generateNextLikelyPrime for 2 (boundary).
     */
    @Test
    public void generateNextLikelyPrimefor2() {
        final int nExpectedInt = 3;
        NaturalNumber n = new NaturalNumber2(2);
        NaturalNumber nExpected = new NaturalNumber2(nExpectedInt);
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals(nExpected, n);
    }

    /**
     * Tests generateNextLikelyPrime for 999999950 (challenging).
     */
    @Test
    public void generateNextLikelyPrimefor999999950() {
        final int nInt = 999999950;
        final int nExpectedInt = 1000000007;
        NaturalNumber n = new NaturalNumber2(nInt);
        NaturalNumber nExpected = new NaturalNumber2(nExpectedInt);
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals(nExpected, n);
    }

    /**
     * Tests generateNextLikelyPrime for 357375367 (challenging).
     */
    @Test
    public void generateNextLikelyPrimefor357375367() {
        final int nInt = 357375367;
        final int nExpectedInt = 357375373;
        NaturalNumber n = new NaturalNumber2(nInt);
        NaturalNumber nExpected = new NaturalNumber2(nExpectedInt);
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals(nExpected, n);
    }

    /**
     * Tests generateNextLikelyPrime for 6 (routine - 1 digit).
     */
    @Test
    public void generateNextLikelyPrimefor6() {
        final int nInt = 6;
        final int nExpectedInt = 7;
        NaturalNumber n = new NaturalNumber2(nInt);
        NaturalNumber nExpected = new NaturalNumber2(nExpectedInt);
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals(nExpected, n);
    }

    /**
     * Tests generateNextLikelyPrime for 73 (routine - 2 digits).
     */
    @Test
    public void generateNextLikelyPrimefor73() {
        final int nInt = 73;
        final int nExpectedInt = 79;
        NaturalNumber n = new NaturalNumber2(nInt);
        NaturalNumber nExpected = new NaturalNumber2(nExpectedInt);
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals(nExpected, n);
    }

    /**
     * Tests generateNextLikelyPrime for 195 (routine - 3 digits).
     */
    @Test
    public void generateNextLikelyPrimefor195() {
        final int nInt = 195;
        final int nExpectedInt = 197;
        NaturalNumber n = new NaturalNumber2(nInt);
        NaturalNumber nExpected = new NaturalNumber2(nExpectedInt);
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals(nExpected, n);
    }

    /**
     * Tests generateNextLikelyPrime for 2437 (routine - 4 digits).
     */
    @Test
    public void generateNextLikelyPrimefor2437() {
        final int nInt = 2437;
        final int nExpectedInt = 2441;
        NaturalNumber n = new NaturalNumber2(nInt);
        NaturalNumber nExpected = new NaturalNumber2(nExpectedInt);
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals(nExpected, n);
    }

    /**
     * Tests generateNextLikelyPrime for 83017 (routine - 5 digits).
     */
    @Test
    public void generateNextLikelyPrimefor83017() {
        final int nInt = 83017;
        final int nExpectedInt = 83023;
        NaturalNumber n = new NaturalNumber2(nInt);
        NaturalNumber nExpected = new NaturalNumber2(nExpectedInt);
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals(nExpected, n);
    }

}
