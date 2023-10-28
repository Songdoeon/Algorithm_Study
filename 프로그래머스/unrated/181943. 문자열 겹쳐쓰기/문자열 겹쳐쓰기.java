class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        StringBuilder sb = new StringBuilder();
        sb.append(my_string.substring(0,s));
        
        sb.append(overwrite_string);
        int len = overwrite_string.length();
        sb.append(my_string.substring(s+len));
        
        return sb.toString();
    }
}