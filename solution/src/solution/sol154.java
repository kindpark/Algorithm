package solution;
import java.util.*;
import java.io.*;
public class sol154 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, Integer> hmap = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];//원래 배열
		int[] comp = new int[n];//원래 자리 기억
		int cnt = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

		}
		comp = arr.clone();
		Arrays.sort(arr);
		for(int i= 0; i < n; i++) {
			if(!hmap.containsKey(arr[i])) {
				hmap.put(arr[i], cnt++);
			}
		}
		
		
		for(int i = 0; i < n; i++) {
			sb.append(hmap.get(comp[i]) + " ");
		}
		System.out.println(sb);
	}
}
