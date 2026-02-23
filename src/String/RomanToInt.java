package String;

public class RomanToInt {
    public int romanToInt(String s) {

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            int curr = value(s.charAt(i));
            int next = (i + 1 < s.length()) ? value(s.charAt(i + 1)) : 0;

            if (next > curr) ans -= curr;
            ans+= curr;
        }
    return ans;
    }

    private int value(char c) {
        if(c == 'I') return 1;
        if(c == 'V') return 5;
        if(c == 'X') return 10;
        if(c == 'L') return 50;
        if(c == 'C') return 100;
        if(c == 'D') return 500;
        return 1000;

    }
}
