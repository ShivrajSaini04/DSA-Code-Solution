class ProductOfNumbers {
    
    ArrayList<Integer> list;
    int idx;

    public ProductOfNumbers() {
         list = new ArrayList<>();
         idx = 0;
         list.add(1);
    }
    
    public void add(int num) {
        if ( num == 0) {
            list.clear();
            list.add(1);
            idx = 0;
            return;
        }
        list.add(list.get(idx) * num);
        idx++;
    }
    
    public int getProduct(int k) {
        if ( k > idx) return 0;
        return list.get(idx) / list.get(idx-k);
    }
}

