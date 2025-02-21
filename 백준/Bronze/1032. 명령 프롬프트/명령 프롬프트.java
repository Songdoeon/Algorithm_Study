import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        char[] text = br.readLine().toCharArray();

        for (int i=0; i<testCase-1; i++) {
            char[] compare = br.readLine().toCharArray();

            for(int j=0; j<text.length; j++) {
                if(text[j] != compare[j]) {
                    text[j] = '?';
                }
            }
        }

        System.out.print(text);
    }
}