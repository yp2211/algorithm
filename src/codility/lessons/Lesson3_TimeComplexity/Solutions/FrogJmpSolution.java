package codility.lessons.Lesson3_TimeComplexity.Solutions;

import codility.lessons.Lesson3_TimeComplexity.IFrogJmp;

/**
 * Created by peng.yang on ${Date}
 */
public class FrogJmpSolution implements IFrogJmp {

    @Override
    public int solution(int X, int Y, int D) {
        return (int) Math.ceil ((double) (Y - X) / D);
    }
}
