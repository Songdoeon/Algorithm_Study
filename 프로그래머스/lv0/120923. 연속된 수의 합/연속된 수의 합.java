class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        
        int n = total / num;
        
        answer[0] = n - num / 2; 
        if(num % 2 == 0) answer[0] += 1;
        for(int idx = 1; idx < num; idx++){
            answer[idx] = answer[idx-1] + 1;
        }
        
        return answer;
    }
}