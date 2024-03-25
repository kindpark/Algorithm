package codeforces;

import java.io.*;
import java.util.Arrays;
 
public class C_div3_0624 {
    private static int n = 0;
    private static int m = 0;
    private static String s = null;
    private static int[] p = null;
    private static int[] answer = null;
 
    private static final char a = 97;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] strArr = br.readLine().split(" ");
            n = Integer.parseInt(strArr[0]);
            m = Integer.parseInt(strArr[1]);
            p = new int[m];
            s = br.readLine();
            String[] strArr2 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                p[j] = Integer.parseInt(strArr2[j]);
            }
            answer = new int[26];
 
            findNums();
 
            for (int j = 0; j < 26; j++) {
                sb.append(answer[j]).append(" ");
            }
            sb.append("\n");
 
            n = 0; m = 0; s = null; answer = null;
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
 
    private static void findNums() {
        Arrays.sort(p);
        char[] combo = s.toCharArray();
        int start = 0;
        for (int i = 0; i < m; i++) {
            if(i == 0 || p[i] != p[i - 1]){
                fillAnswers(start, p[i], i, combo);
                start = p[i];
            }
        }
        for (int i = p[m - 1]; i < n; i++) {
            answer[combo[i] - a]++;
        }
    }
 
    private static void fillAnswers(int startIndex, int endIndex, int pIndex, char[] combo){
        int iter = m + 1 - pIndex;
        for (int j = startIndex; j < endIndex; j++) {
            answer[combo[j] - a] += iter;
        }
    }
}
