class Solution {
    public boolean isPathCrossing(String path) {
        HashSet<String> set = new HashSet<>();
        int x = 0;
        int y = 0;

        set.add(x + "," + y);

        for(char ch: path.toCharArray()) {
            if(ch == 'N') {
                y++;
            } else if(ch == 'S') {
                y--;
            } else if(ch == 'E') {
                x++;
            } else {
                x--;
            }
            
            String ans = x + "," + y;
            if(set.contains(ans)) {
                return true;
            }

            set.add(ans);
        }

        return false;
    }
}
