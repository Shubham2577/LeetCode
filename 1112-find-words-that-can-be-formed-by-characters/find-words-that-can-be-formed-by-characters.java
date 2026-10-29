
class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] freq = new int[26];

        // Count characters in chars
        for (char ch : chars.toCharArray()) {
            freq[ch - 'a']++;
        }

        int sum = 0;

        for (String word : words) {
            int[] wordFreq = new int[26];

            // Count characters in the current word
            for (char ch : word.toCharArray()) {
                wordFreq[ch - 'a']++;
            }

            boolean good = true;

            // Check character availability
            for (int i = 0; i < 26; i++) {
                if (wordFreq[i] > freq[i]) {
                    good = false;
                    break;
                }
            }

            if (good) {
                sum += word.length();
            }
        }

        return sum;
    }
}
