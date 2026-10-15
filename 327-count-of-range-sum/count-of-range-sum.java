
class Solution {
    int count = 0;

    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] prefix = new long[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        mergeSort(prefix, 0, prefix.length, lower, upper);
        return count;
    }

    private void mergeSort(long[] sum, int left, int right,
                           int lower, int upper) {
        if (right - left <= 1) return;

        int mid = left + (right - left) / 2;
        mergeSort(sum, left, mid, lower, upper);
        mergeSort(sum, mid, right, lower, upper);

        int low = mid, high = mid, j = mid;

        for (int i = left; i < mid; i++) {
            while (low < right && sum[low] - sum[i] < lower)
                low++;

            while (high < right && sum[high] - sum[i] <= upper)
                high++;

            count += high - low;
        }

        long[] temp = new long[right - left];
        int i = left, k = mid, p = 0;

        while (i < mid && k < right) {
            if (sum[i] <= sum[k])
                temp[p++] = sum[i++];
            else
                temp[p++] = sum[k++];
        }

        while (i < mid) temp[p++] = sum[i++];
        while (k < right) temp[p++] = sum[k++];

        for (int x = 0; x < temp.length; x++)
            sum[left + x] = temp[x];
    }
}
