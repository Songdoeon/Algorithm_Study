import java.io.*;
import java.util.*;

public class Main{

    static long N;
    static long getStart(long idx){
        return ((idx * (idx - 1)) / 2) + 1;
    }
    static long getEnd(long idx){
        return ((idx + 1) * idx) / 2;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        long start = 1;
        long end = 1_414_213_563;
        long mid = 1;
        long endNum = 0;
        long startNum = 0;
        while (start < end){
            mid = (start + end) / 2;
            endNum = getEnd(mid);
            startNum = getStart(mid);
            if(endNum >= N && startNum <= N)break;
            if(N < endNum){
                end = mid;
            }
            else start = mid + 1;
        }
        long diff = endNum - N;
        long first = 1 + diff;
        long second = mid - diff;
        if(mid % 2 == 1) System.out.println(first +"/"+second);
        else System.out.println(second +"/"+first);
    }
}