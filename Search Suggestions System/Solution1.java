class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        String prefix = "";
        List<List<String>> result = new ArrayList<>();
        for(char ch: searchWord.toCharArray()) {
            prefix += ch;
            int start = binarySearch(products, prefix);

            List<String> ans = new ArrayList<>();
            for(int i = start;i<start+3 && i<products.length;i++) {
                if(!products[i].startsWith(prefix)) {
                    break;
                }
                ans.add(products[i]);
            }
            result.add(ans);
        }

        return result;
    }

    private int binarySearch(String[] products, String prefix) {
        int low = 0;
        int high = products.length;

        while(low < high) {
            int mid = low + (high - low)/2;
            if(products[mid].compareTo(prefix) < 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
