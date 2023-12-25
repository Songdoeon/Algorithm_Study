class Solution {
    public String solution(String my_string) {

        StringBuilder sb = new StringBuilder();
        
        int len = my_string.length();
        
        for(int i = 0; i < len; i++){
            char c = my_string.charAt(i);
            if(Character.isUpperCase(c)) c += 32;
            else c -= 32;
            sb.append(c);
        }
        return sb.toString();
    }
}