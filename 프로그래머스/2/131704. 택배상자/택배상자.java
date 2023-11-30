import java.util.*;
class Solution {
    Stack<Integer> stack = new Stack<>();
    Queue<Integer> queue = new LinkedList<>();
    
    public int solution(int[] order) {
        int len = order.length;
        int answer = 0;
        int box = 0;
        
        for(int i = 1; i <= len; i++){
            queue.add(i);
        }
        
        while(box < len){
            // System.out.println(box + " : " + len);
            if(queue.isEmpty() && !stack.isEmpty()){
                if(stack.peek() != order[box]) break;
                else if(stack.peek() == order[box]){
                    stack.pop();
                    box++;
                    answer++;
                    continue;
                }
            }
            if(!stack.isEmpty() && stack.peek() == order[box]){
                // System.out.println("pop");
                // System.out.println(stack.peek());
                stack.pop();
                box++;
                answer++;
                continue;
            }
            if(queue.isEmpty()) continue;
            int index = queue.remove();
            // System.out.println(index);
            if(index == order[box]){
                // System.out.println("queue");
                answer++;
                box++;
            }
            else {
                // System.out.println("push");
                stack.push(index);
            }
        }
        return answer;
    }
}