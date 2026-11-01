
import java.util.*;

class Solution {

    public List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> result = new ArrayList<>();

        // Store word -> index
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {

            String word = words[i];
            int len = word.length();

            for (int j = 0; j <= len; j++) {

                String left = word.substring(0, j);
                String right = word.substring(j);

                // Case 1: Left part is palindrome
                if (isPalindrome(left)) {

                    String reverseRight =
                            new StringBuilder(right).reverse().toString();

                    if (map.containsKey(reverseRight)) {

                        int index = map.get(reverseRight);

                        if (index != i) {
                            result.add(Arrays.asList(index, i));
                        }
                    }
                }

                // Case 2: Right part is palindrome
                // j < len avoids duplicate pairs
                if (j != len && isPalindrome(right)) {

                    String reverseLeft =
                            new StringBuilder(left).reverse().toString();

                    if (map.containsKey(reverseLeft)) {

                        int index = map.get(reverseLeft);

                        if (index != i) {
                            result.add(Arrays.asList(i, index));
                        }
                    }
                }
            }
        }

        return result;
    }

    private boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
