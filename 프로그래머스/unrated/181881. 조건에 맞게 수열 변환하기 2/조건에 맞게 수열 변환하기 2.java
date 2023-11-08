import java.util.*;
class Solution {
    int len;
    int[] run(int[] temp){
        for(int i = 0; i < len; i++){
                if(temp[i] >= 50 && temp[i] % 2 == 0) temp[i] /= 2;
                else if(temp[i] < 50 && temp[i] % 2 == 1)temp[i] = temp[i] * 2 + 1;
        }
        return temp;
    }
    boolean check(int[] arr, int[] temp){
        for(int i = 0; i < len; i++){
            if(arr[i] != temp[i]) return false;
        }
        return true;
    }

    public int solution(int[] arr) {
        this.len = arr.length;
        int[] temp = Arrays.copyOf(arr, len);
        int answer = 0;
        while(true){
            temp = run(temp);
            if(check(arr, temp)) break;
            answer++;
            arr = Arrays.copyOf(temp, len);
        }
        
        return answer;
    }
}