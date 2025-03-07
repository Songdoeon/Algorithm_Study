import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Integer> stack = new ArrayDeque<>();
        int len = prices.length;
        
        for(int i = 0; i < len; i++){
            int n = prices[i];
            while(!stack.isEmpty() && n < prices[stack.peek()]){
                answer[stack.peek()] = i - stack.peek();
                // System.out.println(stack.peek() + " = " + i + " - " + stack.peek());
                stack.pop();
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            // System.out.println(stack.peek()+  " : " + (len - 1));
            answer[stack.peek()] = len - 1 - stack.peek();
            stack.pop();
        }
        return answer;
    }
}