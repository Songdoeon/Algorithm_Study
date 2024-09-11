import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder sb = new StringBuilder();
        while (!(line = br.readLine()).equals("0")){
            BigInteger n = new BigInteger(line);
            if(n.mod(new BigInteger("42")).intValue() == 0) sb.append("PREMIADO").append('\n');
            else sb.append("TENTE NOVAMENTE").append('\n');
        }
        System.out.println(sb);
    }
}