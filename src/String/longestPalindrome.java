package String;

//Brute force , Time : O(N^3);

public class longestPalindrome {
    public String LongestPalindrome(String s) {
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s, i, j)) {
                    String temp = s.substring(i, j + 1);
                    if (temp.length() > result.length()) {
                        result = temp;
                    }
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }

    //More Optimal solution , Time : O(N^2);
    public String longestPalindrome1(String s) {
        if (s.length() < 2) return s;

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {

            int len1 = expand(s , i, i);
            int len2 = expand(s , i, i+1);
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1)/2;
                end = i - len/2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expand(String s, int l, int r) {
        while( l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r-l-1;
    }
}
