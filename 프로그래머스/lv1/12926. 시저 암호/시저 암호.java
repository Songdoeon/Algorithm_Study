class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        
        for(int i = 0; i< length;i++){
            char c = s.charAt(i);
            if(c==' ') {
                sb.append(" ");
                continue;
            }
            char c2 = search(c,n);
            sb.append(c2);
        }
        return sb.toString();
    }
    
    char search(char c,int n){
        for(int i = 0;i < n;i++){
            c += 1;
            if(c > 'z') c -= 26;
            if(c == ('Z'+1)) c -= 26;
        }
        return c;
    }
}