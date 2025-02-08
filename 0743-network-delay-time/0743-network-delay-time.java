class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        
        for(int[] time: times){
            map.putIfAbsent(time[0], new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
        }

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        queue.add(new int[]{0, k});

        
        int count = 0;
        int minTime = 0;
        boolean[] visited = new boolean[n+1];
        while(!queue.isEmpty()){
            int time = queue.peek()[0];
            int node = queue.peek()[1];
            queue.remove();
            if(visited[node]) continue;
            visited[node] = true;
            minTime = time;
  
            count++;
            if(map.containsKey(node)){
                for(int next: map.get(node).keySet()){
                    queue.add(new int[]{time + map.get(node).get(next), next});
                }
            }
        }

        if (count == n) return minTime;
        return -1;
    }
}