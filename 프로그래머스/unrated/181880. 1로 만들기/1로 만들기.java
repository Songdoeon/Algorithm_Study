class Solution {
    int div(int num){
        int count = 0;
        while(num != 1){
            if(num % 2 == 0) num /= 2;
            else {
                num -= 1;
                num /= 2;
            }
            count++;
        }
        return count;
    }
    public int solution(int[] num_list) {
        int answer = 0;
        
        for(int num : num_list){
            answer += div(num);
        }
        return answer;
    }
}