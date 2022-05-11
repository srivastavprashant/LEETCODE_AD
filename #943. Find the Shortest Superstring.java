
// solution O(2^n * n* n) bit masking + travelling salesman problem + dp (memoization)
class Solution {
    public String shortestSuperstring(String[] words) {
        int[][] adj = generateGraph(words);
        
        Data ans = new Data();
        for(int i=0;i<words.length;i++) {
            dp= new Data[1<<words.length][words.length];
            Data temp = applyTSM(adj, 1<<i, i);
            if(temp.value>= ans.value) ans.deepClone(temp);
        }
        
        return generateString(words, ans.order);
    }
    
    Data[][] dp;
    public Data applyTSM(int[][] adj, int mask, int index) {
        if(mask == (1<<adj.length)-1) {
            Data ret= new Data();
            ret.order.add(index);
            return ret;
        } else if (dp[mask][index] != null) return dp[mask][index];
        else {
            Data min= new Data(Integer.MIN_VALUE);
            for(int i=0;i<adj.length;i++) {
               if(((1<<i) & mask) == 0) {
                   Data val = applyTSM(adj, mask|(1<<i), i);
                   int len = min.order.size();
                   if(min.value == Integer.MIN_VALUE || val.value+ adj[index][i] > min.value) {
                       min.deepClone(val);
                       min.value+= adj[index][i];
                   }
               }  
            }
             
            min.order.add(index);
            dp[mask][index] = min;
            return min;
        }
    }
    
    public int[][] generateGraph(String[] words) {
        int n = words.length;
        int[][] ret= new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                ret[i][j] = findCommon(words[i], words[j]);
            }
        }
        
        return ret;
    }
    
    public int findCommon(String a, String b) {
        int i = Math.min(a.length(), b.length());
        while(i>=0) {
            if(a.substring(a.length()-i,a.length()).equals(b.substring(0,i)))
                return i;
            i--;
        }
        return 0;
    }
    
    public String generateString(String[] words, List<Integer> order) {
        Collections.reverse(order);
        StringBuilder ans = new StringBuilder("");
        for(int i: order) {
            int index= findCommon(ans.toString(), words[i]);
            ans.append(words[i].substring(index, words[i].length()));
        }
        
        return ans.toString();
    }
    
    // debug helper functions.
    public String bin(int n) {
        String ret = "";
        while(n!=0) {
            ret+= (n&1);
            n>>= 1;
        }
        return ret;
    }
}

class Data {
    List<Integer> order;
    int value;
    
    public Data() {
        order = new ArrayList<>();
        value = 0;
    }
    
    public Data(int value) {
        this.value = value;
        order = new ArrayList<>();
    }
    
    public void deepClone(Data val) {
        this.order = new ArrayList<>(val.order);
        this.value = val.value;
    }
}


/** TESTCASES

["alex","loves","leetcode"]
["catg","ctaagt","gcta","ttca","atgcatc"]
["pqtifawzoessrpjwnjf","wnjfjehefpipubizjx","vpmafqkvixcumugp","tzucldkoizjhyat","umugpqtifawzoes","zjxtifiolejwstzuc","pjwnjfjehefpipub","ifiolejwstzucldko"]
["wmiy","yarn","rnnwc","arnnw","wcj"]
["mftpvodataplkewcouz","krrgsoxpsnmzlhprsl","qhbfymytxzbmqma","hunjgeaolcuznhpodi","kewcouzbwlftz","xzbmqmahunjgeaolcu","zlhprslqurnqbhsjr","rrgsoxpsnmzlhprslqur","diqukrrgsoxpsnmz","sjrxzavamftpvoda"]
["ift","efd","dnete","tef","fdn"]
["acabcc","bbbab","ecb","aaa","ccac","beaeda"]

*/
