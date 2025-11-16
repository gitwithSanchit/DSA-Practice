package Sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayRankTransform {
    public int[] arrayRankTransform(int[] arr) {
        int[] result = new int[arr.length];

        int[] numb = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr);

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;

        for (int num : arr) {
            if (!map.containsKey(num)) {
                map.put(num, rank);
                rank++;
            }
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = map.get(numb[i]);
        }

        return result;
    }
}
