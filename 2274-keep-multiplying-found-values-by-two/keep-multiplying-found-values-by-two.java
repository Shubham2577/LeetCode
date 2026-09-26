class Solution {
    public int findFinalValue(int[] nums, int original) {

        
        for(int i=0 ; i<nums.length ; i++)
        {
            for(int j=0 ; j<nums.length ; j++)
            {
                if(nums[j] == original)
                 {
                     original = original * 2;
                 }
            }
        }
        
        return original;
    }
}