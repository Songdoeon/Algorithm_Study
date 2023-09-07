class Solution {
    long check(long num, int k){
        return ((long) Math.sqrt(num) / (long) k ) + 1;
    }
    public long solution(int k, int d) {
        long answer = d / k + 1;
        for(int i = k; i <= d; i += k){
            answer += check((long) d * d - (long) i * i, k);
        }
        return answer;
    }
}