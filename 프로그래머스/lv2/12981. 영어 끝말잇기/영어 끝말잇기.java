import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> wordSet = new HashSet<>();
        
        int[] answer = new int[] {0,0};
        int wordNum = words.length;
        String preWord = words[0];
        wordSet.add(preWord);
        for(int i = 1; i < wordNum; i++){
            if(wordSet.contains(words[i])) return new int[] {i%n+1,(i/n)+1};
            if(words[i].charAt(0) != preWord.charAt(preWord.length()-1)) return new int[] {i%n+1,(i/n)+1};
            wordSet.add(words[i]);
            preWord = words[i];
        }
        
        return answer;
    }
}