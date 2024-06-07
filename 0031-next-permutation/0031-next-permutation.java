class Solution {
    public void nextPermutation(int[] nums) {
        int pivot=-1;
        if(nums.length==1){
            return ;
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]<nums[i])
                pivot = i-1;
        }
        if(pivot==-1 ){
            reverse(nums,0);
            return;
        }
        int nextMax=-1;
        for(int i=pivot+1;i<nums.length;i++){
            if(nums[i]>nums[pivot]) 
                nextMax = i; // nextMax will keep on updating until smallestMax is found
        }
        int temp = nums[pivot];
        nums[pivot]= nums[nextMax];
        nums[nextMax]=temp;
        reverse(nums,pivot+1);
    }
    public void reverse(int[] nums,int s){
        int e= nums.length-1;
        while(s<e){
            int t= nums[s];
            nums[s]= nums[e];
            nums[e]= t;
            s+=1;
            e-=1;
        }
    }
}