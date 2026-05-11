class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        for(int ele: arr1) {
            set.add(ele);
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        int  i = 0;
        for(int ele:arr2) {
            int count = map.get(ele);
            System.out.println(ele + " " + count);
            while(count > 0) {
                arr1[i] = ele;
                i++;
                count--;
            }
            set.remove(ele);
        }

        for(int ele: set) {
            int count = map.get(ele);
            System.out.println(ele + " " + count);
            while(count > 0) {
                arr1[i] = ele;
                i++;
                count--;
            }
        }

        return arr1;
    }
}
