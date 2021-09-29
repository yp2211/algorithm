package codility.lessons.Lesson12_EuclideanAlgorithm;

import org.junit.jupiter.api.Test;

public class Lesson12ExercisesTest {
    Lesson12Exercises s = new Lesson12Exercises();
    @Test
    public void test1() {
        int a = 625, b = 250;
        System.out.println(s.gcdSubtraction(a,b));
    }

    @Test
    public void test2() {
        int a = 625, b = 250;
        System.out.println(s.gcdDivision(a,b));
    }

    @Test
    public void test3() {
        int a = 625, b = 250;
        System.out.println(s.gcdBinary(a, b, 1));
    }
    @Test
    public void testLarge() {
        int a = (int)(Math.pow(3,9)*Math.pow(2,14)), b=(int)(Math.pow(2,14)*Math.pow(2,14));
        System.out.println(a);
        System.out.println(s.gcdBinary(a, b, 1));
    }
}
