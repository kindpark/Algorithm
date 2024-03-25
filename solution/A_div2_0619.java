package codeforces;

import java.io.*;

public class A_div2_0619 {
    private static String a, b, c = null;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            a = br.readLine();
            b = br.readLine();
            c = br.readLine();
            sb.append(answer()).append("\n");
            a = null;
            b = null;
            c = null;
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
 
    private static String answer() {
        boolean answer = true;
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();
        char[] cArr = c.toCharArray();
 
        for (int i = 0; i < a.length(); i++) {
            if(aArr[i] == bArr[i] && aArr[i] != cArr[i]){
                answer = false;
                break;
            }
            if(aArr[i] != bArr[i] && !(aArr[i] == cArr[i] || bArr[i] == cArr[i])){
                answer = false;
                break;
            }
        }
        return answer? "YES" : "NO";
    }
}
