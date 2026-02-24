package String;

//Brute force , Time : O(N^3);

public class beautySum {
    public int BeautySum(String s) {
        int beautySum = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                beautySum += beauty(s.substring(i, j + 1));
            }
        }
        return beautySum;
    }

    private int beauty(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        int max = 0, min = Integer.MAX_VALUE;

        for (int a : freq) {
            if (a > 0) {
                max = Math.max(max, a);
                min = Math.min(min, a);
            }
        }
        return max - min;
    }

    //More Optimal solution , Time : O(N^2);
    public int beautySum(String s) {
        int n = s.length();
        int total = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            for (int j = i; j < n; j++) {

                freq[s.charAt(j) - 'a']++;

                int max = 0, min = Integer.MAX_VALUE;
                for (int f : freq) {
                    if (f > 0) {
                        max = Math.max(max, f);
                        min = Math.min(min, f);
                    }
                }

                total += (max - min);
            }
        }
        return total;
    }
}