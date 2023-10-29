class Solution {
    public String[] solution(String[] picture, int k) {
        int len = picture.length;
        int width = picture[0].length();
        String[] answer = new String[len * k];
        int index = 0;
        int idx = 0;
        while(index < len){
            StringBuilder sb = new StringBuilder();
            String str = picture[index];
                for(int j = 0; j < width; j++){
                    for(int l = 0; l < k; l++){
                        sb.append(str.charAt(j));
                    }
                }
            for(int i = idx; i < idx + k; i++){
                answer[i] = sb.toString();
            }
            index++;
            idx += k;
        }
        return answer;
    }
}