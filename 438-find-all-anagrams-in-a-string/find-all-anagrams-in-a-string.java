
import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) {
            return result;
        }

        int[] sFreq = new int[26];
        int[] pFreq = new int[26];

        for (int i = 0; i < p.length(); i++) {
            sFreq[s.charAt(i) - 'a']++;
            pFreq[p.charAt(i) - 'a']++;
        }

        if (Arrays.equals(sFreq, pFreq)) {
            result.add(0);
        }

        for (int i = p.length(); i < s.length(); i++) {
            sFreq[s.charAt(i) - 'a']++;
            sFreq[s.charAt(i - p.length()) - 'a']--;

            if (Arrays.equals(sFreq, pFreq)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
}
