class ProductOfNumbers {
    
    ArrayList<Integer> list;

    public ProductOfNumbers() {
         list = new ArrayList<>();

    }
    
    public void add(int num) {
        list.add(num);
    }
    
    public int getProduct(int k) {
        int product = 1;
        while (k > 0){
            product *= list.get(list.size() - k);
            k--;
        } 
        return product;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */