class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();

        int max = candies[0];

        for(int i=1;i<candies.length;i++) {
            max = Math.max(max, candies[i]);
        }

        for(int i=0;i<candies.length;i++) {
            boolean ans = candies[i] + extraCandies < max ? false: true;
            list.add(ans);
        }

        return list;
    }
}
