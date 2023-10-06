import java.util.*;
class Solution {
    boolean check(int[] stones, int mid, int k){
        int num = 0;
        for(int stone : stones){
            if(stone - mid < 0){
                num ++;
            }
            else num = 0;
            if(num == k) return false;
        }
        return true;
    }
    public int solution(int[] stones, int k) {
        int answer = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int stone : stones){
            min = Math.min(min, stone);
            max = Math.max(max, stone);
        }
        int mid = 0;
        while(min <= max){
            mid = (min + max) / 2;
            if(!check(stones, mid, k)){
                max = mid - 1;
            }
            else {
                answer = Math.max(answer, mid); 
                min = mid + 1;
            }
        }
        
        return answer;
    }
}