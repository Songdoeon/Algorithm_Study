import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        boolean[] visited = new boolean[n + 1];
        boolean[][] connect = new boolean[n + 1][n + 1];
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < edge.length; i++){
            connect[edge[i][0]][edge[i][1]]=true;
            connect[edge[i][1]][edge[i][0]]=true;
        }
        int depth = 0;
        visited[1] = true;
        queue.add(1);
        int answer = 0;
        while(!queue.isEmpty()){
            answer = queue.size();
            for(int j = 0; j < answer; j++){
                int node = queue.remove();
                for(int i = 1; i <= n; i++){
                    if(connect[node][i] == true && !visited[i]) {
                        queue.add(i);
                        visited[i] = true;
                    }
                }
            }
        }
        return answer;
    }
}