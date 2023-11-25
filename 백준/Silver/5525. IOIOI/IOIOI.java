import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        
        int len = Integer.valueOf(br.readLine());
        String str = br.readLine();
        int tempLen = 2 * N + 1;

        StringBuilder sb = new StringBuilder("I");
        boolean button;
        int answer = 0;
        for(int i = 0; i < N; i++){
            sb.append("OI");
        }
        String temp = sb.toString();
        for(int i = 0; i <= len - tempLen; i++){
            char c = str.charAt(i);
            char nextC = str.charAt(i + 1);
            if(c == 'I' && nextC == 'O'){
                int index = 2;
                button = true;
                for(int j = 0; j < tempLen - 2; j++){
                    char tempC = str.charAt(j + i + 2);
                    if(tempC == 'O' && !button){
                        button = true;
                        index++;
                    } else if (tempC == 'I' && button) {
                        button = false;
                        index++;
                    }
                }
                if(index == tempLen) answer++;
            }
        }

        System.out.println(answer);
    }
}