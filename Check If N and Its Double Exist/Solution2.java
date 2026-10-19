class Solution {
    public boolean checkIfExist(int[] arr) {
        boolean[] seen = new boolean[4001];
        for(int ele: arr) {
            if(seen[2000+ele*2] || (ele % 2 == 0 && seen[ele/2 + 2000])) {
                return true;
            }

            seen[2000+ele] = true;
        }

        return false;
    }
}
