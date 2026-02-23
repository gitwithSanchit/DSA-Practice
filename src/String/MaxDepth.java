package String;

public class MaxDepth {
    public int maxDepth(String s) {
        char[] arr = s.toCharArray();

        int depth = 0;
        int maxDepth = 0;

        for (char c : arr) {
            if (c == '(') depth++;

            if (depth > maxDepth) maxDepth = depth;

            if (c == ')') depth--;
        }
        return maxDepth;
    }
}
