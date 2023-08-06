class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        long low = Math.min(a,b);
        long high = Math.max(a,b);
        for(long i = low; i <= high; i++){
            answer += i;
        }
        return answer;
    }
}