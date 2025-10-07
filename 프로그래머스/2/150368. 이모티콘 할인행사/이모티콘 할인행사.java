import java.util.*;

class Solution {
    static int[] sales;
    static int N, M;
    static int[][] users;
    static int[] emoticons, costs, answer;
    
    static void search(int idx){
        if(idx >= M) {
            costs = new int[N];
            for(int i = 0; i < N; i++){
                for(int m = 0; m < M; m++){
                    if(users[i][0] <= sales[m]){
                        costs[i] += (emoticons[m] - (emoticons[m] / 100 * sales[m]));
                    }
                }
            }
            int sub = 0;
            int total = 0;
            for(int i = 0; i < N; i++){
                if(costs[i] >= users[i][1]) sub++;
                else total += costs[i];
            }
            

            if(answer[0] <= sub){
                if(answer[0] == sub) answer[1] = Math.max(total, answer[1]);
                else{
                    answer[0] = sub;
                    answer[1] = total;   
                }
            }
            return ;
            
        }
    
        for(int i = 0; i <= 40; i += 10){
            sales[idx] = i;
            search(idx + 1);
        }
    }
    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2];
        
        N = users.length;
        M = emoticons.length;
        sales = new int[M];
        this.users = users;
        this.emoticons = emoticons;
        this.costs = new int[N];
        
        search(0);
        
        return answer;
    }
}