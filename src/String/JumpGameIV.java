package String;

public class JumpGameIV {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] dp = new boolean[n];
        dp[0] = true;
        int reachableCount = 0;

        for (int i = 1; i < n; i++) {
            if (i - minJump >= 0 && dp[i - minJump]) {
                reachableCount++;
            }

            if (i - maxJump - 1 >= 0 && dp[i - maxJump - 1]) {
                reachableCount--;
            }

            dp[i] = (s.charAt(i) == '0' && reachableCount > 0);
        }

        return dp[n-1];
    }

    //More optimized sol
    public boolean canReach1(String temp, int minJump, int maxJump) {
        int n = temp.length();
        char[] s = temp.toCharArray();
        if (s[0] != '0' || s[n - 1] != '0') return false;

        boolean[] dp = new boolean[n];
        dp[0] = true;
        int count = 0;

        for (int i = 1; i < n; i++) {
            if (i - minJump >= 0 && dp[i - minJump]) count++;
            if (i - maxJump - 1 >= 0 && dp[i - maxJump - 1]) count--;
            dp[i] = s[i] == '0' && count > 0;
        }

        return dp[n - 1];
    }
}
