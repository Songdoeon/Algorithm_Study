import java.util.*;
class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int num = 101;
        Arrays.sort(array);
        for(int i : array){
            int abs = Math.abs(n-i);
            if(num > abs){
                num = abs;
                answer = i;
            }
        }
        return answer;
    }
}