
class Solution {
    public int firstUniqueEven(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            // Check only even numbers
            if (nums[i] % 2 != 0) {
                continue;
            }

            int cnt = 0;

            // Count frequency of nums[i]
            for (int k = 0; k < nums.length; k++) {
                if (nums[i] == nums[k]) {
                    cnt++;
                }
            }

            // Return the first even number appearing once
            if (cnt == 1) {
                return nums[i];
            }
        }

        return -1;
    }
}
