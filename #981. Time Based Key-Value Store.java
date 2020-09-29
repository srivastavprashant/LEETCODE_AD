// 981. Time Based Key-Value Store

class TimeMap {
    HashMap<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) 
    {
        if(map.containsKey(key))
            map.get(key).put(timestamp, value);
        else
        {
            TreeMap<Integer, String> temp= new TreeMap<>();
            temp.put(timestamp, value);
            
            map.put(key, temp);
        }
    }
    
    public String get(String key, int timestamp) 
    {
        if(map.containsKey(key))
        {
            TreeMap<Integer, String> tree= map.get(key);
            
            if(tree.floorEntry(timestamp)!= null)
                return tree.floorEntry(timestamp).getValue();
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
