import java.util.*;
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> studentQueue = new ArrayDeque<>();
        Arrays.stream(students).forEach(p-> studentQueue.add(p));

        Queue<Integer> sandwichQueue = new ArrayDeque<>();
        Arrays.stream(sandwiches).forEach(p-> sandwichQueue.add(p));
        int studentSwap = 0;
        int maxTry = (students.length) * (sandwiches.length);

        while(maxTry != 0){
            if(studentQueue.peek() == sandwichQueue.peek()){
                studentQueue.poll();
                sandwichQueue.poll();
            } else {
                int temp = studentQueue.poll();
                studentQueue.add(temp);
            }
            maxTry--;
        }
        System.out.println(studentQueue);
        System.out.println(sandwichQueue);
        return studentQueue.size();
    }
}