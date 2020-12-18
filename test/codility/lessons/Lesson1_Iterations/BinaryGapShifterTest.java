package codility.lessons.Lesson1_Iterations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by peng.yang on ${Date}
 */
class BinaryGapShifterTest {

    /*
     * Given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5.
     */
    @org.junit.jupiter.api.Test
    void solutionTest1() {
        int N = 1041;
        int expected = 5;
        int actual = codility.lessons.Lesson1_Iterations.BinaryGapShifter.solution(N);
        Assertions.assertEquals(expected, actual);
    }

    /*
     * Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.
     */
    @org.junit.jupiter.api.Test
    void solutionTest2() {
        int N = 32;
        int expected = 0;
        int actual = codility.lessons.Lesson1_Iterations.BinaryGapShifter.solution(N);
        Assertions.assertEquals(expected, actual);
    }
    /*
     * number 9 has binary representation 1001 and contains a binary gap of length 2.
     */
    @org.junit.jupiter.api.Test
    void solutionTest3() {
        int N = 9;
        int expected = 2;
        int actual = codility.lessons.Lesson1_Iterations.BinaryGapShifter.solution(N);
        Assertions.assertEquals(expected, actual);
    }
    /*
     * The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3.
     */
    @org.junit.jupiter.api.Test
    void solutionTest4() {
        int N = 529;
        int expected = 4;
        int actual = codility.lessons.Lesson1_Iterations.BinaryGapShifter.solution(N);
        Assertions.assertEquals(expected, actual);
    }

    /*
     * The number 20 has binary representation 10100 and contains one binary gap of length 1.
     */
    @org.junit.jupiter.api.Test
    void solutionTest5() {
        int N = 20;
        int expected = 1;
        int actual = codility.lessons.Lesson1_Iterations.BinaryGapShifter.solution(N);
        Assertions.assertEquals(expected, actual);
    }
    /*
     * The number 15 has binary representation 1111 and has no binary gaps.
     */
    @org.junit.jupiter.api.Test
    void solutionTest6() {
        int N = 15;
        int expected = 0;
        int actual = codility.lessons.Lesson1_Iterations.BinaryGapShifter.solution(N);
        Assertions.assertEquals(expected, actual);
    }


    /*
     * binary representation 1000100001 and contains two binary gaps: one of length 3 and one of length 4.
     * max gap is 4
     */
    @org.junit.jupiter.api.Test
    void solutionTest7() {
        int N = Integer.parseInt("1000100001", 2);
        System.out.println(N);
        int expected = 4;
        int actual = codility.lessons.Lesson1_Iterations.BinaryGapShifter.solution(N);
        Assertions.assertEquals(expected, actual);
    }
    /*
     * binary representation 1000100001001
     * max gap is 4
     */
    @org.junit.jupiter.api.Test
    void solutionTest8() {
        int N = Integer.parseInt("1000100001001", 2);
        int expected = 4;
        int actual = codility.lessons.Lesson1_Iterations.BinaryGapShifter.solution(N);
        Assertions.assertEquals(expected, actual);
    }
    /*
     * 1
     * max gap is 0
     */
    @org.junit.jupiter.api.Test
    void solutionTest10() {
        int N = 1;
        int expected = 0;
        int actual = codility.lessons.Lesson1_Iterations.BinaryGapShifter.solution(N);
        Assertions.assertEquals(expected, actual);
    }


    /*
     * 2,147,483,647
     * 1111111111111111111111111111111
     * max gap is 4
     */
    @org.junit.jupiter.api.Test
    void solutionTest11() {
        int N = 2147483647;
        System.out.println(Integer.toBinaryString(N));
        int expected = 0;
        int actual = codility.lessons.Lesson1_Iterations.BinaryGapShifter.solution(N);
        Assertions.assertEquals(expected, actual);
    }

}