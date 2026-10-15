
class Solution {
    public int minimumPairRemoval(int[] nums) {
        int count = 0;
        java.util.List<Integer> list = new java.util.ArrayList<>();

        for (int n : nums) {
            list.add(n);
        }

        while (true) {
            boolean sorted = true;

            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) < list.get(i - 1)) {
                    sorted = false;
                    break;
                }
            }

            if (sorted) {
                return count;
            }

            int minSum = Integer.MAX_VALUE;
            int index = 0;

            for (int i = 0; i < list.size() - 1; i++) {
                int sum = list.get(i) + list.get(i + 1);

                if (sum < minSum) {
                    minSum = sum;
                    index = i;
                }
            }

            list.set(index, minSum);
            list.remove(index + 1);
            count++;
        }
    }
}
