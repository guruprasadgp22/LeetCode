class Solution {
    public String predictPartyVictory(String senate) {
        int rCount = 0;
        int dCount = 0;

        for(char ch: senate.toCharArray()) {
            if(ch == 'R') {
                rCount++;
            } else {
                dCount++;
            }
        }

        StringBuilder curr = new StringBuilder(senate);
        int idx = 0;

        while(rCount > 0 && dCount > 0) {
            if(curr.charAt(idx) == 'R') {
                boolean checkRemovalLeftSide = remove(curr, 'D', (idx + 1) % curr.length());
                dCount--;

                if(checkRemovalLeftSide) {
                    idx--;
                }
            } else {
                boolean checkRemovalLeftSide = remove(curr, 'R', (idx + 1) % curr.length());
                rCount--;

                if(checkRemovalLeftSide) {
                    idx--;
                }
            }

            idx = (idx + 1) % curr.length();
        }

        return rCount == 0? "Dire": "Radiant";
    }

    private boolean remove(StringBuilder curr, char ch, int idx) {
        boolean check = false;

        while(true) {
            if(idx == 0) {
                check = true;
            }

            if(curr.charAt(idx) == ch) {
                curr.deleteCharAt(idx);
                break;
            }

            idx = (idx + 1) % curr.length();
        }   

        return check;
    }
}
