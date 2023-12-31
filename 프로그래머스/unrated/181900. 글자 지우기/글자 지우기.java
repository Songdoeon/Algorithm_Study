class Solution {
    int[] indices;
    void check(int num, int index){
        for(int i = index; i < indices.length; i++){
            if(num < indices[i]) indices[i]--;
        }
    }
    public String solution(String my_string, int[] indices) {
        this.indices = indices;
        StringBuilder sb = new StringBuilder(my_string);
        int index = 0;
        for(int i : indices){
            sb.replace(i,i+1," ");
        }
        return sb.toString().replace(" ","");
    }
}