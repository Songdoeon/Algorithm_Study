import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCases; t++) {
            String input = br.readLine();
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();

            for (char ch : input.toCharArray()) {
                if (ch == '-') { // 백스페이스
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                } else if (ch == '<') { // 왼쪽 화살표
                    if (!left.isEmpty()) {
                        right.push(left.pop());
                    }
                } else if (ch == '>') { // 오른쪽 화살표
                    if (!right.isEmpty()) {
                        left.push(right.pop());
                    }
                } else { // 일반 문자
                    left.push(ch);
                }
            }

            // 결과를 StringBuilder로 구성
            StringBuilder result = new StringBuilder();
            // left 스택을 역순으로 추가
            while (!left.isEmpty()) {
                result.append(left.pop());
            }
            result.reverse(); // 역순으로 뒤집기

            // right 스택을 뒤에 추가
            StringBuilder rightResult = new StringBuilder();
            while (!right.isEmpty()) {
                rightResult.append(right.pop());
            }
            result.append(rightResult);

            System.out.println(result);
        }
    }
}
