class Solution {
    public int[] searchRange(int[] nums, int target) {

        int s = 0;
        int e = nums.length - 1;

        int first = -1;
        int last = -1;

        // Find first occurrence
        while (s <= e) {

            int mid = s + (e - s) / 2;

            if (nums[mid] == target) {
                first = mid;
                e = mid - 1;
            }
            else if (nums[mid] < target) {
                s = mid + 1;
            }
            else {
                e = mid - 1;
            }
        }

        // Reset for finding last occurrence
        s = 0;
        e = nums.length - 1;

        // Find last occurrence
        while (s <= e) {

            int mid = s + (e - s) / 2;

            if (nums[mid] == target) {
                last = mid;
                s = mid + 1;
            }
            else if (nums[mid] < target) {
                s = mid + 1;
            }
            else {
                e = mid - 1;
            }
        }

        return new int[]{first, last};
    }
}