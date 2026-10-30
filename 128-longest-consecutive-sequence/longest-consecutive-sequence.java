import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        // Step 1: Add all elements into HashSet
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        // Step 2: Iterate through HashSet
        for (int num : set) {

            // Step 3: Check if num is the starting point
            if (!set.contains(num - 1)) {

                int currentNum = num;
                int count = 1;

                // Step 4: Find consecutive numbers
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}