class Solution {
    boolean solution(String s) {
        s = s.toLowerCase();

        if(s.replace("p","").length()==s.replace("y","").length())return true;
        
        return false;
    }
}