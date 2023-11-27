import java.util.*;
class Solution {
    int[] info;
    int[][] edges;
    int len;
    int maxSheep = 0;
    
    void search(boolean[] visited, int index, int sheep, int wolf){
        visited[index] = true;
        if (info[index] == 0) sheep++;
        else wolf++;
        if(wolf >= sheep) return ;
        if(sheep > maxSheep) maxSheep = sheep;
        
        
        for(int[] tempEdge : edges){
            if (visited[tempEdge[0]] && !visited[tempEdge[1]]) {
                boolean[] nextVisited = new boolean[visited.length];
                for (int i = 0; i < visited.length; i++) {
            	    nextVisited[i] = visited[i];
        	    }
                search(nextVisited, tempEdge[1], sheep, wolf);
            }
        }
        
    }
    
	public int solution(int[] info, int[][] edges) {
        this.info = info;
        this.edges = edges;
        this.len = info.length;
        boolean[] visited = new boolean[len];
		search(visited, 0, 0, 0);
        
		return maxSheep;
	}
}