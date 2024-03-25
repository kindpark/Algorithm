package codeforces;

import java.io.*;
import java.util.Arrays;
 
public class C_0652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] nk = br.readLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            String[] numbers = br.readLine().split(" ");
            int[] integers = new int[n];
            for (int j = 0; j < n; j++) {
                integers[j] = Integer.parseInt(numbers[j]);
            }
            String[] w = br.readLine().split(" ");
            int[] friendCapa = new int[k];
            for (int j = 0; j < k; j++) {
                friendCapa[j] = Integer.parseInt(w[j]);
            }
            sb.append(happiness(n, k, integers, friendCapa)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
 
    private static long happiness(int n, int k, int[] integers, int[] friendCapa) {
        long sum = 0;
        Arrays.sort(integers);
        Arrays.sort(friendCapa);
 
        int index = n - 1;
        for (int i = 0; i < k; i++) {
            sum += integers[index];
            if(friendCapa[i] == 1){
                sum += integers[index];
            }
            index--;
        }
        int minIndex = 0;
        for (int i = k - 1; i >= 0; i--) {
            if(friendCapa[i] > 1){
                sum += integers[minIndex];
                minIndex += (friendCapa[i] - 1);
            }
        }
 
        return sum;
    }
}

