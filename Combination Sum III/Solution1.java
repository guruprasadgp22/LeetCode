class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        solve(1, n, curr, k);
        return result;
    }

    private void solve(int i, int target, List<Integer> curr, int k) {
        if(curr.size() == k && target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }

        if(target < 0 || curr.size() > k) {
            return;
        }

        for(int start=i;start<=9;start++) {
            if(start > target) {
                break;
            }
            curr.add(start);
            solve(start+1, target-start, curr, k);
            curr.removeLast();
        }
    }
}
