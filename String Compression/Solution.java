class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int read = 0;
        int write = 0;

        while(read < n) {
            char curr = chars[read];
            int count = 0;
            while(read < n && curr == chars[read]) {
                read++;
                count++;
            }

            chars[write++] = curr;

            if(count > 1) {
                for(char ch: String.valueOf(count).toCharArray()) {
                    chars[write++] = ch;
                }
            }
        }

        return write;
    }
}
