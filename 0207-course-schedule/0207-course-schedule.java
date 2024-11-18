class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int m = prerequisites.length;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            list.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];
        for(int i = 0; i < m; i++){
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }

        

        // for(int i = 0; i < numCourses; i++){
        //     for(int n: list.get(i)){
        //         inDegree[prerequisites[i][0]]++;
        //     }
        // }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0) queue.add(i);
        }
        int cnt = 0;
        while(!queue.isEmpty()){
            int node = queue.remove();
            cnt++;
            for(int adjN: list.get(node)){
                inDegree[adjN]--;
                if(inDegree[adjN] == 0) queue.add(adjN);
            }
        }

        return cnt == numCourses;
    }
}