import java.util.*;
class Solution {
    public int[] solution(int[][] score) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] answer = new int[score.length]; 
        int[][] arr = score.clone();
        
        Arrays.sort(arr, (o1, o2) -> (o2[0] + o2[1]) - (o1[0] + o1[1]));
        
        for(int i = 0; i < arr.length; i++){
            int avg = arr[i][0] + arr[i][1];
            if(!map.containsKey(avg)) map.put(arr[i][0] + arr[i][1], i + 1);
        }
        
        for(int i = 0 ; i< arr.length; i++){
            answer[i] = map.get(score[i][0] + score[i][1]);
        }
        
        return answer;
    }
}