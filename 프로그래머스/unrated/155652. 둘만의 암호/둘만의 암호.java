class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        
        for (int i = 0; i < len; i++) {
            
            char c = search(s.charAt(i),index,skip);
        
            sb.append(c);
        }
        return sb.toString();
    }
    
    char search(char c,int index,String skip){
        for (int j = 0; j < index; j++) {
                c += 1;
                if (c > 'z') c -= 26;
                if (skip.contains(String.valueOf(c))) j--;
            }
        return c;
    }
}