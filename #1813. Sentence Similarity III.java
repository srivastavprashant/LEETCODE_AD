// #1813. Sentence Similarity III


class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if(sentence1.equals(sentence2)) return true;
        if(sentence1.length()< sentence2.length()) {
            String temp= sentence1;
            sentence1= sentence2;
            sentence2= temp;
        }
        sentence2= " "+sentence2+" ";
        
        int i= 0;
        while(i!= sentence2.length()) {
            if(check(sentence1, sentence2, i))
                return true;
            
            i++;
            while(i!= sentence2.length() && sentence2.charAt(i)!= ' ') i++;

        }
        
        return false;
    }
    
    boolean check(String s1, String s2, int index) {
        if(index== 0) {
            System.out.println(s1);
            int i= s2.length()-2, j= s1.length()-1;
            while(i!= index-1) {
                if(s1.charAt(j)!= s2.charAt(i)) return false;
                i--;
                j--;
            }
        }
        else if(index== s2.length()-1) {
            int i= 1, j= 0;
            while(i!= index+1) {
                if(s1.charAt(j)!= s2.charAt(i)) return false;
                i++;
                j++;
            }
        }
        else {
            int i= 1, j= 0;
             while(i!= index+1) {
                if(s1.charAt(j)!= s2.charAt(i)) return false;
                i++;
                j++;
            }
            
            i= s2.length()-2; j= s1.length()-1;
            while(i!= index-1) {
                if(s1.charAt(j)!= s2.charAt(i)) return false;
                i--;
                j--;
            }
        }
            
        return true;
    }
}
