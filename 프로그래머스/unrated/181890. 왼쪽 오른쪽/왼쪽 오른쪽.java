import java.util.*;
class Solution {
    public String[] solution(String[] str_list) {
        int l = -1;
        int r = -1;
        int index = 0;
        for(String str : str_list){
            if(str.equals("l")){
                l = index;
                break;
            } 
            if(str.equals("r")) {
                r = index;
                break;
            }
            index++;
        }
        if(l == -1 && r == -1) return new String[] {};
        if(l > r) return Arrays.copyOf(str_list, l);
        return Arrays.copyOfRange(str_list, r + 1, str_list.length);

    }
}