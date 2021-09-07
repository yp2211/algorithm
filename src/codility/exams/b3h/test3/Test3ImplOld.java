package codility.exams.b3h.test3;

import java.util.LinkedList;
import java.util.List;

public class Test3ImplOld implements ITest3 {
    @Override
    public int solution(int[] A, int[] B) {
        // write your code in Java SE 11
        int rtn = -1;

        // ***condition***: City Number is consecutive positive integers starting from 0.
        List<Integer>[] cities = new List[2 * A.length];
        int n = 0;
        // create the list of all cities
        // O(N)
        for (int i = 0; i < A.length; i++) {
            if (cities[B[i]] == null) {
                cities[B[i]] = new LinkedList();
                n += 1;
            }

            if (cities[A[i]] == null) {
                cities[A[i]] = new LinkedList();
                n += 1;
            }

            // A[i] --> B[i]. A[i] is a pre City of B[i]
            cities[B[i]].add(A[i]);
        }
        System.out.println("Total Cities: " + n);
        // create map
        boolean[] arrivableCities;
        for (int j = 0; j < n; j++) {
            List currentCity = cities[j];
            arrivableCities = new boolean[n];
            getArrivableCities(currentCity, arrivableCities, cities);

            boolean isRome = true;
            for (int k = 0; k < n; k++) {
                if (!arrivableCities[k] && k != j) {
                    isRome = false;
                    break;
                }
            }
            if (isRome) {
                rtn = j;
                break;
            }
        }

        System.out.println(rtn);
        return rtn;
    }

    private void getArrivableCities(List currentCity, boolean[] arrivableCities, List<Integer>[] cities) {
        for (int k = 0; k < currentCity.size(); k++) {
            int preC = (Integer) currentCity.get(k);
            if (arrivableCities[preC] == true)
                // skip if circle
                continue;
            else
                arrivableCities[preC] = true;

            if (cities[preC] != null) {
                getArrivableCities(cities[preC], arrivableCities, cities);
            }
        }
    }
}
