class SegmentTree {
	int n;
	int maxValues[];
	int minValues[];
	
	SegmentTree(int n) {
		this.n = n;
		minValues = new int[4*n];
		maxValues = new int[4*n];
	}
	
	void insert(int index, int val) {
		insert(1, 0, n-1, index, val);
	}

	void insert(int node, int low, int high, int index, int val) {
		if(low == high) {
			minValues[node] = val;
			maxValues[node] = val;
			return;
		}
		
		int mid = low + (high - low)/2;
		if(index <= mid) {
			insert(2*node, low, mid, index, val);
		} else {
			insert(2*node+1, mid+1, high, index, val);
		}
		
		maxValues[node] = Math.max(maxValues[2*node], maxValues[2*node+1]);
		minValues[node] = Math.min(minValues[2*node], minValues[2*node+1]);
	}
	
	int[] query(int low, int high) {
		return query(1, 0, n-1, low, high);
	}
	
	int[] query(int node, int initialRangeLow, int initialRangeHigh, int low, int high) {
		if(high < initialRangeLow || low > initialRangeHigh) {
			return new int[] {
					Integer.MAX_VALUE, Integer.MIN_VALUE
			};
		}
		
		if(low <= initialRangeLow && initialRangeHigh <= high) {
			return new int[] {
					minValues[node], maxValues[node]
			};
		}
			
		int mid = initialRangeLow + (initialRangeHigh - initialRangeLow)/2;
		int left[] = query(2*node, initialRangeLow, mid, low, high);
		int right[] = query(2*node+1, mid+1, initialRangeHigh, low, high);
		int currMin = Math.min(left[0], right[0]);
		int currMax = Math.max(left[1], right[1]);
			
		return new int[] {
				currMin, currMax
		};	
	}
}

class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        
        SegmentTree segTree = new SegmentTree(n);
        for(int i=0;i<n;i++) {
        	segTree.insert(i, nums[i]);
        }
        
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> Long.compare(b[0], a[0]));
        
        int[] ansVal = segTree.query(0, n-1);
        pq.offer(new long[] {
        		ansVal[1] - ansVal[0], 0, n-1
        });
        
        HashSet<String> visited = new HashSet<>();
        visited.add(0 + "#" + (n-1));
        
        long ans = 0;
        
        while(k > 0 && !pq.isEmpty()) {
        	long[] curr = pq.poll();
        	ans += curr[0];
        	k--;
        	
        	int l = (int)curr[1];
        	int r = (int)curr[2];
        	
        	if(l+1 <= r && !visited.contains((l+1) + "#" + r)) {
        		int[] val = segTree.query(l+1, r);
        		visited.add((l+1) + "#" + r);
        		pq.offer(new long[] {
        			val[1] - val[0], l+1, r	
        		});
        	}
        	
        	if(l <= r-1 && !visited.contains(l + "#" + (r-1))) {
        		int[] val = segTree.query(l, r-1);
        		visited.add(l + "#" + (r-1));
        		pq.offer(new long[] {
        			val[1] - val[0], l, r-1	
        		});
        	}
        }
        
        return ans;
    }
}
