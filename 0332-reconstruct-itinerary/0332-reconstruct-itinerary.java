class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for(List<String> ticket: tickets){
            map.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            map.get(ticket.get(0)).add(ticket.get(1));
        }

        System.out.println(map);
        List<String> result = new ArrayList<>();
        dfs(map, "JFK", result);
        return result;
    }

    private void dfs(Map<String, PriorityQueue<String>> map, String currCity, List<String> result){
        //result.add(currCity);
        PriorityQueue<String> pq = map.get(currCity);
        while(pq != null && !pq.isEmpty()){
            dfs(map, pq.poll(), result);
        }
        result.addFirst(currCity);
    }
}