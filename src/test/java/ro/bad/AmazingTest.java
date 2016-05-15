package ro.bad;

import org.approvaltests.legacycode.LegacyApprovals;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class AmazingTest {

    @Test
    public void testSeed0size15x20() {
        String expected =
                "Amazing - Copyright by Creative Computing, Morristown, NJ\n" +
                        ":--:--:--:--:--:--:--:--:--:--:  :--:--:--:--:\n" +
                        "I  I           I        I     I     I        I \n" +
                        ":  :  :  :  :  :  :--:  :  :  :  :--:  :--:  :\n" +
                        "I     I  I  I  I     I     I     I     I  I  I \n" +
                        ":--:--:  :  :--:  :  :--:--:--:--:  :  :  :  :\n" +
                        "I     I  I        I  I              I  I     I \n" +
                        ":  :  :  :--:--:--:  :  :  :--:--:--:--:--:--:\n" +
                        "I  I     I        I     I  I     I        I  I \n" +
                        ":--:--:  :--:  :--:  :--:  :  :  :  :--:  :  :\n" +
                        "I     I        I        I  I  I     I     I  I \n" +
                        ":  :  :--:--:--:  :--:  :  :  :--:--:  :--:  :\n" +
                        "I  I              I     I  I  I     I  I     I \n" +
                        ":  :--:--:--:--:--:--:  :  :  :  :--:  :--:  :\n" +
                        "I        I           I  I  I  I     I  I     I \n" +
                        ":  :--:  :--:  :  :  :  :  :  :--:  :  :  :--:\n" +
                        "I  I     I     I  I  I  I  I     I  I  I  I  I \n" +
                        ":  :  :--:  :--:  :  :  :  :--:  :  :  :  :  :\n" +
                        "I  I        I     I  I  I        I  I  I  I  I \n" +
                        ":  :--:  :--:  :--:  :  :--:--:--:  :  :  :  :\n" +
                        "I     I     I  I  I  I  I     I        I     I \n" +
                        ":--:  :--:  :  :  :  :--:  :  :  :--:--:  :--:\n" +
                        "I  I     I  I     I     I  I  I     I  I     I \n" +
                        ":  :--:  :--:--:--:  :  :  :  :--:  :  :  :  :\n" +
                        "I     I     I     I  I  I  I     I  I  I  I  I \n" +
                        ":  :  :--:  :  :  :--:  :  :--:  :  :  :  :  :\n" +
                        "I  I        I  I     I  I     I     I  I  I  I \n" +
                        ":  :--:--:  :--:  :  :  :--:  :--:--:  :  :--:\n" +
                        "I  I     I        I  I     I     I     I     I \n" +
                        ":  :  :--:--:--:--:  :  :--:  :  :  :--:--:  :\n" +
                        "I     I           I  I     I  I  I  I     I  I \n" +
                        ":  :--:  :--:--:--:  :--:  :  :  :  :  :  :  :\n" +
                        "I  I                 I     I  I  I     I  I  I \n" +
                        ":  :  :--:--:--:--:--:  :--:  :--:  :--:  :  :\n" +
                        "I  I  I  I           I     I     I  I     I  I \n" +
                        ":  :  :  :  :--:  :  :--:  :--:  :  :  :--:  :\n" +
                        "I  I  I     I     I  I  I     I     I  I     I \n" +
                        ":--:  :--:--:  :  :  :  :  :  :--:--:  :--:  :\n" +
                        "I     I        I  I  I  I  I  I     I        I \n" +
                        ":  :--:  :--:--:  :  :  :  :  :--:  :  :--:--:\n" +
                        "I        I        I     I  I        I        I \n" +
                        ":--:--:--:--:--:--:--:--:  :--:--:--:--:--:--:\n";

        String result = generateMaze(0, 15, 20);

        assertEquals("Should have the maze that was expected", expected, result);
    }

    @Test
    public void testSeed100size4x5() {
        String expected =
                "Amazing - Copyright by Creative Computing, Morristown, NJ\n" +
                        ":--:--:  :--:\n" +
                        "I     I     I \n" +
                        ":  :--:  :  :\n" +
                        "I  I     I  I \n" +
                        ":  :  :--:  :\n" +
                        "I  I  I     I \n" +
                        ":  :  :  :  :\n" +
                        "I  I  I  I  I \n" +
                        ":  :--:  :  :\n" +
                        "I  I  I  I  I \n" +
                        ":--:--:  :--:\n";

        String result = generateMaze(100, 4, 5);
        assertEquals("Should have the maze that was expected", expected, result);

    }

//  1. Functie pura ?
//  2. Functie apelata in mai multe locuri ?
//  3. Functie cu scop clar ?


    @Test
    public void test_lockdown() throws Exception {
        LegacyApprovals.LockDown(this, "generateMaze",
                range(1, 10),
                range(1, 10),
                range(1, 10));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void test_explore_02() {
        generateMaze(79, 0, 54);
    }

    //~~~ Helper

    private static  Object[] range(int startInclusive, int endExclusive) {
        return IntStream.range(startInclusive, endExclusive).boxed().toArray();
    }

    public String generateMaze(Integer seed, Integer numberOfColumns, Integer numberOfRow) {
        Amazing amaze = new Amazing(seed);
        return amaze.doit(numberOfColumns, numberOfRow);
    }
}