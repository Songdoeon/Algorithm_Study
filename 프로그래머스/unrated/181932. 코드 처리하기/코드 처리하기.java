class Solution {
    public String solution(String code) {
        StringBuilder sb = new StringBuilder();
        boolean check = false;
        for(int i = 0; i < code.length(); i++){
            if(code.charAt(i) == '1') {
                check = !check;
                continue;
            }
            if(check){
                if(i % 2 == 1) sb.append(code.charAt(i));
            }
            else{
                if(i % 2 == 0) sb.append(code.charAt(i));
            }
            
        }
        if(sb.length() == 0) return "EMPTY";
        return sb.toString();
    }
}