import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        String s = String.valueOf(storey);
        int len = s.length();
        int[] arr = new int[len];
        for(int i = 0; i < len; i++){
            arr[i] = s.charAt(i) - '0';
        }
        while(--len >= 0){
            int n = arr[len];
            // System.out.println(n + " : " + answer);
            if(n == 10){
                if(len == 0) answer++;
                else {
                    arr[len - 1]++;
                }
            }
            else if(n > 5){
                if(len == 0) answer += 10 - n + 1;
                else {
                    answer += 10 - n;
                    arr[len - 1]++;
                }
            }else if(n == 5){
                if(len > 0 && arr[len - 1] >= 5){
                    arr[len - 1]++;
                    answer += 10 - n;
                }
                else answer += n; 
            }
            else answer += n; 
        }
        return answer;
    }
}
// 55 
// 52 7
// 54 9 
// 64 10 10
