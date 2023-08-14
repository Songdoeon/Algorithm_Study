class Solution {
    public int solution(int n) {
        int answer = n;
        for(int idx = 1; idx <= n/2; idx++){
            if(n % idx == 0) answer += idx;
        }
        return answer;
    }
}