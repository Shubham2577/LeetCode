import java.util.*;

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        int n = difficulty.length;

        // Store difficulty and profit together
        int[][] jobs = new int[n][2];

        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }

        // Sort jobs by difficulty
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        // Sort workers by ability
        Arrays.sort(worker);

        int j = 0;
        int maxProfit = 0;
        int totalProfit = 0;

        for (int ability : worker) {

            // Find all jobs this worker can do
            while (j < n && jobs[j][0] <= ability) {
                maxProfit = Math.max(maxProfit, jobs[j][1]);
                j++;
            }

            // Give worker the best available job
            totalProfit += maxProfit;
        }

        return totalProfit;
    }
}