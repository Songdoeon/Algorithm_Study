class Solution {
    public int solution(int number, int n, int m) {
        boolean nType = number % n == 0 ? true : false;
        boolean mType = number % m == 0 ? true : false;
        return nType ? mType ? 1 : 0 : 0;
    }
}