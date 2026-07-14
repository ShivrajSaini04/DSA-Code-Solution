class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    int size;
    public MedianFinder() {
         minHeap = new PriorityQueue<>();
         maxHeap = new PriorityQueue<>(Collections.reverseOrder());
         size =0;
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        if (maxHeap.size() > minHeap.size() + 1)  minHeap.add(maxHeap.poll());
         if (size > 1 && (maxHeap.peek() > minHeap.peek()) )  {
            maxHeap.add(minHeap.poll());
            minHeap.add(maxHeap.poll());
        }
        size++;
    }
    
    public double findMedian() {
        if (size%2 == 1) return (double)maxHeap.peek();
        else return (double)( maxHeap.peek() + minHeap.peek()) / 2; 
    }
}