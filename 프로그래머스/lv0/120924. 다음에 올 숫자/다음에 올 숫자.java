class Solution {
    public int solution(int[] common) {
        int num = common[1] - common[0];
        if(common[2] - common[1] == num) return common[common.length - 1] + num;
        else return common[common.length - 1] * common[1] / common[0];
    }
}