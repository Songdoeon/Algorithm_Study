import java.util.*;

class Solution {
    class Person{
        String name;
        Person parent;
        int profit;
        
        public Person(String name){
            this.name = name;
            this.parent = null;
            this.profit = 0;
        }
    }
    
    public void addProfit(Person person, int profit){
        int profit_for_parent = profit / 10;
        if(profit_for_parent != 0 && person.parent != null){
            person.profit += profit - profit_for_parent;
            addProfit(person.parent, profit_for_parent);
        }else{
            person.profit += profit - profit_for_parent;
        }
    }
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, Person> map = new HashMap<>();
        int enrollNum = enroll.length;
        int[] answer = new int[enrollNum];
        
        for(int idx = 0; idx < enrollNum; idx++){
            map.put(enroll[idx], new Person(enroll[idx]));
        }
        
        for(int idx = 0; idx < enrollNum; idx++){
            map.get(enroll[idx]).parent = map.get(referral[idx]);
        }
        
        for(int i = 0; i < seller.length; i++)
            addProfit(map.get(seller[i]), amount[i] * 100);
        
        for(int i = 0; i < enroll.length; i++)
            answer[i] = map.get(enroll[i]).profit;
        return answer;
    }
}