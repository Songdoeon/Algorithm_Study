import java.util.*;
class Solution{
    boolean sub(String str, int start, int end){
        while(start <= end){
            if(str.charAt(start++) != str.charAt(end--)) return false;
        }
        return true;
    }
    public int solution(String s){
        int answer = 1;
        int len = s.length();
        
        for(int idx = len; idx > 0; idx--){
            for(int idx2 = 0; idx2 <= len - idx; idx2++){
                if(sub(s, idx2, idx + idx2 - 1)) return idx;
            }
        }
        return answer;
    }
}