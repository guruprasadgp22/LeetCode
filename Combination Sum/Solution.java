class Solution {
    HashSet<List<Integer>> unique = new HashSet<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        int index = 0;
        int n = candidates.length;

        combSum(candidates, n, target, index, result, current);
        return result;
    }

    public void combSum(int[] arr, int n, int k, int index, List<List<Integer>> result, List<Integer> current) {
        if(k == 0) {
            if(!unique.contains(current)) {
                result.add(new ArrayList<>(current));
                unique.add(new ArrayList<>(current));
            }

            return;
        }

        if(k < 0 || index == n) {
            return;
        }

        current.addLast(arr[index]);
        combSum(arr, n, k-arr[index], index+1,result, current);
        combSum(arr, n, k-arr[index], index, result, current);
        current.removeLast();

        combSum(arr, n, k, index+1, result, current);
    }
}
