import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        if(n > s) return new int[] {-1};
        int[] answer = new int[n];
        for(int idx = 0; idx < n; idx++){
            answer[idx] = s/n;
        }
        for(int idx = 0; idx < s%n ; idx++){
            answer[idx]++;
        }
        Arrays.sort(answer);
        return answer;
    }
}