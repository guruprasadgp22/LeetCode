class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int ele: asteroids) {
            while(ele < 0 && !stack.isEmpty() && stack.peek() > 0) {
                int sum = ele + stack.peek();

                if(sum < 0) {
                    stack.pop();
                } else if(sum > 0) {
                    ele = 0;
                } else {
                    stack.pop();
                    ele = 0;
                }
            }

            if(ele != 0) {
                stack.add(ele);
            }
        }

        int[] result = new int[stack.size()];
        for(int i=stack.size()-1; i>=0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
