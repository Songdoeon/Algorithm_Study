class Solution {
    public int[] solution(int money) {
        int num = money / 5500;
        int change = money - (5500 * num);
        return new int[] {num, change};
    }
}