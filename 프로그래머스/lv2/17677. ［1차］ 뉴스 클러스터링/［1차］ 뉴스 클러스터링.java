import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        List<String> list1 = new LinkedList<>();
        List<String> list2 = new LinkedList<>();
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        str1 = str1.replaceAll("[^A-Z]"," ");
        str2 = str2.replaceAll("[^A-Z]"," ");
        double sum = 0;
        double sub = 0;
        
        for(int i = 0; i < str1.length() - 1; i++){
            String str = str1.substring(i,i+2);
            if(str.indexOf(" ") != -1) continue;
            list1.add(str);
        }

        for(int i = 0; i < str2.length() - 1; i++){
            String str = str2.substring(i,i+2);
            if(str.indexOf(" ") != -1) continue;
            list2.add(str);
        }
        
        for(String str : list1){
            sum++;
            if(list2.contains(str)) {
                list2.remove(str);
                sub++;
            }
        }
        for(String str : list2){
            sum++;
        }
        if(sum == 0 && sub == 0) return 65536;
        
        double answer = sub / sum * 65536;
        return (int) answer;
    }
}