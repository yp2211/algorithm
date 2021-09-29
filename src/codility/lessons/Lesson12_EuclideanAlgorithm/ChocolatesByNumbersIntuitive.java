package codility.lessons.Lesson12_EuclideanAlgorithm;

public class ChocolatesByNumbersIntuitive {
    public int solution(int N, int M) {
        int maxChocolates = 0;

        for (int i = 0; i < N; i++) {
            java.util.Set<Integer> wrappers = new java.util.HashSet<>();
            int j = 0;
            int wrapper = i;
            while (wrappers.add(wrapper)) {
                j += 1;
                wrapper = (i + j*M) % N;
            }
            maxChocolates = Math.max(maxChocolates, wrappers.size());
        }
        return maxChocolates;
    }
}
