import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        Map<Integer,Double> state = new HashMap<>();
        int[] users = new int[N];
        int[] fail = new int[N+1];
        double userNum = stages.length;
        for(int i = 0;i<userNum;i++){
            fail[stages[i]-1]++;
        }
        // for(int stage : stages){
        //     state.put(stage,state.getOrDefault(stage,0)+1);
        // }
        for(int idx = 0;idx<N;idx++){
            if(userNum<=0){
                state.put(idx+1,Double.valueOf(0));
            }
            else{
                state.put(idx+1,fail[idx]/userNum);
                userNum -= fail[idx];
            }
        }
        
        List<Map.Entry<Integer, Double>> entryList = new LinkedList<>(state.entrySet());
        int idx = 0;
        entryList.sort(((o1, o2) -> Double.compare(o2.getValue(),o1.getValue())));
        for(Map.Entry<Integer,Double> entry : entryList){
            Integer index = entry.getKey();
            if(index!=N+1)users[idx++]=index;
            System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
            
        }
        return users;
    }
}