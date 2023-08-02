class Solution {
    public String solution(String phone_number) {
        StringBuilder sb = new StringBuilder();
        int length = phone_number.length();
        for(int i = 0;i<length-4;i++ ){
            sb.append("*");
        }
        sb.append(phone_number.substring(length-4));
        
        return sb.toString();
    }
}