import java.util.*;
class Solution {
    int[] dx = new int[] {1, 0, -1, 0};
    int[] dy = new int[] {0, 1, 0, -1};
    Map<Integer, Integer> map = new HashMap<>();
    
    int answer = 0;
    int[][] land;
    int xLen , yLen;
    boolean[][] visited;
    boolean outOfMap(int x, int y){
        if(x < 0 || x >= xLen || y < 0 || y >= yLen) return true;
        return false;
    }
    void search(int amount, int x, int y){
        visited[x][y] = true;
        // List<Integer> list = new ArrayList<>();
        int min = y;
        int max = y;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        while(!queue.isEmpty()){
            int[] point = queue.poll();
            amount++;
            min = Math.min(min, point[1]);
            max = Math.max(max, point[1]);
            for(int i = 0; i < 4; i++){
                int nX = point[0] + dx[i];
                int nY = point[1] + dy[i];
                if(outOfMap(nX, nY)) continue;
                if(visited[nX][nY]) continue;
                if(land[nX][nY] == 0) continue;
                
                visited[nX][nY] = true;
                // if(!list.contains(nY)) list.add(nY);
                queue.add(new int[] {nX, nY});
            }
            
        }
        for(int i = min; i <= max; i++)map.put(i, map.getOrDefault(i, 0) + amount);
        // for(int mapY : list){
        //     map.put(mapY, map.getOrDefault(mapY, 0) + amount);
        // }
    }
    
    public int solution(int[][] land) {
        this.land = land;
        xLen = land.length;
        yLen = land[0].length;
        
        visited = new boolean[xLen][yLen];
        for(int j = 0; j < yLen;j++){
            for(int i = 0; i < xLen; i++){
                if(land[i][j] != 0 && !visited[i][j]) search(0, i, j);
            }
        }

        return map.values().stream().mapToInt(i -> i).max().getAsInt();
    }
}