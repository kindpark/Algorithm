package codeforces;

import java.io.*;

public class F_global_10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] strArr = br.readLine().split(" ");
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Long.parseLong(strArr[i]);
        }
 
        long nSum = (long) (n - 1) * (long) n / 2;
        long[] answer = new long[n];
        for (int i = 0; i < n; i++) {
            answer[i] = i;
        }
 
        long base = sum / ((long) n);
        long res = sum % ((long) n);
 
        long minusSum = nSum - res;
        long eachMinus = minusSum / n;
        long index = n - (minusSum % n);
        for (int i = 0; i < index; i++) {
            answer[i] -= eachMinus;
            answer[i] += base;
        }
        for (int i = (int) index; i < n; i++) {
            answer[i] -= (eachMinus + 1);
            answer[i] += base;
        }
 
        for (int i = 0; i < n; i++) {
            sb.append(answer[i]).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
