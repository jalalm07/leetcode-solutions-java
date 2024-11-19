class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int i =0; i < prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i < numCourses; i++){
            if(inDegree[i] == 0) queue.add(i);
        }

        int[] result = new int[numCourses];
        int index = 0;
        while(!queue.isEmpty()){
            int node = queue.remove();
            result[index++] = node;
            for(int adjN : adj.get(node)){
                inDegree[adjN]--;
                if(inDegree[adjN] == 0) queue.add(adjN);
            }
        }

        return index == numCourses ? result : new int[0]; 
    }
}