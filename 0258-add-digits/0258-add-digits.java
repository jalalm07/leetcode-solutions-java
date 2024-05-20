class Solution {
    public int addDigits(int num) {
        int sum = 0;

        while(num > 0){
            int lastDigit = num % 10;
            sum += lastDigit;
            num /= 10;
            if(num == 0){
                if(sum < 10)
                    break;
                else {
                    num = sum;
                    sum = 0;
                }    
            }
                
        }

        return sum;
    }
}