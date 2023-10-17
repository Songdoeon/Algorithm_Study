import java.util.*;
class Solution {
    Character[][] map;
    boolean check(int m, int n){
        for(int i = 0; i < m - 1;i++){
            for(int j = 0; j < n - 1;j++){
                if(map[i][j] == map[i][j+1] && map[i][j] == map[i+1][j] &&
                  map[i][j] == map[i+1][j+1] && map[i][j] != '@') return true;
            }
        }
        return false;
    }
    void union(int m, int n){
        Character[][] result = new Character[m][n];
        for(int i = 0; i < m;i++){
            for(int j = 0; j < n;j++){
                result[i][j] = map[i][j];
            }
        }
        for(int i = 0; i < m - 1;i++){
            for(int j = 0; j < n - 1;j++){
                if(map[i][j] == '@') continue;
                if(map[i][j] == map[i][j+1] && map[i][j] == map[i+1][j] &&
                  map[i][j] == map[i+1][j+1]){
                    result[i][j] = result[i][j+1] = result[i+1][j+1] = result[i+1][j] = '@';
                }
            }
        }
        map = result;
    }
    void rain(int m, int n){
        for(int c = 0 ; c < n ; ++c) {
			for(int r = m - 1 ; r >= 0 ; --r) {
				if(map[r][c] == '@') {
					for(int nr = r - 1 ; nr >= 0 ; --nr) {
						if(map[nr][c] != '@') {
							map[r][c] = map[nr][c];
							map[nr][c] = '@';
							break;
						}
					}
				}
			}
		}
        
    }
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        map = new Character[m][n];
        for(int i = 0; i < m;i++){
            for(int j = 0; j < n;j++){
                map[i][j] = board[i].charAt(j);
            }
        }
        while(check(m, n)){
            union(m, n);
            rain(m, n);
        }
        for(int i = 0; i < m;i++){
            for(int j = 0; j < n;j++){
                System.out.print(map[i][j]);
                if(map[i][j] == '@') answer++;
            }
            System.out.println("");
        }
        return answer;
    }
}