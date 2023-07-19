import java.util.*;
class Solution {
    int len;
    long answer = Long.MAX_VALUE;
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        len = times.length;
        BinarySearch(times,n);
        return answer;
    }
    void BinarySearch(int[] times, int n){
        long left = 1, right = (long)n*times[len-1];
        while(left < right){
            long mid = (left+ right)/ 2;
            // System.out.println(mid);
            if(isPassed(n,times,mid)){
                answer = Math.min(answer,mid);
                right = mid;
            }
            else left = mid + 1;
        }
    }
    boolean isPassed(int n, int[] times, long mid){
        long sum = 0;
        for(int Index=0; Index < len; Index++){
            sum += mid/times[Index];
        }
        if(sum >= n) return true;
        else return false;
    }
}