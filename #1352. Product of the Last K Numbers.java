// #1352. Product of the Last K Numbers



class ProductOfNumbers {
    private List<Integer> arr;
    private TreeSet<Integer> set;
    
    public ProductOfNumbers() {
        arr= new ArrayList<>();
        set= new TreeSet<>();
    }
    
    public void add(int num) {
        if(num== 0) set.add(arr.size());
        if(arr.size()== 0 || arr.get(arr.size()-1)== 0) arr.add(num);
        else arr.add(arr.get(arr.size()-1)*num);
    }
    
    public int getProduct(int k) {
        int index= arr.size()- k;
        if(set.ceiling(index)!= null) return 0;
        if(index-1<0) return arr.get(arr.size()-1);
        
        int val= arr.get(arr.size()-k-1);
        return arr.get(arr.size()-1)/ (val== 0? 1: val);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
