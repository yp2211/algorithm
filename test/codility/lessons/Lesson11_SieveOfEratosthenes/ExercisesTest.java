package codility.lessons.Lesson11_SieveOfEratosthenes;


import org.junit.jupiter.api.Test;

public class ExercisesTest {
    Lesson11Exercises s = new Lesson11Exercises();
    @Test
    public void sieveTest() {
        int N = 17;
        boolean[] actual = s.sieve(N);
        String[] result = new String[actual.length];
        String[] number = new String[actual.length];
        for (int i = 0; i < actual.length; i++) {
            result[i] = String.valueOf(actual[i]);
            number[i] = String.format("%0"+result[i].length()+"d", i);
        }
        System.out.println(java.util.Arrays.toString(number));
        System.out.println(java.util.Arrays.toString(result));
    }

    @Test
    public void factorizationTest() {
        int N = 26;
        String[] numbers = new String[N+1];
        for (int i = 0; i <= N; i++) {
            numbers[i] = i + "";
        }
        System.out.println(java.util.Arrays.toString(numbers));
        System.out.println(java.util.Arrays.toString(s.factorization(N)));
    }

    @Test
    public void factorizationTest2() {
        int N = 224;
        String[] numbers = new String[N+1];
        for (int i = 0; i <= N; i++) {
            numbers[i] = i + "";
        }
        System.out.println(java.util.Arrays.toString(numbers));
        System.out.println(java.util.Arrays.toString(s.factorization(N)));
    }

    @Test
    public void factorizationXTest() {
        int N = 26;
        String[] numbers = new String[N+1];
        for (int i = 0; i <= N; i++) {
            numbers[i] = i + "";
        }
        System.out.println(java.util.Arrays.toString(numbers));

        int[] F = s.factorization(N);
        int x = 26;

        System.out.println(java.util.Arrays.toString(s.factorizationX(x, F)));
    }

    @Test
    public void factorizationXTest2() {
        int N = 26;
        String[] numbers = new String[N+1];
        for (int i = 0; i <= N; i++) {
            numbers[i] = i + "";
        }
        System.out.println(java.util.Arrays.toString(numbers));

        int[] F = s.factorization(N);
        int x = 11;
        System.out.println(java.util.Arrays.toString(F));
        System.out.println(java.util.Arrays.toString(s.factorizationX(x, F)));
    }

    @Test
    public void factorizationTestMaxSize() {
        int N = 50000;
        System.out.println(java.util.Arrays.toString(s.factorization(N)));
    }

}
