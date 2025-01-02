class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int i = 0;
        int j = n - 1;
        int[] ans = new int[2];

        while(true){
            if(numbers[i] + numbers[j] == target){
                ans[0] = i + 1;
                ans[1] = j + 1;
                break;
            } else if(numbers[i] + numbers[j] > target){
                j--;
            } else if(numbers[i] + numbers[j] < target){
                i++;
            }
        }
        return ans;
    }
}