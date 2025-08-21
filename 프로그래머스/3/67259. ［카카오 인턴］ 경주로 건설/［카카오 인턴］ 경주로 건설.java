import java.util.*;
class Pos{
    int x, y, d, c;
    
    Pos(int x, int y, int d, int c){
        this.x = x;
        this.y = y;
        this.d = d;
        this.c = c;
    }
}
class Solution {
    static int N, M;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0 , -1};
    static int[][][] visited;
    
    static boolean outOfMap(int x, int y){
        return x < 0 || x >= N || y < 0 || y >= M;
    }
    
    static int calc(int total, int cur, int next){
        if(cur == -1) return 1;
        if(cur == 0 || cur == 2){
            if(next == 1 || next == 3) return total + 6;
            return total + 1;
        }
        else if(next == 0 || next == 2) return total + 6;
        
        return total + 1;
        
    }
    public int solution(int[][] board) {
        N = board.length;
        M = board[0].length;
        visited = new int[N][M][4];
        int answer = Integer.MAX_VALUE;
        
        Queue<Pos> queue = new PriorityQueue<>((a, b) -> a.c - b.c);
        queue.offer(new Pos(0, 0, -1, 0));
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++){
            Arrays.fill(visited[i][j], Integer.MAX_VALUE);    
            }

    
        }
        while(!queue.isEmpty()){
            Pos cur = queue.poll();
            // System.out.println(cur.x + " : " + cur.y + " : " + cur.d + " = " + cur.c);
            if(cur.x == N - 1 && cur.y == M - 1){
                answer = Math.min(answer, cur.c);

            }
            for(int d = 0; d < 4; d++){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                
                if(outOfMap(nx, ny)) continue;
                if(board[nx][ny] == 1) continue;
                int cost = calc(cur.c, cur.d, d);      
                
                if(visited[nx][ny][d] > cost){
                    visited[nx][ny][d] = cost;
                    queue.offer(new Pos(nx, ny, d, cost));
                }
            }
        }
        
        return answer * 100;
    }
}