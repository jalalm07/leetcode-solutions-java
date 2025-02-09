class Solution {
    Map<String, PriorityQueue<String>> map;
    LinkedList<String> result;
    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<>();
        for(List<String> ticket: tickets){
            map.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            map.get(ticket.get(0)).add(ticket.get(1));
        }
        result = new LinkedList<>();
        dfs("JFK");
        return result;
    }

    private void dfs(String currCity){
        //result.add(currCity);
        PriorityQueue<String> pq = map.get(currCity);
        while(pq != null && !pq.isEmpty()){
            dfs(pq.poll());
        }
        result.addFirst(currCity);
    }
}