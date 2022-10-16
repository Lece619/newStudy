package basic2;

import java.util.Collections;
import java.util.HashMap;

public class MinDifference {
    public int solution(int[] array, int n) {

        HashMap<Integer, Integer> difIdx = new HashMap<>();

        for (int i : array) {
            int dif = Math.abs(n - i);
            difIdx.put(dif, Math.min(difIdx.getOrDefault(dif, i), i));
        }

        return difIdx.get(Collections.min(difIdx.keySet()));
    }
}
