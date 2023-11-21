package atcoder;
import java.io.*;
import java.util.*;

public class sol15 {
    static int k;
    static char[] sign;
    static int[] num;
    static ArrayList<String> list = new ArrayList<>();
    static boolean[] visited = new boolean[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        String s = br.readLine();
        sign = new char[k];
        num = new int[k+1];
        for (int i = 0; i < k-1; i++)
            sign[i] = s.charAt(i);
        bt(0);
        Collections.sort(list);
        System.out.println(list.size());
    }
    static void bt(int depth) {
        if (depth == k+1) {
            String sum = "";
            for (int n : num)
                sum += n;
            list.add(sum);
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (isPromissing(depth, i) && !visited[i]) {
                visited[i] = true;
                num[depth] = i;
                bt(depth + 1);
                visited[i] = false;
            }
        }
    }
    static boolean isPromissing(int depth, int i) {
        if (depth == 0) return true;
        if (sign[depth - 1] == '>')
            return num[depth - 1] > i ? true : false;
        else return num[depth - 1] < i ? true : false;
    }
}
