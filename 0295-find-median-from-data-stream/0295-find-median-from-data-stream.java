class MedianFinder {
    static  PriorityQueue<Integer> minheap; 
    static  PriorityQueue<Integer> maxheap;
    static  int size ;
    public MedianFinder() {
         minheap = new PriorityQueue<>();
         maxheap = new PriorityQueue<>(Collections.reverseOrder());
         size = 0;
    }
    
    public void addNum(int num) {
            maxheap.add(num);

        if (maxheap.size() > minheap.size() + 1  ) minheap.add(maxheap.poll());
        
        if (size > 1 && (maxheap.peek() > minheap.peek()) )  {
            maxheap.add(minheap.poll());
            minheap.add(maxheap.poll());
        }
        size++;
    }
    
    public double findMedian() {
        if (size==0) return -1;
        if (size%2==1) return (double)maxheap.peek();
        else return (double)( maxheap.peek() + minheap.peek()) /2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */