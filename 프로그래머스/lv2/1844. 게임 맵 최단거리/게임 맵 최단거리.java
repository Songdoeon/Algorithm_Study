import java.util.*;
class Solution {
    int[] dx = {1, 0, -1, 0};
     int[] dy = {0, 1, 0, -1};
     int cX = 0;
     int cY = 0;
     int[] current = new int[2];
    public int solution(int[][] maps) {
        int answer = 0;
        int[][] visited = new int[maps.length][maps[0].length];
        Queue<int[]> queue = new LinkedList<>();
        
        int x = 0;
        int y = 0;
        visited[x][y] = 1;
        
        queue.add(new int[]{x, y});
        
        while(!queue.isEmpty()){
            current = queue.remove();
            cX = current[0];
            cY = current[1];
            
            for(int i=0;i<4;i++){
                int nX = cX+dx[i];
                int nY = cY+dy[i];
                
                if(nX<0 || nX>=maps.length || nY<0 || nY>=maps[0].length)
                    continue;
                
                if(visited[nX][nY] == 0 && maps[nX][nY] == 1){
                    visited[nX][nY] = visited[cX][cY] + 1;
                    queue.add(new int[]{nX, nY});
                }
            }
        }
        answer = visited[maps.length-1][maps[0].length-1];
        if(answer == 0){
            answer = -1;
        }
        return answer;
    }
}