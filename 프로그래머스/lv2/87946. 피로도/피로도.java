class Solution {
    int answer = 0;
    int[][] dungeons;
    void search(int k,int count,int[] visited){
        for(int i=0;i<visited.length;i++){
            answer = Math.max(count,answer);
            if(answer==visited.length) return;
            if(dungeons[i][0]>k || dungeons[i][1]>k){
                continue;
            }
            if(visited[i]==0){
                visited[i] = 1;
                search(k-dungeons[i][1],count+1,visited);
                visited[i] = 0;
            }
        }
        
    }
    public int solution(int k, int[][] dungeons) {
        int[] visited = new int[dungeons.length];
        this.dungeons = dungeons;
        
        search(k,0,visited);

        return answer;
    }
}