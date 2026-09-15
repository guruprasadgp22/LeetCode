class Node {
	long score;
	int[] idx;
	
	Node(long score, int[] indexes) {
		 this.score = score;
		 this.idx = indexes;
	}
}

class Solution {
       public int[] maximumWeight(List<List<Integer>> intervals) {
    	int n = intervals.size();
    	
    	for(int i=0;i<n;i++) {
    		intervals.get(i).add(i);
    	}
    	
        intervals.sort((a, b) -> {
        	return a.get(0) - b.get(0);
        }); 
        
        int nextIdx[] = new int[n];
        for(int i=0;i<n;i++) {
        	int endPoint = intervals.get(i).get(1);
        	nextIdx[i] = binarySearch(intervals, endPoint);
        }
        
        Node[][] dp = new Node[n+1][5];
        
        for(int i=0;i<=n;i++) {
        	for(int k=0;k<=4;k++) {
        		if(i==n || k== 0) {
        			dp[i][k] = new Node(0, new int[] {});
        		}
        	}
        }
        
        for(int idx = n-1;idx>=0;idx--) {
        	int weight = intervals.get(idx).get(2);
        	int originalIdx = intervals.get(idx).get(3);
        	int j = nextIdx[idx];
        	
        	for(int k=1;k<=4;k++) {
        		Node skip = dp[idx+1][k];
        		
        		Node temp = dp[j][k-1];
        		
        		long score = temp.score + weight;
            	int[] index = new int[temp.idx.length+1];
            	System.arraycopy(temp.idx, 0, index, 0, temp.idx.length);
            	index[temp.idx.length] = originalIdx;
            	
            	Arrays.sort(index);
            	
            	Node take = new Node(score, index);
            	
            	Node best;
            	
            	if(skip.score > take.score) {
            		best = skip;
            	} else if(skip.score < take.score) {
            		best = take;
            	} else {
            		best = lexicographically(take.idx, skip.idx)? take: skip ;
            	}
            	
            	dp[idx][k] = best;
        	}
        }
        
        return dp[0][4].idx;
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
