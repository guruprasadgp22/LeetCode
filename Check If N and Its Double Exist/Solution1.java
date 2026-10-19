class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int ele : arr) {
            int j = ele * 2;
            if (set.contains(j)) {
                return true;
            }

            if (ele % 2 == 0 && set.contains(ele / 2)) {
                return true;
            }
            set.add(ele);
        }

        return false;
    }
}
