
import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> result = new ArrayList<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0] + a[1], b[0] + b[1])
        );

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }

        while (k > 0 && !pq.isEmpty()) {
            int[] curr = pq.poll();

            result.add(Arrays.asList(curr[0], curr[1]));

            int nextIndex = curr[2] + 1;

            if (nextIndex < nums2.length) {
                pq.offer(new int[]{
                    curr[0],
                    nums2[nextIndex],
                    nextIndex
                });
            }

            k--;
        }

        return result;
    }
}
