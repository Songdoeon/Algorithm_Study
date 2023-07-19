import java.util.*;
class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int len = land.length;
        int sum = 0, max = 0, index = 0;
        
        for(int row = 1;row < len;row++){
            for(int column = 0;column < 4;column++){
                max = search(land[row-1],column);
                land[row][column] += max;
            }
        }
        int[] lastLand = land[len-1];
        Arrays.sort(lastLand);
        return lastLand[3];
    }
    int search(int[] arr, int index){
        int max = 0;
        for(int idx = 0; idx < 4; idx++){
            if(idx != index){
                max = Math.max(max,arr[idx]);
            }
        }
        return max;
    }
}