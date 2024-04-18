import java.util.*;
class Solution {
    int n;
    int[] times;

    long isPassed(long num){
        long sum = 0;
        for(int time : times){
            sum += num / time;
        }
        return sum;
    }
    public long solution(int n, int[] times) {
        this.times = times;
        this.n = n;
        long start = 0;
        long end = 1_000_000_000_000_000_000L;
        
        while(start < end){
            long mid = (start + end) / 2;
            long result = isPassed(mid);
            if(n <= result){
                end = mid;
            }
            else{
                start = mid + 1;
            }
        }
        return end;
    }
}