class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        String[] args = s.split(" ");
        int len = args.length;
        System.out.println(len);
        for(int Index = 0;Index < len;Index++){
            String arg = args[Index];
            if(arg.length()==0) sb.append(" ");
            else{
                sb.append(arg.substring(0,1).toUpperCase())
                .append(arg.substring(1).toLowerCase())
                .append(" ");
            }
        }
        String answer = sb.toString();
        int stringLength = answer.length()-1;
        if(s.substring(s.length()-1,s.length()).equals(" ")) {
            System.out.println(s);
            return answer;
        }
        return answer.substring(0,stringLength);
    }
}