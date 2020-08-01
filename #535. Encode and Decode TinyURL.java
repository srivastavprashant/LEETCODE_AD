// #535. Encode and Decode TinyURL
public class Codec 
{
    HashMap<Integer, String> map;
    int cap;
    
    Codec()
    {
        map=new HashMap<Integer, String>();
        cap=0;
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) 
    {
        map.put(cap++, longUrl);
        return (cap-1)+"";
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) 
    {
        return map.get(Integer.parseInt(shortUrl));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
