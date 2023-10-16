import java.util.*;
class Solution {
    public int[] solution(String msg) {
        List<String> list = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        int len = msg.length();
        
        char ch = 'A';
        for(int i = 0; i < 26; i++){
            list.add(String.valueOf(ch));
            ch++;
        }
        for(int i = 0; i < len; i++){
            int tempLen = 1;
            String str ="";
            String tempStr = "";
            while(i + tempLen <= len){
                str = msg.substring(i,i + tempLen);
                if(tempLen + i == len) {
                    tempLen++;
                    break;
                }
                tempLen++;
                tempStr = msg.substring(i,i + tempLen);
                if(!list.contains(tempStr)) break;
            } 
            if(tempLen > 1) i += tempLen - 2;
            // System.out.println(i + " : " + tempLen +" : " +str);
            answer.add(list.indexOf(str) + 1);
            list.add(tempStr);

        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}