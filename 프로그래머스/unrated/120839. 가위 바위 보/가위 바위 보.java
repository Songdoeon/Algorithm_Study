class Solution {
    public String solution(String rsp) {
        StringBuilder sb = new StringBuilder();
        
        for(char c : rsp.toCharArray()){
            switch(c){
                case '2' : sb.append(0);break;
                case '0' : sb.append(5);break;
                case '5' : sb.append(2);
            }
        }
        return sb.toString();
    }
}