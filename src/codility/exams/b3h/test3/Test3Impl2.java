package codility.exams.b3h.test3;

import java.util.*;

public class Test3Impl2 implements ITest3 {
    @Override
    public int solution(int[] A, int[] B) {
        // the default return value, while Rome is not founded.
        int rtn = -1;

        // Cities<number: City Number, preCities: Neighboring and Unordered>
        HashMap<Integer, ArrayList> cities = new HashMap();
        // create map  all cities
        // O(N)
        for (int i = 0; i < A.length; i++) {
            if (cities.get(B[i]) == null) {
                cities.put(B[i], new ArrayList());
            }

            if (cities.get(A[i]) == null) {
                cities.put(A[i], new ArrayList());
            }

            // A[i] --> B[i]. A[i] is a pre City of B[i]
            ((ArrayList)cities.get(B[i])).add(A[i]);
        }

        // find Rome
        for (Map.Entry<Integer, ArrayList> entry : cities.entrySet()) {
            int currentCityCode = entry.getKey();

            // reachableCities<Integer: City number>
            Set<Integer> reachableCities = new HashSet();
            getReachableCities(currentCityCode, reachableCities, cities);

            if (reachableCities.size() >= cities.size() - 1) {
                // Congratulations, there is Rome
                rtn = currentCityCode;
                break;
            }
        }

        return rtn;
    }

    /*
     * getReachableCities
     * params:
     *   currentCityCode: The city which we are finding all reachable cities for.
     *   reachableCities: All reachable city from current city
     *   cities: All cities
     */
    private void getReachableCities(int currentCityCode, Set reachableCities, HashMap cities) {
        ArrayList currentCity = (ArrayList)cities.get(currentCityCode);
        for (int k = 0; k < currentCity.size(); k++) {
            int preC = (Integer) currentCity.get(k);

            // skip if circle
            if (reachableCities.add(preC))
                getReachableCities(preC, reachableCities, cities);
        }
    }
}
