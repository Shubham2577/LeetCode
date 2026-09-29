class Solution {
    public int removePalindromeSub(String s) {

        int i = 0;
        int e = s.length() - 1;

        while (i < e) {
            if (s.charAt(i) != s.charAt(e)) {
                return 2;
            }

            i++;
            e--;
        }

        return 1;
    }
}