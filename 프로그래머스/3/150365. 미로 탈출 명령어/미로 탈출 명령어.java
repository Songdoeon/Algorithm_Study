import java.util.*;
class Solution {
    int[] dx = new int[] {1, 0, 0, -1};
    int[] dy = new int[] {0, -1, 1, 0};
    char[] dir = new char[] {'d', 'l', 'r', 'u'};
    char[][] map;
    String answer = "impossible";
    StringBuilder sb = new StringBuilder();
    int r;
    int c;
    boolean reachable(int x, int y, int times){
        int distance = Math.abs(r - x) + Math.abs(y - c);
        if(times < distance)return false;
        return true;
    }
    
    boolean outOfMap(int x, int y){
        if(x < 0 || x >= map.length || y < 0 || y >=map[0].length) return true;
        return false;
    }
    
    void search(int x, int y, int depth, int k){
        if(!answer.equals("impossible")) return;
        if(depth > k) return ;
        if(depth == k && x == r && y == c) {
            answer = sb.toString();
            return ;
        }
        
        for(int i = 0; i < 4; i++){
            int cX = x + dx[i];
            int cY = y + dy[i];
            if(outOfMap(cX, cY)) continue;
            if(!reachable(cX, cY, k - depth)) continue;
            
            sb.append(dir[i]);
            search(cX, cY, depth + 1, k);
            sb.delete(depth, depth+1);
        }
    }
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        this.r = r - 1;
        this.c = c - 1;
        map = new char[n][m];
        if(reachable(x-1, y-1, 0)) return answer;
        
        int d = Math.abs((x - r)) + Math.abs(y - c);
        if(d % 2 != k % 2) return answer;
        search(x - 1, y - 1, 0, k);
        
        return answer;
    }
}