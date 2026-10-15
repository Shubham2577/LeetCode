class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        boolean[] visited = new boolean[26];
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (char c : s.toCharArray()) {
            freq[c - 'a']--;

            if (visited[c - 'a']) continue;

            while (!st.isEmpty() && st.peek() > c
                    && freq[st.peek() - 'a'] > 0) {
                visited[st.pop() - 'a'] = false;
            }

            st.push(c);
            visited[c - 'a'] = true;
        }

        StringBuilder ans = new StringBuilder();
        for (char c : st) ans.append(c);

        return ans.toString();
    }
}