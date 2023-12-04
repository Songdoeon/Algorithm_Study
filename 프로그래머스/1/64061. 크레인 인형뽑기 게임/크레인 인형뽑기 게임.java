import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                Queue<Integer> queue;
                if(!map.containsKey(i + 1)) queue = new LinkedList<>();
                else queue = map.get(i + 1);
                if(board[j][i] != 0) queue.add(board[j][i]);
                map.put(i + 1,queue);
            }
        }
        for(int i = 0; i < moves.length; i++){
            int box = moves[i];
            if(map.get(box).isEmpty()) continue;
            int doll = map.get(box).poll();
            if(stack.isEmpty()) stack.push(doll);
            else if(stack.peek() == doll) {
                stack.pop();
                answer += 2;
            }
            else stack.push(doll);
            
        }
        
        return answer;
    }
}