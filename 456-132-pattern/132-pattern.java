class Solution {
    public boolean find132pattern(int[] nums) {

        int n = nums.length;

        int second = Integer.MIN_VALUE;

        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            // nums[i] can be the "1"
            if (nums[i] < second) {
                return true;
            }

            // Find a possible "2"
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                second = stack.pop();
            }

            stack.push(nums[i]);
        }

        return false;
    }
}