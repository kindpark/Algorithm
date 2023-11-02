package atcoder;
import java.io.*;
import java.util.*;
public class sol3 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] x = new int[m];
		int[] y = new int[m];
		for (int i = 0; i < y.length; i++) {
			st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(x);
		Arrays.sort(y);
		
		
		int start = 0;
		//제시된 숫자
		int end = 1000000000;
		while ((end - start)>=1) {
			int mid=(end - start)/2+start;
			if (promotion(x, y, mid, m, n)) {
				end = mid;
			}
			else {
				start = mid+1;
			}
		}
		System.out.println(start);
	}
    //
	static boolean promotion(int[] x,int[] y,int mid,int m,int n) {
		int num = 0;
		int i = 0;
		while(i < m) {
			num++;
			int r = x[i] + mid;
			while (i < m && x[i] <= r) {
				i++;
			}
		}
		i = 0;
		while(i < m) {
			num++;
			int r = y[i] + mid;
			while (i < m && y[i] <= r) {
				i++;
			}
		}
		if (num<=n) {
			return true;
		}else {
			return false;
		}
	}
}