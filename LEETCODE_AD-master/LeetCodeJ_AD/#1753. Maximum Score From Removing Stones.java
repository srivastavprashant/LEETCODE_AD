package LeetCodeJ;

class Solution {
    public int maximumScore(int a, int b, int c) {
        int[] val= {a, b, c};
        Arrays.sort(val);
        a= val[0]; b= val[1]; c= val[2];
        
        if(a+b<= c) return a+b;
        else return c+ (a- (int)Math.ceil((c-(b-a))/2d));
    }
}
