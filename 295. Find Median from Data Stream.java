class MedianFinder {
    public PriorityQueue<Integer> max;
    public PriorityQueue<Integer> min;
    public MedianFinder() {
        max = new PriorityQueue<>(Collections.reverseOrder()); //sorting kive hoengi pr edi??
        min = new PriorityQueue<>();
    }
    // 6 9   7, 3   5 8 , 11 
    
    public void addNum(int num) {
        max.offer(num); //7 , 6 , 5 ,  3 - 2  == size bda 
        min.offer(max.poll()); // , 8,  9 , 11 - 2   == number bde 
        
        if(min.size() > max.size()){
            max.offer(min.poll());
        }
    }
    
    public double findMedian() {
        if(max.size() > min.size()){
            return max.peek();
        }
        else{
            return ((max.peek() + min.peek()) / 2.0);
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
