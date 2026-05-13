class Node {
    Node children[];
    boolean eow;

    Node() {
        children = new Node[26];

        for(int i=0;i<26;i++) {
            children[i] = null;
        }

        eow = false;
    }
}

class Solution {
    Node root;
    String ans;

    public void insert(String word) {
        Node curr = root;

        for(int i=0;i<word.length();i++) {
            int index = word.charAt(i) - 'a';
            if(curr.children[index] == null) {
                curr.children[index] = new Node();
            }

            curr = curr.children[index];
        }

        curr.eow = true;
    }

    public void longestWord(Node root, StringBuilder temp) {
        if(root == null) {
            return;
        }

        for(int i=0;i<26;i++) {
            if(root.children[i] != null && root.children[i].eow == true) {
                temp.append((char)(i+'a'));
                if(ans.length() < temp.length()) {
                    ans = temp.toString();
                }

                longestWord(root.children[i], temp);

                temp.deleteCharAt(temp.length()-1);
            }
        }
    }

    public String longestWord(String[] words) {
        root = new Node();

        for(String s: words) {
            insert(s);
        }

        ans = "";

        longestWord(root, new StringBuilder(""));

        return ans;
    }
}
