
class Solution {
    public String removeDuplicates(String s) {

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            int n = ans.length();

            if (n > 0 && ans.charAt(n - 1) == ch) {
                ans.deleteCharAt(n - 1);
            } else {
                ans.append(ch);
            }
        }

        return ans.toString();
    }
}
