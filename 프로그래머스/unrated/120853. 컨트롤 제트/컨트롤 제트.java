import java.util.*;
class Solution {
    public int solution(String s) {
        Stack<Integer> stack = new Stack<>();
        String[] args = s.split(" ");
        int answer = 0;
        for(String arg : args){
            if(arg.equals("Z")) answer -= stack.peek();
            else {
                int num = Integer.valueOf(arg);
                stack.add(num);
                answer += num;
            }
        }
        
        return answer;
    }
}