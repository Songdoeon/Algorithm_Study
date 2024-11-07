import java.io.*;

public class Main {
    static String target;
    static boolean isPossible = false;

    static void search(StringBuilder word) {
        if (word.length() == target.length()) {
            if (word.toString().equals(target)) {
                isPossible = true;
            }
            return;
        }

        if (word.length() < target.length()) return;

        // 문자열 끝이 A인 경우
        if (word.charAt(word.length()-1) == 'A') {
            StringBuilder next = new StringBuilder(word);
            next.deleteCharAt(next.length()-1);
            search(next);
        }

        // 문자열 시작이 B인 경우
        if (word.charAt(0) == 'B') {
            StringBuilder next = new StringBuilder(word);
            next.deleteCharAt(0);
            next.reverse();
            search(next);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        target = br.readLine();
        String word = br.readLine();

        search(new StringBuilder(word));
        System.out.println(isPossible ? 1 : 0);
    }
}