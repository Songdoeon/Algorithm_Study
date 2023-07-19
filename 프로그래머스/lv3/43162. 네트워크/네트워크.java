import java.util.*;
class Solution {
    
    int computerNum;
    int answer;
    int[][] computers;
    void search(int node,boolean[] visited) {
        visited[node] = true;
        
        for(int Index = 0; Index < computerNum;Index++){
            if(visited[Index] == false && computers[node][Index] == 1){
                search(Index, visited);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        computerNum = computers.length;
        this.computers = computers;
        boolean[] visited = new boolean[computerNum];
        
        for(int i = 0; i < computers.length; i++){
            if(visited[i] == false){
                answer++;
                search(i,visited);
            }            
        }
        
        return answer;
    }
}