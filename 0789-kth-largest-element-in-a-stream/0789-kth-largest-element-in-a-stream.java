class KthLargest {
    PriorityQueue<Integer> p;
    int m;
    public KthLargest(int k, int[] nums) {
        m=k;
        p=new PriorityQueue<>(k);
        for(int i:nums){
            if(p.size()<k){
                p.offer(i);
            }else if(i>p.peek()){
                p.offer(i);
            }
            if(p.size()>k){
                p.poll();
            }
        }
    }
    
    public int add(int val) {
        if(p.size()<m){
            p.offer(val);
        }else if(val>p.peek()){
            p.offer(val);
        }
        if(p.size()>m){
            p.poll();
        }
        return p.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */