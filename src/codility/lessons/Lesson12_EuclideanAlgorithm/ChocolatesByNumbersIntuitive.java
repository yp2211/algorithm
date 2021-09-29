package codility.lessons.Lesson12_EuclideanAlgorithm;

public class ChocolatesByNumbersIntuitive {
    /*
     * N and M are integers within the range [1..1,000,000,000].
     */
    public int solution(int N, int M) {
        java.util.Set<java.math.BigInteger> wrappers = new java.util.HashSet<>();
        java.math.BigInteger i = java.math.BigInteger.valueOf(0);
        java.math.BigInteger wrapper = java.math.BigInteger.valueOf(0);
        java.math.BigInteger bigM = java.math.BigInteger.valueOf(M);
        java.math.BigInteger bigN = java.math.BigInteger.valueOf(N);
        while (wrappers.add(wrapper)) {
            i = i.add(java.math.BigInteger.valueOf(1));
            wrapper = (i.multiply(bigM)).mod(bigN);
        }

        return wrappers.size();
    }
}
