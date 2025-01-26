class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] result = new int[numberOfUsers];
        boolean[] onlineUsers = new boolean[numberOfUsers];
        Arrays.fill(onlineUsers, true);
        events.sort((a, b) -> {
            int timeComparison = Integer.compare(Integer.parseInt(a.get(1)), Integer.parseInt(b.get(1)));
            if (timeComparison == 0) {
                return a.get(0).equals("OFFLINE") ? -1 : 1;
            }
            return timeComparison;
        });
        TreeMap<Integer, List<Integer>> offlineMap = new TreeMap<>();
        for(List<String> event : events){
            String eventType = event.get(0);
            String mentionString = event.get(2);
            int timeStamp = Integer.parseInt(event.get(1));
            if(eventType.equals("MESSAGE")){
                processOfflineUsers(timeStamp, offlineMap, onlineUsers);
                if(mentionString.equals("ALL")){
                    for(int i = 0; i < numberOfUsers; i++){
                        result[i]++; 
                    }
                } else if(mentionString.equals("HERE")){
                    for(int i = 0; i < numberOfUsers; i++){
                        if(onlineUsers[i]) result[i]++;
                    }
                } else{
                    String[] arr = mentionString.split(" ");
                    for(String token: arr){
                        if(token.startsWith("id")){
                            int id = Integer.parseInt(token.substring(2));
                            result[id]++;
                        }
                    }
                }
            } else {
                //offline event
                 processOfflineUsers(timeStamp, offlineMap, onlineUsers);
                int id = Integer.parseInt(mentionString);
                onlineUsers[id] = false;
                int returnOnlineTime = timeStamp + 60;
                offlineMap.putIfAbsent(returnOnlineTime, new ArrayList<>());
                offlineMap.get(returnOnlineTime).add(id);
            }
        }
        return result;
    }

    private void processOfflineUsers(int currentTimestamp, TreeMap<Integer, List<Integer>> offlineMap, boolean[] onlineUsers){
        Iterator<Map.Entry<Integer, List<Integer>>> iterator = offlineMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, List<Integer>> entry = iterator.next();
            int returnOnlineTime = entry.getKey();
            if(returnOnlineTime > currentTimestamp) break;

            for(int id: entry.getValue()){
                onlineUsers[id] = true;
            }
            iterator.remove();
        }
    }
}