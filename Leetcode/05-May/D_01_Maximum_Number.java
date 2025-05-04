import java.util.Arrays;
import java.util.TreeMap;

public class D_01_Maximum_Number {

    /*
    Problem: Maximum Number of Tasks You Can Assign
    
    You have n tasks and m workers. Each task has a strength requirement stored in a 0-indexed integer array tasks,
    with the ith task requiring tasks[i] strength to complete. The strength of each worker is stored in a 0-indexed 
    integer array workers, with the jth worker having workers[j] strength. Each worker can only be assigned to a single 
    task and must have a strength greater than or equal to the task's strength requirement (i.e., workers[j] >= tasks[i]).
    
    Additionally, you have magical pills that will increase a worker's strength by a given amount. You can decide which 
    workers receive the magical pills, however, you may only give each worker at most one magical pill.
    
    Given the 0-indexed integer arrays tasks and workers and the integers pills and strength, return the maximum 
    number of tasks that can be completed.
    */

    public static void main(String[] args) {
        D_01_Maximum_Number solution = new D_01_Maximum_Number();

        // Example 1
        int[] tasks1 = {3, 2, 1};
        int[] workers1 = {0, 3, 3};
        int pills1 = 1;
        int strength1 = 1;
        System.out.println(solution.maxTaskAssign(tasks1, workers1, pills1, strength1)); // Output: 3

        // Example 2
        int[] tasks2 = {5, 4};
        int[] workers2 = {0, 0, 0};
        int pills2 = 1;
        int strength2 = 5;
        System.out.println(solution.maxTaskAssign(tasks2, workers2, pills2, strength2)); // Output: 1

        // Example 3
        int[] tasks3 = {10, 15, 30};
        int[] workers3 = {0, 10, 10, 10, 10};
        int pills3 = 3;
        int strength3 = 10;
        System.out.println(solution.maxTaskAssign(tasks3, workers3, pills3, strength3)); // Output: 2
    }

    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int n = tasks.length, m = workers.length;
        int left = 1, right = Math.min(m, n), ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(tasks, workers, pills, strength, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private boolean check(int[] tasks, int[] workers, int pills, int strength, int mid) {
        int p = pills;
        TreeMap<Integer, Integer> ws = new TreeMap<>();
        for (int i = workers.length - mid; i < workers.length; ++i) {
            ws.put(workers[i], ws.getOrDefault(workers[i], 0) + 1);
        }

        for (int i = mid - 1; i >= 0; --i) {
            Integer key = ws.lastKey();
            if (key >= tasks[i]) {
                ws.put(key, ws.get(key) - 1);
                if (ws.get(key) == 0) {
                    ws.remove(key);
                }
            } else {
                if (p == 0) {
                    return false;
                }
                key = ws.ceilingKey(tasks[i] - strength);
                if (key == null) {
                    return false;
                }
                ws.put(key, ws.get(key) - 1);
                if (ws.get(key) == 0) {
                    ws.remove(key);
                }
                --p;
            }
        }
        return true;
    }
}
