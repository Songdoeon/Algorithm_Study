class Solution {
    public String solution(String my_string, int s, int e) {
        StringBuilder sb = new StringBuilder(my_string.substring(s,e+1));
        String word = sb.reverse().toString();
        sb.setLength(0);
        sb.append(my_string.substring(0,s));
        sb.append(word);
        sb.append(my_string.substring(e+1));
        return sb.toString();
    }
}