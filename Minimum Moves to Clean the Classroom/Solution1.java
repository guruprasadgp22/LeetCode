class state {
	int r;
	int c;
	int energyLeft;
	int collectedMask;
	
	state(int r, int c, int maxEnergy, int ltrCnt) {
		this.r = r;
		this.c = c;
		this.energyLeft = maxEnergy;
		this.collectedMask = ltrCnt;
	}
}

class Solution {
    int[][] direction = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
    public int minMoves(String[] classroom, int energy) {
    	int m = classroom.length;
    	int n = classroom[0].length();
    	int maxEnergy = energy;
    	int startRow = -1;
    	int startCol = -1;
    	int ltrCount = 0;
    	
    	int[][] ltrBitPos = new int[m][n];
    	
    	for(int i=0;i<m; i++) {
    		for(int j=0;j<n;j++) {
    			ltrBitPos[i][j] = -1;
    			if(classroom[i].charAt(j) == 'S') {
    				startRow = i;
    				startCol = j;
    			} else if(classroom[i].charAt(j) == 'L') {
    				ltrBitPos[i][j] = ltrCount;
    				ltrCount++;
    			}
    		}
    	}
    	
    	int allCollected = (1<<ltrCount) - 1;
    	if(ltrCount == 0) {
    		return 0;
    	}
    	
    	boolean[][][][] visited = new boolean[m][n][maxEnergy+1][1 << ltrCount];
    	int mask = 0;
    	
    	Queue<state> queue = new LinkedList<>();
    	queue.add(new state(
    		startRow,
    		startCol,
    		maxEnergy,
    		mask
    	));
    	
    	visited[startRow][startCol][maxEnergy][mask] = true;
    	
    	int moves = 0;
    	
    	while(!queue.isEmpty()) {
    		int currSize = queue.size();
    		
    		while(currSize > 0) {
                currSize--;
    			state temp = queue.poll();
        		int row = temp.r;
        		int col = temp.c;
        		int enrgy = temp.energyLeft;
        		int collectedMask = temp.collectedMask;
        		
        		if(collectedMask == allCollected) {
        			return moves;
        		}
        		
        		if(enrgy == 0) {
        			continue;
        		}
        		
        		for(int[] x: direction) {
        			int nextRow = x[0] + row;
        			int nextCol = x[1] + col;
        			
        			if(nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) {
        				continue;
        			}
        			
        			char cell = classroom[nextRow].charAt(nextCol);
        			
        			if(cell == 'X') {
        				continue;
        			}
        			
        			int nextEnergy = enrgy - 1;
        			int nextCollectedMask = collectedMask;
        			
        			if(cell == 'R') {
        				nextEnergy = maxEnergy;
        			} else if(cell == 'L') {
        				nextCollectedMask |= (1 << ltrBitPos[nextRow][nextCol]);
        			}
        			
        			if(!visited[nextRow][nextCol][nextEnergy][nextCollectedMask]) {
        				visited[nextRow][nextCol][nextEnergy][nextCollectedMask] = true;
        				
        				queue.add(new state (
        					nextRow,
        					nextCol,
        					nextEnergy,
        					nextCollectedMask
        				));
        			}
        		}
    		}
    		moves++;
    	}
    	
    	return -1;
    }
}
