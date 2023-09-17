import java.util.*;
class Solution {
    public int solution(int[][] lines) {
        int[] line = new int[200];
        int answer = 0;
        
        for(int[] arr : lines){
            int start = arr[0] + 100;
            int end = arr[1] + 100;
            
            for(int i = start; i < end; i++){
                line[i]++;
            }
        }
        return (int) Arrays.stream(line).filter(i -> i >= 2).count();
    }
}