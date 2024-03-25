package codeforces;

import java.io.*;

public class C_div2_0620 {
    private static int n = 0;
    private static int m = 0;
    private static int[] time = null;
    private static int[] lb = null;
    private static int[] ub = null;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            String[] strArr = br.readLine().split(" ");
            n = Integer.parseInt(strArr[0]);
            m = Integer.parseInt(strArr[1]);
            time = new int[n];
            lb = new int[n];
            ub = new int[n];
            for (int j = 0; j < n; j++) {
                String[] strArr2 = br.readLine().split(" ");
                time[j] = Integer.parseInt(strArr2[0]);
                lb[j] = Integer.parseInt(strArr2[1]);
                ub[j] = Integer.parseInt(strArr2[2]);
            }
            sb.append(isPossible()).append("\n");
            n = 0; m = 0; time = null; lb = null; ub = null;
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
 
    private static String isPossible() {
        String answer = "YES";
        int prevLb = lb[n - 1];
        int prevUb = ub[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            if(i != 0){
                int timeDiff = time[i] - time[i - 1];
                int possibleLb = prevLb - timeDiff;
                int possibleUb = prevUb + timeDiff;
                prevLb = Math.max(lb[i - 1], possibleLb);
                prevUb = Math.min(ub[i - 1], possibleUb);
                if(prevLb > prevUb){
                    answer = "NO";
                    break;
                }
            }else{
                int timeDiff = time[i];
                int possibleLb = prevLb - timeDiff;
                int possibleUb = prevUb + timeDiff;
                if(possibleLb > m || m > possibleUb){
                    answer = "NO";
                    break;
                }
            }
        }
        return answer;
    }
 
 
}
