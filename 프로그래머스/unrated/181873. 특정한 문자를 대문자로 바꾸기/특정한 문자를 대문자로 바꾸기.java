class Solution {
    public String solution(String my_string, String alp) {
        String answer = "";
        char[] chars = my_string.toCharArray();
        char charAlp = alp.charAt(0);
        for(int i = 0; i < my_string.length(); i++)if(charAlp == chars[i]) chars[i] = Character.toUpperCase(chars[i]);
        StringBuilder sb = new StringBuilder();
        for(char c : chars){
            sb.append(c);
        }
        return sb.toString();
    }
}