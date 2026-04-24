class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();

        for(int i=0;i<=rowIndex;i++) {
            List<Integer> ls = new ArrayList<>();

            for(int j=0;j<=i;j++) {
                if(j==0||j==i) {
                    ls.add(1);
                } else {
                    ls.add(list.get(i-1).get(j-1) + list.get(i-1).get(j));
                }
            }

            list.add(ls);
        }

        for(int i=0;i<=rowIndex;i++) {
            result.add(list.get(rowIndex).get(i));
        }

        return result;
    }
}
