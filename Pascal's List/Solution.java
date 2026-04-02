class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        for(int i=0;i<numRows;i++) {
            List<Integer> ls = new ArrayList<>();

            for(int j=0;j<=i;j++) {
                if(j==i || j==0) {
                    ls.add(1);
                } else {
                    ls.add(list.get(i-1).get(j) + list.get(i-1).get(j-1));
                }
            }

            list.add(ls);
        }

        return list;
    }
}
