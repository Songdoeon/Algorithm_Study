class Solution {
    String begin, target;
    int size;
    String[] words;
    int answer = 0;
    
    Boolean check(String word,String target){
        int length = word.length();
        int num = 0;
        for(int i = 0; i < length; i++){
            if(word.charAt(i) == target.charAt(i)) num++;
        }
        if(num == length-1)return true;
        return false;
    }
    
    void search(String word,int depth, boolean[] visited){
        System.out.println(word);
        if(word.equals(target)) {
            answer = depth;
            return ;
        }
        for(int Index = 0; Index < size; Index++){
            if(visited[Index]) continue;
            if(!check(word,words[Index])) continue;
            System.out.println(words[Index]);
            visited[Index] = true;
            search(words[Index],depth+1,visited);
            visited[Index] = false;
        }
    }
    public int solution(String begin, String target, String[] words) {
        size = words.length;
        boolean[] visited = new boolean[size];
        this.begin = begin;
        this.target = target;
        this.words = words;
        
        search(begin,0,visited);
        return answer;
    }
}