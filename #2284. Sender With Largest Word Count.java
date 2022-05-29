class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        HashMap<String, Integer> map= new HashMap<>();
        for(int i=0;i<senders.length;i++) {
            map.put(senders[i], map.getOrDefault(senders[i], 0)+ messages[i].split(" ").length);
        }
        
        List<String> arr= new ArrayList<>(map.keySet());
        Collections.sort(arr, (a, b) -> map.get(a) == map.get(b) ? b.compareTo(a) : map.get(b)- map.get(a));
        return arr.get(0);
    }
}
