package ro.bad;

import jdk.Exported;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

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

        generateMaze(0, 15, 20);

        assertEquals("Should have the maze that was expected", expected, Amazing.result.toString());
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

        generateMaze(100, 4, 5);
        assertEquals("Should have the maze that was expected", expected, Amazing.result.toString());

    }

    @Test
    public void test_explore() {
        generateMaze(1, 2, 1);
        generateMaze(1, 1, 2);
        generateMaze(1, 1, 1);
        generateMaze(79, 166, 54);

        for (int i = 1; i < 10; i++) {
            generateMaze(i, 166, 54);
        }

        for (int i=1; i < 10; i++){
            generateMaze(45, 34, i);
        }

        for (int i=1; i < 10; i++){
            generateMaze(45, i, 50);
        }
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void test_explore_02() {
        generateMaze(79, 0, 54);

        System.out.println(Amazing.result.toString());
//        assertEquals("Should have the maze that was expected", expected, Amazing.result.toString());

    }

    @Test
    public void test_explore_targeted_01() {
        generateMaze(1, 4, 4);

        // 340 <- 330
    }


    //~~~ Helper

    private static void generateMaze(int seed, int numberOfColumns, int numberOfRow) {
        Amazing.random = new Random(seed);
        Amazing.doit(numberOfColumns, numberOfRow);
    }
}