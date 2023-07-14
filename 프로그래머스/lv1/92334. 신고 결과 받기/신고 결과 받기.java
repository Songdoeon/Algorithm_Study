import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int userNum = id_list.length;
        int[] answer = new int[userNum]; 
        Map<String,String> reportMap = new HashMap<>();
        Set<String> reportSet = new HashSet<>();
        
        for(String user : report){
            String[] users = user.split(" ");
            reportMap.put(users[1],reportMap.getOrDefault(users[1],"")+" "+users[0]);       
        }
        for(String key : reportMap.keySet()){
            String reporters = reportMap.get(key);
            reporters = reporters.trim();
            String[] reporter = reporters.split(" ");
            for(String str : reporter){
                reportSet.add(str);   
                // System.out.println(reporters);
                // System.out.println(str);
            }
            if(reportSet.size()>=k){
                Iterator<String> iter = reportSet.iterator();
                while(iter.hasNext()){
                    String name = iter.next();
                    for(int index=0;index<userNum;index++){
                        if(id_list[index].equals(name)){
                            answer[index]++;
                        }
                    }
                }
            }
            reportSet.clear();
        }
        return answer;
    }
}