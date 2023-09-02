class Solution {
    String shift(String sb){
        int length = sb.length();
        return sb.substring(length - 1) + sb.substring(0, length - 1);
    }
    public int solution(String A, String B) {
        int length = A.length();
        for(int idx = 0; idx < length; idx++){
            if(A.equals(B)) return idx;
            A = shift(A);
        }
        return -1;
    }
}