package String;

public class GoalParser {
    public String interpret(String command) {
        char[] arr = command.toCharArray();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'G') {
                result.append("G");
            } else if (arr[i] == '(') {
                if (arr[i + 1] == ')') {
                    result.append("o");
                    i++;
                }else {
                    result.append("al");
                    i += 3;
                }
            }
        }
        return result.toString();
    }
}
