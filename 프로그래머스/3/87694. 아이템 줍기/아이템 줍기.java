import java.util.*;
class Solution {
    final int MAX = 102;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    boolean[][] map = new boolean[MAX][MAX];
    boolean[][] isEdge = new boolean[MAX][MAX];
    boolean[][] visited = new boolean[MAX][MAX];
    
    void fill(int[] arr){
        for(int i = arr[0]*2; i <= arr[2]*2;i++){
            for(int j = arr[1]*2; j <= arr[3]*2; j++){
                map[i][j] = true;
            }
        }
    }
    
    void erase(int[] arr){
        for(int i = arr[0]*2 + 1; i < arr[2]*2;i++){
            for(int j = arr[1]*2 + 1; j < arr[3]*2; j++){
                map[i][j] = false;
            }
        }
    }
    
    boolean outOfMap(int x, int y){
        return x < 0 || x >= MAX || y < 0 || y >= MAX;
    }
    
    void checkEdge(){
        for(int x = 0; x < MAX; x++){
            for(int y = 0; y < MAX; y++){
                if(!map[x][y])continue;
                
                for(int d = 0; d < 4; d++){
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if(outOfMap(nx, ny))continue;
                    if(map[nx][ny])continue;
                    isEdge[x][y] = true;
                    break;
                }
            }
        }
    }
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        
        for(int[] arr : rectangle) fill(arr);
        for(int[] arr : rectangle) erase(arr);
        checkEdge();
        
        Queue<int[]> queue = new ArrayDeque<>();
        
        queue.offer(new int[] {characterX, characterY, 0});
        int ans = 0;
        
  
        visited[characterX][characterY] = true;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            if(cur[0] == itemX && cur[1] == itemY){
                ans = cur[2] / 2;
                break;
            }
            for(int d = 0; d < 4; d++){
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                
                if(outOfMap(nx, ny))continue;
                if(visited[nx][ny])continue;
                if(!map[nx][ny])continue;
                visited[nx][ny] = true;
                queue.offer(new int[] {nx, ny, cur[2] + 1});
            }
        }
        
        
        return ans;
    }
}