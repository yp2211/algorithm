package codility.exams.abrfrb674.test1;

public class Test1Impl implements ITest1 {

    @Override
    public int solution(int A) {
        char[] chrA = (A + "").toCharArray();
        int frontPoint = 0;
        int postPoint = chrA.length - 1;
        char[] result = new char[chrA.length];
        int i = 0;
        while (frontPoint < postPoint) {
            result[i++] = chrA[frontPoint++];
            result[i++] = chrA[postPoint--];
        }
        if (frontPoint == postPoint) {
            result[result.length - 1] = chrA[frontPoint];
        }
        return Integer.parseInt(String.valueOf(result));
    }
}
