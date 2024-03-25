package codeforces;

import java.io.*;

public class A_0691 {
    private static int n = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            int index = 0;
            char[] chArr1 = br.readLine().toCharArray();
            char[] chArr2 = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                int red = Integer.parseInt(String.valueOf(chArr1[j]));
                int blue = Integer.parseInt(String.valueOf(chArr2[j]));
                if(red > blue) {
                    index++;
                }else if(red < blue){
                    index--;
                }
            }
            if(index == 0){
                sb.append("EQUAL");
            }else if(index > 0){
                sb.append("RED");
            }else{
                sb.append("BLUE");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
