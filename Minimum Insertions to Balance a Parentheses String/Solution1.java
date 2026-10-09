class Solution {
    public int minInsertions(String s) {
        int res = 0;
        int need = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                need += 2;
                if(need % 2 != 0) {
                    res++;
                    need--;
                }
            } else {
                need--;
                if(need < 0) {
                    res++;
                    need += 2;
                }
            }
        }

        return need+res;
    }
}
