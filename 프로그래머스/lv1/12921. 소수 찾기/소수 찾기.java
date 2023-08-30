class Solution {
    boolean isPassed(int n){
        int end = (int) Math.sqrt(n);
        for(int i = 2; i <= end; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
    public int solution(int n) {
        int answer = 0;
        for(int idx = 2; idx <= n; idx++){
            if(isPassed(idx)) answer++;
        }
        return answer;
    }
}