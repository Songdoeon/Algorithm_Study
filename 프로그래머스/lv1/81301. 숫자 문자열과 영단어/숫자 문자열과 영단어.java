import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        int length = s.length();
        String[] numEng = new String[] {"zero","one","two","three","four","five","six","seven","eight","nine"};
        Map<String,Integer> map = new HashMap<>();
        
        for(int idx=0;idx<numEng.length;idx++){
            map.put(numEng[idx],idx);
        }
        for(int idx=0;idx<length-2;idx++){
            for(Map.Entry<String,Integer> entry : map.entrySet()){
                // System.out.println(entry.getValue());
                if(s.startsWith(entry.getKey(),idx)){
                    int wordLength = String.valueOf(entry.getKey()).length();
                    // System.out.println(s.substring(0,idx));
                    // System.out.println(entry.getValue());
                    // System.out.println(s.substring(idx+wordLength));
                    // System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
                    s = s.substring(0,idx)+entry.getValue()+s.substring(idx+wordLength);
                }    
            }
        }
        return Integer.parseInt(s);
    }
}