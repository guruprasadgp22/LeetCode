class Solution {
    public int findKthPositive(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int ele: arr) {
            set.add(ele);
        }
        int n = arr.length + k;
        for(int i=1;i<=n;i++) {
            if(!set.contains(i)) {
                System.out.println(i);
                k--;
                if(k == 0) {
                    return i;
                }
            }
        }
        return -1;
    }
}
