class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder curr = new StringBuilder();
        while(sum >= 9) {
            curr.append(9);
            sum -= 9;
        }

        if(sum != 0) {
            curr.append(sum);
        }

        while(curr.length() < num) {
            curr.append(0);
        }

        return curr.length() == num? curr.toString(): "";
    }
}
