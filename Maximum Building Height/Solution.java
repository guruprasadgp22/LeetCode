class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        List<List<Integer>> arr = new ArrayList<>();
        arr.addLast(new ArrayList<>(Arrays.asList(1, 0)));
        
        for(int[] ele: restrictions) {
        	arr.addLast(new ArrayList<>(Arrays.asList(ele[0], ele[1])));
        }
        
        arr.addLast(new ArrayList<>(Arrays.asList(n, Integer.MAX_VALUE)));
        arr.sort((a, b) -> {
        	return a.get(0) - b.get(0);
        });
        
        int m = arr.size();
        for(int i=1;i<m;i++) {
        	int distance = arr.get(i).get(0) - arr.get(i-1).get(0);
        	int min = Math.min(distance + arr.get(i-1).get(1), arr.get(i).get(1));
        	arr.set(i, new ArrayList<>(Arrays.asList(arr.get(i).get(0), min)));
        }
        
        for(int i=m-2;i>=0;i--) {
        	int distance = arr.get(i+1).get(0) - arr.get(i).get(0);
        	int min = Math.min(distance + arr.get(i+1).get(1), arr.get(i).get(1));
        	arr.set(i, new ArrayList<>(Arrays.asList(arr.get(i).get(0), min)));
        }
        
        int ans = 0;
        for(int i=1;i<m;i++) {
        	int d = arr.get(i).get(0) - arr.get(i-1).get(0);
        	ans = Math.max(ans, (arr.get(i-1).get(1) + arr.get(i).get(1) + d)/2);
        }
        
        return ans;
    }
}
