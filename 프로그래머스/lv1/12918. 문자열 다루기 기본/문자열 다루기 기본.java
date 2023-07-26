class Solution {
    public boolean solution(String s) {
        if(s.length() != 4 && s.length() != 6) return false;
        if(!s.equals(s.toLowerCase()) || !s.equals(s.toUpperCase())) return false;
        return true;
    }
}