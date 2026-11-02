class Solution {
    public int compress(char[] chars) {

        int write = 0;
        int read = 0;

        while (read < chars.length) {

            char current = chars[read];
            int count = 0;

            // Count consecutive repeating characters
            while (read < chars.length &&
                   chars[read] == current) {

                read++;
                count++;
            }

            // Write the character
            chars[write++] = current;

            // Write count only if greater than 1
            if (count > 1) {

                for (char digit : String.valueOf(count).toCharArray()) {
                    chars[write++] = digit;
                }
            }
        }

        return write;
    }
}