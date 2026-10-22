class Node {
    Node[] children;
    List<String> suggestion;

    Node() {
        children = new Node[26];
        for(int i=0;i<26;i++) {
            children[i] = null;
        }

        suggestion = new ArrayList<>();
    }
}

class Trie {
    Node root;

    Trie() {
        root = new Node();
    }

    void insert(String word) {  
        Node curr = root;
        for(char ch: word.toCharArray()) {
            int idx = ch - 'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];
            if(curr.suggestion.size() < 3) {
                curr.suggestion.add(word);    
            }
        }
    }

    List<String> searching(String search) {
        Node curr = root;
        for(char ch: search.toCharArray()) {
            int idx = ch - 'a';
            if(curr.children[idx] == null) {
                return new ArrayList<>();
            }

            curr = curr.children[idx];
        }

        return curr.suggestion;
    }
}
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);

        Trie trie = new Trie();
        for(String s: products) {
            trie.insert(s);
        }

        List<List<String>> result = new ArrayList<>();
        String prefix = "";
        for(char ch: searchWord.toCharArray()) {
            prefix += ch;
            List<String> ans = trie.searching(prefix);
            result.add(ans);
        }

        return result;
    }
}
