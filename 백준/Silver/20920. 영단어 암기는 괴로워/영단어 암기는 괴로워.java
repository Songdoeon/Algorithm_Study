import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Word implements Comparable<Word> {
    final String value;
    final int freq;
    final int len;

    public Word(String value, int freq) {
        this.value = value;
        this.freq = freq;
        len = value.length();
    }

    @Override
    public int compareTo(Word w) {
        if (this.freq == w.freq) {
            if (this.len == w.len) {
                return this.value.compareTo(w.value);
            } else {
                return w.len - this.len;
            }
        } else {
            return w.freq - this.freq;
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numOfWords = Integer.parseInt(st.nextToken());
        int minLen = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> words = new HashMap<>();
        while (numOfWords-- > 0) {
            String word = br.readLine();
            if (word.length() < minLen) continue;
            words.put(word, words.getOrDefault(word, 0) + 1);
        }

        TreeSet<Word> wordList = new TreeSet<>();
        for (Map.Entry<String, Integer> word : words.entrySet()) {
            wordList.add(new Word(word.getKey(), word.getValue()));
        }

        for (Word word : wordList) {
            sb.append(word.value).append('\n');
        }

        System.out.println(sb);
    }
}