import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int len = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int tempLen = 2 * N + 1;

        boolean button;
        int answer = 0;
        if(tempLen > len){
            System.out.println(0);
            return ;
        }
        for(int i = 0; i <= len - tempLen; i++){
            char c = str.charAt(i);
            char nextC = str.charAt(i + 1);
            if(c == 'I' && nextC == 'O'){
//                System.out.println(i + "들옴?");
                int index = 2;
                button = true;
                for(int j = index; j < tempLen - 2; j += 2){
                    char tempC = str.charAt(j + i);
                    char tempNextC = str.charAt(j + i + 1);
                    if(!(tempC == 'I') || !(tempNextC == 'O'))break;
                    index += 2;
                }
                if(str.charAt(i + index) == 'I')index++;
//                System.out.println(index);
                if(index == tempLen) {
                    answer++;
                    int tempIdx = i + tempLen;
//                    System.out.println(i + "nomal" + answer);
                    if(tempIdx > len - 2) break;
                    c = str.charAt(tempIdx);
                    nextC = str.charAt(tempIdx + 1);
                    while (c == 'O' && nextC == 'I'){
                        answer++;
//                        System.out.println(i + "??" + answer);
                        i = tempIdx - 1;
                        tempIdx += 2;
                        if(tempIdx > len - 2) break;
                        c = str.charAt(tempIdx);
                        nextC = str.charAt(tempIdx + 1);
                    }
                }
                else{
                    i += index - 1;
                }
            }
        }
        System.out.println(answer);
    }
}