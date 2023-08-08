class Solution {
    public String solution(String s) {
        int len = s.length();
        int length = len/2;
        if(len % 2 == 1){
            return s.substring(length,length+1);
        }
        return s.substring(length-1,length+1);
    }
}