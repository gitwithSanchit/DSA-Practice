package Sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

public class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] expected = Arrays.copyOf(heights, heights.length);

        Arrays.sort(heights);
        int count = 0;

        for (int i = 0; i < expected.length; i++) {
            if (expected[i] != heights[i]) {
                count++;
            }
        }
        return count;
    }
}
