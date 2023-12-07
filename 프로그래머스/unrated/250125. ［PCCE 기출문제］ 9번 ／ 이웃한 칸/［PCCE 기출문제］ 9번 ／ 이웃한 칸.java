class Solution {
    int[] dx = new int[] {1, 0, -1, 0};
    int[] dy = new int[] {0, 1, 0, -1};
    int height;
    int width;
    
    boolean outOfMap(int x, int y){
        if(x < 0 || x >= height || y < 0 || y >= width) return true;
        return false;
    }
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        height = board.length;
        width = board[0].length;
        String color = board[h][w];
        for(int i = 0; i < 4; i++){
            int nX = h + dx[i];
            int nY = w + dy[i];
            if(outOfMap(nX, nY)) continue;
            if(color.equals(board[nX][nY])) answer++;
        }
        return answer;
    }
}