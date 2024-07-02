import java.util.*;
class Solution {
    public String solution(String my_string, int[] index_list) {
        StringBuilder sb = new StringBuilder();
        
        int len = index_list.length;
        for(int i = 0; i < len; i++){
            sb.append(my_string.charAt(index_list[i]));
        }
        return sb.toString();
    }
}