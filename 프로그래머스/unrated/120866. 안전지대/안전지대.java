class Solution {
    boolean[][] visited;
    int len;
    boolean outOfMap(int x, int y){
        if(x < 0 || x >= len || y < 0 || y >= len) return true;
        return false;
    }
    void search(int x, int y){
        for(int i = x - 1; i <= x + 1 ; i++){
            for(int j = y - 1; j <= y + 1;j++){
                if(outOfMap(i,j)) continue;
                visited[i][j] = true;
            }
        }
    }
    public int solution(int[][] board) {
        int answer = 0;
        len = board.length;
        visited = new boolean[len][len];
        
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                if(board[i][j] == 1) search(i,j);
            }
        }
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                if(visited[i][j] == false) answer++;
            }
        }
        return answer;
    }
}