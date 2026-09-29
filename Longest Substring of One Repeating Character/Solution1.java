class Node {
    int maxLen;
    char leftChar;
    char rightChar;
    int preLen;
    int suffLen;

    Node() {
        this.maxLen = 0;
        this.leftChar = 0;
        this.rightChar = 0;
        this.preLen = 0;
        this.suffLen = 0;
    }

    Node(int maxLen, char leftChar, char rightChar, int preLen, int suffLen) {
        this.maxLen = maxLen;
        this.leftChar = leftChar;
        this.rightChar = rightChar;
        this.preLen = preLen;
        this.suffLen = suffLen;
    }
}

class ST {
    int n;
    Node[] segmentTree;

    ST(String s) {
        n = s.length();
        segmentTree = new Node[4*n];
        buildST(0, 0, n-1, s);
    }

    void buildST(int node, int start, int end, String s) {
        if(start == end) {
            segmentTree[node] = new Node(1, s.charAt(start), s.charAt(end), 1, 1);
            return;
        }
        int mid = start + (end - start)/2;
        buildST(2*node+1, start, mid, s);
        buildST(2*node+2, mid+1, end, s);

        segmentTree[node] = merge(segmentTree[2*node+1], segmentTree[2*node+2], mid + 1 - start, end - mid);
    }

    Node merge(Node left, Node right, int leftLen, int rightLen) {
        Node result = new Node();

        result.leftChar = left.leftChar;
        result.rightChar = right.rightChar;

        result.preLen = left.preLen;
        if(leftLen == left.maxLen && left.rightChar == right.leftChar) {
            result.preLen = left.preLen + right.preLen;
        }

        result.suffLen = right.suffLen;
        if(rightLen == right.maxLen && left.rightChar == right.leftChar) {
            result.suffLen = left.suffLen + right.suffLen;
        }

        result.maxLen = Math.max(left.maxLen, right.maxLen);
        if(left.rightChar == right.leftChar) {
            result.maxLen = Math.max(result.maxLen, left.suffLen + right.preLen);
        }

        return result;
    }

    void update(int node, int start, int end, int pos, char ch) {
        if(start == end) {
            segmentTree[node] = new Node(1, ch, ch, 1, 1);
            return;
        }

        int mid = start + (end - start)/2;
        if(pos <= mid) {
            update(2*node+1, start, mid, pos, ch);
        } else {
            update(2*node+2, mid+1, end, pos, ch);
        }

        segmentTree[node] = merge(segmentTree[2*node+1], segmentTree[2*node+2], mid + 1 - start, end - mid);
    }

    int query() {
        return segmentTree[0].maxLen;
    }
}

class Solution {
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int sLen = s.length();
        int n = queryIndices.length;
        int[] result = new int[n];

        ST st = new ST(s);

        for(int i=0;i<n;i++) {
            int pos = queryIndices[i];
            char ch = queryCharacters.charAt(i);

            st.update(0, 0, sLen-1, pos, ch);

            result[i] = st.query();
        }

        return result;
    }
}
