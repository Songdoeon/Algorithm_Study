class Solution {
    public int solution(int n, String control) {
        for(int idx = 0; idx < control.length(); idx++){
            switch(control.charAt(idx)){
                case 'w' : n += 1; break;
                case 's' : n -= 1; break;
                case 'd' : n += 10; break;
                case 'a' : n -= 10; break;
            }
        }
        return n;
    }
}