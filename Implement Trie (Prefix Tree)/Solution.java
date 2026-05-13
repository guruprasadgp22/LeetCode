class Trie {
    Trie[] children;
    boolean eow;

    public Trie() {
        children = new Trie[26];

        for(int i=0;i<26;i++) {
            children[i] = null;
        }

        eow = false;
    }
    
    Trie root;

    public void insert(String word) {
        Trie curr = this;

        for(int i=0;i<word.length();i++) {
            int index = word.charAt(i) - 'a';

            if(curr.children[index] == null) {
                curr.children[index] = new Trie();
            }

            curr = curr.children[index];
        }

        curr.eow = true;
    }
    
    public boolean search(String word) {
        Trie curr = this;

        for(int i=0;i<word.length();i++) {
            int index = word.charAt(i) - 'a';

            if(curr.children[index] == null) {
                return false;
            }

            curr = curr.children[index];
        }

        return curr.eow;
    }
    
    public boolean startsWith(String prefix) {
        Trie curr = this;

        for(int i=0;i<prefix.length();i++) {
            int index = prefix.charAt(i) - 'a';

            if(curr.children[index] == null) {
                return false;
            }

            curr = curr.children[index];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
