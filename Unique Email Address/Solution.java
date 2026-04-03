class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();

        for(String email: emails) {
            String parts[] = email.split("@");
            String local = parts[0];
            String domain = parts[1];

            int index = local.indexOf("+");

            if(index != -1) {
                local = local.substring(0, index);
            }

            local = local.replace(".", "");

            String normalize = local + "@" + domain;

            set.add(normalize);
        }

        return set.size();
    }
}
