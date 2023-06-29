import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int count=0;
        int[] days = new int[progresses.length];
        List<Integer> list = new ArrayList<>();
        for(int i =0;i<progresses.length;i++){
            int temp = (100-progresses[i]);
            if(temp%speeds[i]!=0){
                days[i]=temp/speeds[i]+1;    
            }
            else days[i]=temp/speeds[i];    
            System.out.println(i+"번째 : "+days[i]);
        }
        int index=days[0];
        for(int i=0;i<days.length;i++){
            if(days[i]<=index){
                count++;
            }
            else{
                list.add(count);
                index=days[i];
                i--;
                count=0;
            }
        }
        list.add(count);
        return list.stream().mapToInt(i->i).toArray();
    }
}