public class Codec {

    HashMap<String, String> map = new HashMap<>();
    String key = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String keys = generate();

        while(map.containsKey(keys)) {
            keys = generate();
        }

        map.put(keys, longUrl);

        return "https://tinyurl.com/" + keys;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String k = shortUrl.replace("https://tinyurl.com/","");

        return map.get(k);
    }

    public String generate() {
        StringBuilder sb = new StringBuilder();

        Random rand = new Random();

        for(int i=0;i<6;i++) {
            int index = rand.nextInt(key.length());
            sb.append(key.charAt(index));
        }

        return sb.toString();
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
