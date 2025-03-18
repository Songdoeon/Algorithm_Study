import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int len = players.length;
        int[] arr = new int[len];
        Arrays.fill(arr, m - 1);
        for(int i = 0; i < len; i++){
            int temp = 0;
            while(arr[i] < players[i]){
                temp++;
                arr[i] += m;
            }
            for(int j = 1; j < k; j++){
                if(i + j < len)
                    arr[i + j] += temp * m;
            }
            answer += temp;
        }
        // System.out.println(Arrays.toString(arr));
        return answer;
    }
}