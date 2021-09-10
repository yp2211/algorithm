package codility.exams.abrfrb674.test2;

import java.util.HashSet;

public class Test2Impl implements ITest2{

    @Override
    public String solution(String S) {
        java.util.Set container = new HashSet();
        for (char c : S.toCharArray()) {
            if (!container.add(c)) {
                return String.valueOf(c);
            }
        }
        return null;
    }
}
