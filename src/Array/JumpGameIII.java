package Array;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGameIII {

    //BFS method
    public boolean canReach1(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {

            int i = q.poll();

            if (arr[i] == 0) return true;

            int left = i - arr[i];
            int right = i + arr[i];

            if (left >= 0 && !visited[left]) {
                visited[left] = true;
                q.add(left);
            }

            if (right < arr.length && !visited[right]) {
                visited[left] = true;
                q.add(left);
            }
        }

        return false;
    }


    // DFS (recursive method)
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return canReach(arr, start, visited);
    }

    private boolean canReach(int[] arr, int i, boolean[] visited) {
        if (i < 0 || i >= arr.length) {
            return false;
        }
        if (visited[i]) {
            return false;
        }
        if (arr[i] == 0) {
            return true;
        }
        visited[i] = true;

        return canReach(arr, i + arr[i], visited) || canReach(arr, i - arr[i], visited);
    }
}
