class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum > num * 9) {
            return "";
        }

        int nines = sum / 9;
        int rem = sum % 9;

        StringBuilder res = new StringBuilder();
        res.repeat('9', nines);
        if(rem > 0) {
            res.append(rem);
        }

        res.repeat('0', num - res.length());
        return res.toString();
    }
}
