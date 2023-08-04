import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        int[] answer = new int[2];
        int[] arr = new int[2];
        
        for(String str : operations){
            String[] args = str.split(" ");
            String word = args[0];
            int num = Integer.valueOf(args[1]);
            if(args[0].equals("I")) {
                maxQ.add(num);
                minQ.add(num);
            }
            else{
                if(maxQ.isEmpty())continue;
                if(num > 0) {
                    int n = maxQ.remove();
                    minQ.remove(n);
                }
                if(num < 0) {
                    int n = minQ.remove();
                    maxQ.remove(n);
                }
            }
        }
        if(maxQ.isEmpty()) return new int[] {0,0};
        return new int[] {maxQ.peek(),minQ.peek()};
    }
}