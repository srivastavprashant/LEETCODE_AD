package LeetCodeJ;

// #380. Insert Delete GetRandom O(1)
class RandomizedSet 
{
    HashMap<Integer, Integer> map;
    ArrayList<Integer> arr;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map= new HashMap<Integer, Integer>();
        arr= new ArrayList<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        else
        {
            map.put(val, arr.size());
            arr.add(val);
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        else
        {
            int index= map.get(val);
            int last_element= arr.get(arr.size()-1);
            arr.set(index, last_element);
            
            map.put(last_element, index);
            map.remove(val);
            arr.remove(arr.size()-1);
            return true;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random rand= new Random();
        int index= rand.nextInt(arr.size());
        return arr.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
