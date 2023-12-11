import java.util.*;
class Solution {
    class Class{
        String name;
        int startTime;
        int playTime;
        int extraTime = 0;
        Class(String name, int startTime, int playTime){
            this.name = name;
            this.startTime = startTime;
            this.playTime = playTime;
        }
    }
    int change(String time){
        String[] arg = time.split(":");
        int hour = Integer.valueOf(arg[0]);
        int minute = Integer.valueOf(arg[1]);
        
        return hour * 60 + minute;
    }
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        int index = 0;
        List<Class> list = new ArrayList<>();
        Stack<Class> stack = new Stack<>();
        
        for(String[] plan : plans){
            int startTime = change(plan[1]);
            list.add(new Class(plan[0], startTime, Integer.valueOf(plan[2])));
        }
        
        list.sort((o1, o2) -> o1.startTime - o2.startTime);
        
        stack.push(list.remove(0));
        
        while(!list.isEmpty()){
            if(stack.isEmpty()) stack.push(list.remove(0));
            else if(stack.peek().startTime + stack.peek().playTime + stack.peek().extraTime > list.get(0).startTime) {
                Class c = list.remove(0);
                stack.peek().extraTime += c.playTime;
                stack.push(c);
            }
            else {
                Class c = stack.pop();
                if(!stack.isEmpty()) stack.peek().extraTime += c.extraTime;
                
                answer[index++] = c.name;
            }
        }
        while(!stack.isEmpty()){
            answer[index++] = stack.pop().name;
        }
        return answer;
    }
}