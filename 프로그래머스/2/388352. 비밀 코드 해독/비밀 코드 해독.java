// 8:34 시작
import java.util.*;
class Solution {
    int[] selected, ans;
    boolean[] visited;
    int n;
    int[][] q;
    int answer = 0;
    void search(int depth, int start){
        if(depth == 5){
            if(check()) answer++;
            return ;
        }

        for(int i = start; i <= n; i++){
            selected[depth] = i;
            search(depth + 1, i + 1);
        }
    }
    boolean check(){
        int idx = 0;
        for(int[] info : q){
            int temp = 0;
            for(int n : info){
                for(int i = 0; i < 5;i++){
                    if(selected[i] == n)temp++;
                }
            }
            if(temp != ans[idx++]) return false;
        }
        return true;
    }
    public int solution(int n, int[][] q, int[] ans) {
        this.ans = ans;
        this.q = q;
        this.n = n;
        visited = new boolean[n + 1];
        selected = new int[5];
        search(0, 1);
        return answer;
    }
}