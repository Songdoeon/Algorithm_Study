import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(String X, String Y) {
        List<Integer> list = new LinkedList<>();
        int[][] arr = new int[2][10];
        int longLength = Math.max(X.length(),Y.length());
        int shortLength = Math.min(X.length(),Y.length());
        
        for(int i = 0; i < longLength ;i++){
            if(X.length()>i)arr[0][X.charAt(i)-'0']++;
            if(Y.length()>i)arr[1][Y.charAt(i)-'0']++;
        }
        for(int i = 9; i >= 0; i--){
            int min = Math.min(arr[0][i],arr[1][i]);
            for(int j = 0;j <min;j++){
                list.add(i);    
            }
        }
        int listLen = list.size();
        if(listLen==0)return "-1";
        if(list.get(0)==0) return "0";
        StringBuilder sb = new StringBuilder();
        for(Integer i :list){
            sb.append(i);
        }
        return sb.toString();
    }
}