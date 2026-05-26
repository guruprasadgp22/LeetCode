class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;

        String[] arr = new String[n];
        for(int i=0;i<n;i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr, (a, b) -> {
            String order1 = a + b;
            String order2 = b + a;

            return order2.compareTo(order1);
        });

        if(arr[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(String s: arr) {
            sb.append(s);
        }

        return sb.toString();
    }
}
