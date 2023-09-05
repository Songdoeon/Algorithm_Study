import java.util.*;
class Solution {
    Character[][] map;
    boolean[][] visited;
    int[] dX = new int[] {1,-1,0,0};
    int[] dY = new int[] {0,0,1,-1};
    
    Queue<int[]> queue = new LinkedList<>();
    
    boolean outOfMap(int x, int y){
        if(x < 0 || x >= map.length || y < 0 || y >= map[0].length) return true;
        return false;
    }
    
    int bfs(int[] point){
        int sum = 0;
        int nx = point[0];
        int ny = point[1];
        visited[nx][ny] = true;
        queue.add(new int[] {nx, ny});
        while(!queue.isEmpty()){
            int[] land = queue.remove();
            for(int idx = 0; idx < 4; idx++){
                int x = land[0] + dX[idx];
                int y = land[1] + dY[idx];
                if(!outOfMap(x, y) && map[x][y] != 'X' && !visited[x][y]){
                    queue.add(new int[] {x, y});
                    visited[x][y] = true;
                }
            }
            sum += map[land[0]][land[1]] - '0';
        }
        return sum;
    }
    
    public int[] solution(String[] maps) {
        List<Integer> list = new ArrayList<>();
        map = new Character[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        
        for(int idx = 0; idx < maps.length; idx++){
            for(int idx2 = 0; idx2 < maps[0].length(); idx2++){
                map[idx][idx2] = maps[idx].charAt(idx2);
            }
        }
        
        for(int idx = 0; idx < maps.length; idx++){
            for(int idx2 = 0; idx2 < maps[0].length(); idx2++){
                if(!visited[idx][idx2] && map[idx][idx2] != 'X') {
                    int large = bfs(new int[] {idx, idx2});
                    if(large != 0)list.add(large);
                }
            }
        }
        
        if(list.size() == 0) return new int[] {-1};
        
        return list.stream().sorted().mapToInt(i -> i).toArray();
    }
}