class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
         int INF = Integer.MAX_VALUE;
        int[][] dist = new int[n][k + 5];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], INF);
        for(int i = 0; i < n; i++){
            adj.put(i, new ArrayList<>());
        }

        for(int[] fl: flights){
             adj.get(fl[0]).add(new int[]{fl[1], fl[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, src, -1});

        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int cst = top[0];
            int node = top[1];
            int stops = top[2];
            if(node == dst) return cst;
            if(stops == k || dist[node][stops + 1] < cst) continue;
            for(int[] neighbor: adj.get(node)){
                int nei = neighbor[0];
                int w = neighbor[1];
                int nextCst = cst + w;
                int nextStops = stops + 1;
                if(dist[nei][nextStops + 1] > nextCst){
                    dist[nei][nextStops + 1] = nextCst;
                    pq.offer(new int[]{nextCst, nei, nextStops});
                }
            }
        }
        return -1;        
    }
}