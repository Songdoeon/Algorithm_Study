import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        HashMap map = new HashMap<>();
        Arrays.sort(phone_book);
        for(String str : phone_book){
            for(int i = 0;i<str.length();i++){
                if(map.containsKey(str.substring(0, i))){
                    return false;
                }
            }
            map.put(str,str);  
        }
        return true;
    }
}
