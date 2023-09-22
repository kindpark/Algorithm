package solution;
import java.util.*;
import java.io.*;
public class sol176 {
	static int n;
	static ArrayList<Integer> arr;
	static boolean[][] check;
	static Queue<Integer> q;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		arr = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int p = st.countTokens();
			for(int j = 0; j < p; j++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
		}
		Collections.sort(arr);
		System.out.println(arr.get(n*n - n));
	}

}
