class Solution {
    public String sortSentence(String s) {
        String[] arr = s.split(" ");

        String[] result = new String[arr.length];

        for(String str: arr) {
            int num = 0;
            StringBuilder sb = new StringBuilder();
            for(char ch: str.toCharArray()) {
                if(Character.isDigit(ch)) {
                    num = num * 10 + ch - '0';
                } else {
                    sb.append(ch);
                }
            }

            result[num-1] = sb.toString();
        }

        for(String st: result) {
            System.out.println(st);
        }

        StringBuilder res = new StringBuilder();

        for(int i=0;i<result.length;i++) {
            if(i == result.length - 1) {
                res.append(result[i]);
                break;
            }
            res.append(result[i]).append(" ");
        }

        System.out.println(res);

        return res.toString();
    }
}
