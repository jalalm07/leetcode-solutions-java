class Solution {
    PriorityQueue<Integer> pq;
    int k;
    public int findKthLargest(int[] nums, int k) {
        this.pq = new PriorityQueue<>();
        this.k = k;
        for(int n : nums){
            pq.offer(n);
            if(pq.size() > k)
                pq.poll();
        }
        return pq.peek();
    }
}