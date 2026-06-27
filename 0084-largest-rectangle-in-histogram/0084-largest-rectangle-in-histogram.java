class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] pse = new int[n];
        int[] nse = new int[n];
        pse(pse,heights);
        nse(nse,heights);
        int maxArea = 0;
        for(int i=0;i<n;i++){
            int left  = pse[i]  , rig = nse[i];
            if (rig == -1) rig = n;
            int width = rig - left -1;
            int area = width * heights[i];
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
    }

    void pse(int[] pse , int[] heights){
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        st.push(0);
        pse[0] = -1;
        for(int i=1;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) st.pop();
            if (st.isEmpty()) pse[i] = -1;
            else pse[i] = st.peek();
            st.push(i);
        }
    }

    void nse (int[] nse , int[] heights){
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        st.push(n-1);
        nse[n-1] = -1;
    
        for(int i= n-2; i>=0;i--){
 
           while(!st.isEmpty() && heights[st.peek()] >= heights[i]) st.pop();

           if (st.isEmpty())  nse[i] = -1; 
           else nse[i] = st.peek();
            st.push(i);
        }
    }
}