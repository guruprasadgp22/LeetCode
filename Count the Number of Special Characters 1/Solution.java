class Solution {
    public int numberOfSpecialChars(String word) {
        HashSet<Character> upper = new HashSet<>();
        HashSet<Character> lower = new HashSet<>();

        for(char ch: word.toCharArray()) {
            if(Character.isUpperCase(ch)) {
                upper.add(ch);
            } else if(Character.isLowerCase(ch)) {
                lower.add(ch);
            }
        }
        System.out.println(upper.toString() + " - " + lower.toString());
        int count = 0;
        for(char ch: upper) {
            if(lower.contains(Character.toLowerCase(ch))) {
                count++;
            }
        }

        return count;
    }
}
