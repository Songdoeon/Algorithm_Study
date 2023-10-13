class Solution {
    public int solution(int[] num_list) {
        String num1 = "";
        String num2 = "";
        
        for(int num : num_list){
            if(num % 2 == 0) num1 += num;
            else num2 += num;
        }
        return Integer.valueOf(num1) + Integer.valueOf(num2);
    }
}