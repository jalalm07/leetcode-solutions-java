class Solution {
    
    private Map<Integer, List<Integer>> preMap = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i = 0; i < numCourses; i++){
            preMap.put(i, new ArrayList<>());
        }

        for(int[] pre: prerequisites){
            preMap.get(pre[0]).add(pre[1]);
        }

        for(int i = 0; i < numCourses; i++){
            if(!dfs(i)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int crs){
        if(visited.contains(crs)) return false;
        if(preMap.get(crs).isEmpty()) return true;
        visited.add(crs);
        for(int pre: preMap.get(crs)){
            if(!dfs(pre)){
                return false;
            }
        }
        visited.remove(crs);
        preMap.put(crs, new ArrayList<>());
        return true;
    }
    /*
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0)
                queue.add(i);
        }
        int cnt = 0;
        while (!queue.isEmpty()) {
            int node = queue.remove();
            cnt++;
            for (int adjN : list.get(node)) {
                if (--inDegree[adjN] == 0)
                    queue.add(adjN);
            }
        }

        return cnt == numCourses;
    }
    */
}