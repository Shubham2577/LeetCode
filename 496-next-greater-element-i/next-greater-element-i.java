class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {

            // Find nums1[i] in nums2
            int index = 0;

            while (nums2[index] != nums1[i]) {
                index++;
            }

            // Find next greater element
            ans[i] = -1;

            for (int j = index + 1; j < nums2.length; j++) {

                if (nums2[j] > nums1[i]) {
                    ans[i] = nums2[j];
                    break;
                }
            }
        }

        return ans;
    }
}