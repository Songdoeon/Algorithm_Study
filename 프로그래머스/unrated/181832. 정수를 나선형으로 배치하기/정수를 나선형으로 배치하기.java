class Solution {
    int[] dx = new int[] {0,1,0,-1};
    int[] dy = new int[] {1,0,-1,0};
    
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int value = 2;
        int start = 0;
        int end = 0;
        int index = 0;
        int col = 0;
        answer[0][0] = 1;
        while(value <= n * n){
            start += dx[index % 4];
            end += dy[index % 4];
            if(start < 0 || end < 0 || start == n || end == n ||
              answer[start][end] != 0) {
                start -= dx[index % 4];
                end -= dy[index % 4];
                index++;
                continue;
            }
            answer[start][end] = value++;
        }
        return answer;
    }
}