class Solution {

    private class pair{
        private int time;
        private int node;

        public pair(int time, int node){
            this.time = time;
            this.node = node;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            adjList.add(new ArrayList<>());
        }
        
        Queue<pair> queue = new LinkedList<>();
        for(int[] time: times){
            adjList.get(time[0] - 1).add(time[1] - 1);
        }
        System.out.println(adjList);
        queue.add(new pair(0, k - 1));
        
        int count = 0;
        int minTime = 0;
        while(!queue.isEmpty()){
            int time = queue.peek().time;
            int node = queue.peek().node;
            minTime = Math.max(minTime, time);
            queue.remove();
            count++;
            for(int adj: adjList.get(node)){
                queue.add(new pair(time + 1, adj));
            }
        }

        if (count == n) return minTime;
        return -1;
    }
}