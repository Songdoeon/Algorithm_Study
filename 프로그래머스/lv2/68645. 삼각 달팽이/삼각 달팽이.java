import java.util.*;
class Solution {
    int[] dx = new int[] {1,0,-1};
    int[] dy = new int[] {0,1,-1};
    
    public int[] solution(int n) {
        int[][] answer = new int[n][n];
        List<Integer> list = new ArrayList<>();
        
        int value = 2;
        int start = 0;
        int end = 0;
        int index = 0;
        answer[0][0] = 1;
        while(value <=  n * (n + 1) / 2){
            start += dx[index % 3];
            end += dy[index % 3];
            if(start < 0 || end < 0 || start == n || end == n ||
              answer[start][end] != 0) {
                start -= dx[index % 3];
                end -= dy[index % 3];
                index++;
                continue;
            }
            answer[start][end] = value++;
        }
        for(int[] col : answer){
            for(int num : col){
                if(num != 0) list.add(num);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}