import java.util.*;
class Solution {
    public String solution(String s) {
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        String[] args = s.split("");
        Arrays.sort(args,(o1,o2) -> o2.compareTo(o1));
        
        for(int idx = 0; idx < length; idx++){
            sb.append(args[idx]);
        }
        System.out.println(sb.toString());
        
        return sb.toString();
    }
}