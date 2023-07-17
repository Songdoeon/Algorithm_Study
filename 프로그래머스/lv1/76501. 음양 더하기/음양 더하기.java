class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int len = absolutes.length;
        int[] nums = new int[len];
        int answer = 0;
        for(int idx = 0; idx < len; idx++){
            if(signs[idx]==true){
                nums[idx]=absolutes[idx];
            }
            else nums[idx] = absolutes[idx]*-1;
        }
        for(int num : nums){
            answer += num;
        }
        
        return answer;
    }
}