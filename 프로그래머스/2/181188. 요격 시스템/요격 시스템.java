import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);
        int end = 0;
        for(int[] target : targets){
            if(end <= target[0]) {
                answer++;
                end = target[1];
            }
        }
        return answer;
    }
}