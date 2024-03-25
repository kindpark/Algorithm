package codeforces;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
 
public class C_0691 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        long[] a = new long[n];
        long[] b = new long[m];
        String[] as = br.readLine().split(" ");
        String[] bs = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(as[i]);
        }
        for (int i = 0; i < m; i++) {
            b[i] = Long.parseLong(bs[i]);
        }
        Arrays.sort(a);
        Map<Long, Long> result = new HashMap<>();
 
        for (int i = 0; i < m; i++) {
            if(result.containsKey(b[i])){
                sb.append(result.get(b[i]));
                sb.append(" ");
                continue;
            }
 
            long answer = 0;
 
            int end = n;
            long[] gcds = new long[n];
            for (int j = 0; j < end; j++) {
                gcds[j] = a[j] + b[i];
            }
            long[] newGcds = null;
            if(end % 2 == 0){
                newGcds = new long[end / 2];
            }else{
                newGcds = new long[end / 2 + 1];
            }
 
            while(end > 1){
                int index = 0;
                for (int j = 0; j < end; j += 2) {
                    long first = gcds[j];
                    if(j + 1 >= end){
                        newGcds[index] = first;
                        continue;
                    }
                    long second = gcds[j + 1];
                    long gcd = gcd(first, second);
                    if(gcd == 1){
                        answer = 1;
                        break;
                    }
                    newGcds[index] = gcd;
                    index++;
                }
 
                if(answer == 1){
                    break;
                }
 
                gcds = newGcds;
                int length = newGcds.length;
 
                if(length % 2 == 0){
                    newGcds = new long[length / 2];
                }else{
                    newGcds = new long[length / 2 + 1];
                }
                end = length;
            }
 
            if(answer != 1){
                answer = gcds[0];
            }
 
            result.put(b[i], answer);
            sb.append(answer);
            sb.append(" ");
        }
 
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
 
    private static long gcd(long n1, long n2){
        long max = n1;
        long min = n2;
        if(min > max){
            max = n2;
            min = n1;
        }
 
        if(max % min == 0){
            return min;
        } else {
            return gcd(min, max % min);
        }
    }
}
