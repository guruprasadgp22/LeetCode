class Node {
	long score;
	int[] idx;
	
	Node(long score, int[] indexes) {
		 this.score = score;
		 this.idx = indexes;
	}
}

class Solution {
    int n;
	int nextIdx[];
    Node[][] dp;
    public int[] maximumWeight(List<List<Integer>> intervals) {
    	n = intervals.size();
    	
    	for(int i=0;i<n;i++) {
    		intervals.get(i).add(i);
    	}
    	
        intervals.sort((a, b) -> {
        	return a.get(0) - b.get(0);
        }); 
        
        nextIdx = new int[n];
        for(int i=0;i<n;i++) {
        	int endPoint = intervals.get(i).get(1);
        	nextIdx[i] = binarySearch(intervals, endPoint);
        }
        
        int k = 4;
        
        dp = new Node[n+1][k+1];

        return solve(intervals, 0, k).idx;
    }
    
    private Node solve(List<List<Integer>> intervals, int idx, int k) {
    	if(k == 0 || idx >= n) {
    		return new Node(0, new int[]{});
    	}

        if(dp[idx][k] != null) {
            return dp[idx][k];
        }
    	
    	Node skip = solve(intervals, idx + 1, k);
    	
    	int weight = intervals.get(idx).get(2);
    	int originalIdx = intervals.get(idx).get(3);
    	int j = nextIdx[idx];
    	
    	Node temp = solve(intervals, j, k-1);
    	
    	long score = temp.score + weight;
    	int[] index = new int[temp.idx.length+1];
    	System.arraycopy(temp.idx, 0, index, 0, temp.idx.length);
    	index[temp.idx.length] = originalIdx;
    	
    	Arrays.sort(index);
    	
    	Node take = new Node(score, index);
    	
    	Node best = new Node(0, new int[]{});
    	
    	if(skip.score > take.score) {
    		best = skip;
    	} else if(skip.score < take.score) {
    		best = take;
    	} else {
    		best = lexicographically(take.idx, skip.idx)? take: skip ;
    	}
    	
    	return dp[idx][k] = best;
    }
    
    private boolean lexicographically(int[] a, int[] b) {
    	int len = Math.min(a.length, b.length);
    	
    	for(int i=0;i<len;i++) {
    		if(a[i] != b[i]) {
    			return a[i] < b[i];
    		}
    	}
    	
    	return a.length < b.length;
    }
    
    int binarySearch(List<List<Integer>> intervals, int endPoint) {
    	int left = 0;
    	int right = intervals.size() - 1;
    	
    	int result = intervals.size();
    	
    	while(left <= right) {
    		int mid = left + (right - left)/2;
    		
    		if(intervals.get(mid).get(0) > endPoint) {
    			result = mid;
    			right = mid - 1;
    		} else {
    			left = mid + 1;
    		}
    	}
    	
    	return result;
    }
}
