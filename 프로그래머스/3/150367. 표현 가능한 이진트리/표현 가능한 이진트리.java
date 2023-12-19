import java.util.*;
class Solution {
    
    boolean[] arr;
    int[] answer;

    void search(int start, int end, int index, boolean parent){
        if(start > end) return ;
        
        int mid = (start + end) / 2;

        if(arr[mid] && !parent){
            answer[index] = 0;
            return ;
        }
        
        search(start, mid - 1,index, arr[mid]);
        search(mid + 1, end,index, arr[mid]);
        
    }
    public int[] solution(long[] numbers) {
        answer = new int[numbers.length];
        Arrays.fill(answer, 1);
        int index = 0;
        for(long number : numbers){
            String binary = Long.toBinaryString(number);
            int binaryLen = binary.length();
            int level = 1;
            int arrLen = 0;
            while(arrLen < binaryLen){
                arrLen = (int) Math.pow(2, level++) - 1;
            }
            
            arr = new boolean[arrLen];
            
            for(int i = arrLen - 1; i >= 0; i--){
                if(binaryLen == 0) break;
                if(binary.charAt(--binaryLen) == '0') arr[i] = false;
                else arr[i] = true;
            }

            int mid = arrLen / 2;

            if(!arr[mid]){
                answer[index++] = 0;
                continue;
            } 
            search(0, arrLen - 1, index++, true);
            
        }
        
        
        return answer;
    }
}