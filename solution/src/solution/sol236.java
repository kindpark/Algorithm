package solution;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class sol236 {
	static int n, m;
	static HashMap<Integer, Integer> hmp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		hmp = new HashMap<>();
		for(int i = 1; i <= n; i++) {
			hmp.put(i, 0);
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			for(int j = 1; j < n; j++) {
				if(b == j) {
					int e = hmp.get(a) + 1;
					hmp.put(j, e);
					break;
				}
				
			}
		}
		List<HashMap.Entry<Integer, Integer>> entries = hmp.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
        for (Map.Entry<Integer, Integer> entry : entries) {
            System.out.print(entry.getKey() + " ");
        }
	}
}
/*
import java.io.*;
import java.util.*;

public class sol236 {
    static int n, m;
    static int[] arr;
    static ArrayList<ArrayList<Integer>> edges = new ArrayList<>();


    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ", false);

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ", false);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[b]++;
            edges.get(a).add(b);
        }

        for (int i = 1; i <= n; i++){
            if (arr[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int num = q.poll();
            System.out.print(num+" ");
            for (int i = 0; i < edges.get(num).size(); i++) {
                int c = edges.get(num).get(i);
                arr[c]--;
                if(arr[c] == 0) {
                    q.add(c);
                }
            }
        }
    }
}
*/