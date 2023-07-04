import java.util.*;
class Solution {
    boolean solution(String s) {
        int count = 1;
        boolean answer = true;

        Stack<Integer> stack = new Stack<>(); 
        
        if(s.charAt(0)==')')return false;
        
        for(int i=1;i<s.length();i++){
            if(count<0) return false;
            if(s.charAt(i)=='(')count++;
            else if (s.charAt(i)==')')count--;
        }
        if(count==0)return true;
        return false;
    }
}