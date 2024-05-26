import java.io.*;
import java.util.*;
import java.math.BigInteger;
class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger n1 = new BigInteger(br.readLine());
        BigInteger n2 = new BigInteger(br.readLine());
        System.out.println(n1.add(n2) + "\n" + n1.subtract(n2) + "\n" + n1.multiply(n2));
    }
}