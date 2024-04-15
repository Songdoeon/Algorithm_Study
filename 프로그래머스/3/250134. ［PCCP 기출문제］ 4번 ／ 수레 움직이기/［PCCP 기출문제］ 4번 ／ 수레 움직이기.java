import java.util.*;
class Solution {
    int[] dx = new int[] {1, 0 , -1, 0};
    int[] dy = new int[] {0, 1 , 0, -1};
    int[][] maze;
    int xLen, yLen;
    int[] rStart, rEnd, bStart, bEnd;
    boolean[][] rVisited, bVisited;
    int answer = Integer.MAX_VALUE;
    boolean outOfMap(int x, int y){
        if(x < 0 || x >= xLen || y < 0 || y >= yLen) return true;
        return false;
    }
    
    boolean isArrived(int[] point, int[] end){
        if(point[0] == end[0] && point[1] == end[1]) return true;
        return false;
    }
    
    void search(int depth, int[] rPoint, int[] bPoint, boolean rFinished, boolean bFinished){
        if(rFinished && bFinished){
            answer = Math.min(depth, answer);
            
            return ;
        }
        if(bFinished) {
            bPoint[0] = bEnd[0]; 
            bPoint[1] = bEnd[1]; 
        }
            for(int i = 0;i < 4; i++){
                int rX = rPoint[0] + dx[i];
                int rY = rPoint[1] + dy[i];
                
                int[] newR = new int[] {rX, rY};
                
                if(rFinished) {
                    newR[0] = rEnd[0];
                    newR[1] = rEnd[1];
                }
                else{

                    if(outOfMap(rX, rY) || rVisited[rX][rY]) continue;
                    if(maze[rX][rY] == 5) continue;
                }
                
                for(int j = 0; j < 4; j++){
                    int bX = bPoint[0] + dx[j];
                    int bY = bPoint[1] + dy[j];  
                    int[] newB = new int[] {bX, bY};
                    if(bFinished) {
                        newB[0] = bEnd[0]; 
                        newB[1] = bEnd[1]; 
                    }
                    else{
                        if(outOfMap(bX, bY) || bVisited[bX][bY]) continue;
                        if(maze[bX][bY] == 5) continue;               
                    }
                    if(isArrived(newB,newR)) continue;
                    if(isArrived(rPoint, newB) && isArrived(newR, bPoint)) continue;
                    rVisited[newR[0]][newR[1]] = true;
                    bVisited[newB[0]][newB[1]] = true;
                    
                    boolean newRF = false;
                    boolean newBF = false;
                    if(isArrived(newR, rEnd) || rFinished) newRF = true;
                    if(isArrived(newB, bEnd) || bFinished) newBF = true;
                    search(depth + 1, newR, newB, newRF, newBF);
                    
                    rVisited[newR[0]][newR[1]] = false;
                    bVisited[newB[0]][newB[1]] = false;
                }
            }

    }

    public int solution(int[][] maze) {
        yLen = maze[0].length;
        xLen = maze.length;
        this.maze = maze;
        rVisited = new boolean[xLen][yLen];
        bVisited = new boolean[xLen][yLen];
        
        for(int i = 0; i < xLen; i++){
            for(int j = 0; j < yLen; j++){
                switch(maze[i][j]){
                    case 1 : rStart = new int[] {i, j};break;
                    case 2 : bStart = new int[] {i, j};break;
                    case 3 : rEnd = new int[] {i, j};break;
                    case 4 : bEnd = new int[] {i, j};break;
                }
            }
        }
        rVisited[rStart[0]][rStart[1]] = true;
        bVisited[bStart[0]][bStart[1]] = true;        
        
        
        search(0, rStart, bStart, false, false);
        
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}