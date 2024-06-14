import java.util.*;
import java.io.*;
class Word implements Comparable<Word>{
    String word;
    int len, freq;
    public Word(String word, int freq){
        this.word = word;
        this.len = word.length();
        this.freq = freq;
    }

    @Override
    public int compareTo(Word w) {
        if (this.freq == w.freq) {
            if (this.len == w.len) {
                return this.word.compareTo(w.word);
            } else {
                return w.len - this.len;
            }
        } else {
            return w.freq - this.freq;
        }
    }
}
public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        String word;
        while(N-- > 0){
            word = br.readLine();
            if(word.length() < M) continue;
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        Set<Word> set = new TreeSet<>();
        for (Map.Entry<String, Integer> words : map.entrySet()) {
            set.add(new Word(words.getKey(), words.getValue()));
        }
        for (Word w : set) {
            sb.append(w.word).append('\n');
        }
        System.out.println(sb);
    }
}
