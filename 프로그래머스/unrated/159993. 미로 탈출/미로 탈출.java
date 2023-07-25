import java.util.*;
class Solution {
    int[] dX = new int[] {1,-1,0,0};
    int[] dY = new int[] {0,0,1,-1};
    int[] start;
    int[] lever;
    int[] exit;
    int answer = 0;
    boolean s = false;
    public int solution(String[] maps) {
        int xLen = maps[0].length();
        int yLen = maps.length;
        Character[][] map = new Character[yLen][xLen];
        int[][] visited = new int[yLen][xLen];
        Queue<int[]> point = new LinkedList<>();
        
        for(int idx = 0; idx < yLen;idx++){
            for(int idx2 = 0; idx2 < xLen; idx2++){
                Character c = maps[idx].charAt(idx2);
                switch(c){
                    case 'S' : {start = new int[] {idx,idx2};break;}
                    case 'L' : {lever = new int[] {idx,idx2};break;}
                    case 'E' : {exit = new int[] {idx,idx2};break;}
                }
                map[idx][idx2] = c;
            }
        }
        point.add(start);
        
        while(!point.isEmpty()){
            int[] land = point.remove();
            int cx = land[0];
            int cy = land[1];
            for(int i = 0; i < 4;i++){
                int x = cx + dX[i];
                int y = cy + dY[i];
                
                if(x < 0 || x >= yLen || y < 0 || y >= xLen) continue;
                
                if(visited[x][y] == 0 && map[x][y] == 'L'){ 
                    point.clear();
                    point.add(new int[] {x,y});
                    answer += visited[cx][cy];
                    for(int j=0;j<visited.length;j++){
                        Arrays.fill(visited[j],0);
                    }
                    visited[x][y]=1;
                    s = true;
                    break;
                }
                if(visited[x][y] == 0 && map[x][y] !='X'){ 
                    visited[x][y] = visited[cx][cy]+1;
                    point.add(new int[] {x,y});
                }
                
                if(map[x][y] == 'E' && s){
                    System.out.println(visited[x][y]);
                    return visited[x][y]+answer;
                }
            }
        }
        return -1;
    }
}