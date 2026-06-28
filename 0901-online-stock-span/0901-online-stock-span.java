class StockSpanner {
    Stack<int[]> st;

    public StockSpanner() {
        st = new Stack<>();
    }

    public int next(int price) {
        int count = 1;

        while (!st.isEmpty()) {
            int[] curr = st.peek();
            if (price >= curr[0]) {
                count += curr[1];
                st.pop();
            } 
            else  break;
        }

        st.push(new int[] { price, count });
        return count;
    }
}
