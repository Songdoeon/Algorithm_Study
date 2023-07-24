import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int len = score.length;
        Queue<Integer> queue = new LinkedList<>();
        PriorityQueue pQ = new PriorityQueue<>();
        int[] answer = new int[len];
        for(int num : score){
            queue.add(num);
        }
        int index = 0;
        while(!queue.isEmpty()){
            int num = queue.remove();
            pQ.add(num);
            if(pQ.size() > k) pQ.remove();
            answer[index++] = (int) pQ.peek();
        }

        return answer;
    }
}