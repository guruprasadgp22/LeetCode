class Solution {
    public int countPairs(int[] nums, int k) {
        int n = nums.length;
        int result = 0;

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            map.computeIfAbsent(nums[i], j -> new ArrayList<>()).add(i);
        }

        HashSet<Integer> div = new HashSet<>();
        for(int i=1;i*i<=k;i++) {
            if(k%i == 0) {
                div.add(i);
                div.add(k/i);
            }
        }

        for(ArrayList<Integer> indices: map.values()) {
            HashMap<Integer, Integer> factors = new HashMap<>();
            for(int i: indices) {
                int GCD = gcd(i, k);
                int j = k/GCD;

                result += factors.getOrDefault(j, 0);

                for(int f: div) {
                    if(i%f == 0) {
                        factors.put(f, factors.getOrDefault(f, 0) + 1);
                    }
                }
            }
        }

        return result;
    }

    private int gcd(int a, int b){
        while(b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
