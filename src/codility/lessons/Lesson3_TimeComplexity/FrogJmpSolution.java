package codility.lessons.Lesson3_TimeComplexity;

/**
 * Created by peng.yang on ${Date}
 */
public class FrogJmpSolution extends AbstractFrogJmp {

    @Override
    public int solution(int X, int Y, int D) {
        return (int) Math.ceil ((double) (Y - X) / D);
    }
}
