import java.util.*;
class Solution {
    int[] dX = new int[] {1,-1,0,0};
    int[] dY = new int[] {0,0,1,-1};
    int cX;
    int cY;
    int[] start;
    int[] exit;
    int[] lever;
    int answer = 0;
    boolean light = false;
    public int solution(String[] maps) {
        Character[][] map = new Character [maps.length][maps[0].length()];
        int[][] visited = new int [maps.length][maps[0].length()];
        Queue<int[]> point = new LinkedList<>();
        
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[i].length();j++){
                switch(maps[i].charAt(j)){
                    case 'S' : {start = new int[] {i,j};break;}
                    case 'L' : {lever = new int[] {i,j};break;}
                    case 'E' : {exit = new int[] {i,j};break;}
                }
                map[i][j]=maps[i].charAt(j);
            }
        }
        point.add(new int[] {start[0],start[1]});
        
        while(!point.isEmpty()){
            int[] p = point.poll();
            
            cX = p[0];
            cY = p[1];
            for(int i=0;i<4;i++){
                int nX = cX+dX[i];
                int nY = cY+dY[i];
                if(nX<0 || nX >=maps.length || nY<0 || nY >=maps[0].length()){
                    continue;
                }
                if(visited[nX][nY] == 0 && map[nX][nY] == 'L'){
                    point.clear();
                    point.add(new int[]{nX, nY});
                    answer += visited[cX][cY];
                    for(int j=0;j<visited.length;j++){
                        Arrays.fill(visited[j],0);
                    }
                    visited[nX][nY]=1;
                    light = true;
                    break;
                }
                if(visited[nX][nY] == 0 && map[nX][nY] !='X'){ 
                    visited[nX][nY] = visited[cX][cY]+1;
                    point.add(new int[] {nX,nY});
                }
                if(map[nX][nY] == 'E' && light == true){
                    return visited[nX][nY]+answer;
                }
            }
        }
        return -1;
    }
}