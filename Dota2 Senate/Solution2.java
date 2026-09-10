class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        boolean[] deleted = new boolean[n];

        int rCount = 0;
        int dCount = 0;

        for(char ch: senate.toCharArray()) {
            if(ch == 'R') {
                rCount++;
            } else {
                dCount++;
            }
        }

        int idx = 0;

        while(rCount > 0 && dCount > 0) {
            if(deleted[idx] == false) {
                if(senate.charAt(idx) == 'R') {
                    remove(senate, deleted, 'D', (idx + 1) % n);
                    dCount--;
                } else {
                    remove(senate, deleted, 'R', (idx + 1) % n);
                    rCount--;
                }
            }

            idx = (idx + 1) % n;
        }

        return rCount == 0? "Dire": "Radiant";
    }

    private void remove(String s, boolean[] v, char ch, int i) {
        while(true) {
            if(s.charAt(i) == ch && v[i] == false) {
                v[i] = true;
                break;
            }

            i = (i + 1) % s.length();
        }
    }
}
