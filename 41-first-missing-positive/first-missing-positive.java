
class Solution {
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;

        // Step 1: Place each number at its correct index
        int i = 0;

        while (i < n) {

            int correctIndex = nums[i] - 1;

            if (nums[i] > 0 &&
                nums[i] <= n &&
                nums[i] != nums[correctIndex]) {

                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;

            } else {
                i++;
            }
        }

        // Step 2: Find the first missing positive
        for (int j = 0; j < n; j++) {

            if (nums[j] != j + 1) {
                return j + 1;
            }
        }

        // Step 3: All numbers from 1 to n exist
        return n + 1;
    }
}
