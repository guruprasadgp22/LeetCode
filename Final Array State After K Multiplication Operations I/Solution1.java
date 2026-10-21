class Pair implements Comparable<Pair> {
    int num;
    int index;

    Pair(int num, int index) {
        this.num = num;
        this.index = index;
    }

    public int compareTo(Pair o) {
        if(this.num == o.num) {
            return this.index - o.index;
        }
        return this.num - o.num;
    } 
}

class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++) {
            queue.add(new Pair(nums[i], i));
        }

        while(k > 0) {
            Pair temp = queue.poll();
            queue.add(new Pair(temp.num * multiplier, temp.index));
            k--;
        }

        while(!queue.isEmpty()) {
            Pair temp = queue.poll();
            nums[temp.index] = temp.num;
        }

        return nums;
    }
}
