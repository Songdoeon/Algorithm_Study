import java.util.*;
class Solution {
    int[] dx = new int[] {1, 0, -1, 0};
    int[] dy = new int[] {0, 1, 0, -1};
    int width, height;
    boolean outOfMap(int x, int y){
        if(x < 0 || x >= width || y < 0 || y >= height) return true;
        return false;
    }
    public int solution(int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        width = maps.length;
        height = maps[0].length;
        int answer = 0;
        int[][] visited = new int[width][height];
        queue.add(new int[] {0, 0});
        visited[0][0] = 1;
        while(!queue.isEmpty()){
            int[] point = queue.remove();
            
            for(int i = 0; i < 4; i++){
                int nX = point[0] + dx[i];
                int nY = point[1] + dy[i];
                
                if(outOfMap(nX, nY)) continue;
                if(nX<0 || nX>=width || nY<0 || nY>=height)continue;
                if(maps[nX][nY] == 0) continue;
                
                if(visited[nX][nY] == 0){
                    visited[nX][nY] = visited[point[0]][point[1]] + 1;
                    queue.add(new int[] {nX, nY});
                }
            }
            
        }
        
        return visited[width - 1][height - 1] != 0 ? visited[width - 1][height - 1] : -1;
    }
}