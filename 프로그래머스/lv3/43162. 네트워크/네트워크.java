import java.util.*;
class Solution {
    
    int computerNum;
    int answer;
    void search(int node, int[][] network,boolean[] visited) {
        visited[node] = true;

        for(int Index = 0; Index < computerNum;Index++){
            if(visited[Index] == false && network[node][Index] == 1){
                search(Index, network, visited);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        computerNum = computers.length;
        boolean[] visited = new boolean[computerNum];
        int[][] network = new int[computerNum][computerNum];

        for(int i = 0; i < computers.length; i++){
            if(visited[i] == false){
                answer++;
                search(i,computers,visited);
            }            
        }
        return answer;
    }
}