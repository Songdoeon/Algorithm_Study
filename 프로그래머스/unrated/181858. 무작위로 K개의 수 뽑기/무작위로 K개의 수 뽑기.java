import java.util.*;
class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        Arrays.fill(answer, -1);
        int[] temp = Arrays.stream(arr).distinct().toArray();
        int index = 0;
        for(int num : temp){
            answer[index++] = num;
            if(index >= k) break;
        }
        return answer;
    }
}