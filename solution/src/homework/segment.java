package homework;
import java.io.*;
import java.util.StringTokenizer;

public class segment {
	//n = 수의 갯수
	static int n = 6, m;
	static int[] tree,arr;
	static boolean change = true;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("실행할 횟수 작성");
		StringTokenizer st = new StringTokenizer(br.readLine());
		//수의 변경이 일어나는 횟수
		m = Integer.parseInt(st.nextToken());
		//구간의 합을 구하는 횟수
		
		arr = new int[n+1];
		tree = new int[getTreeSize()];
		System.out.print("배열 입력. 6자리");
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		//선형적인 배열을 세그먼트 트리로 변경
		init(0, n-1, 1);
		
		while(true) {
			if(m==0) break;
			System.out.print("변경 1 출력 2");
			int change = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			if(change == 1) {
				//트리 배열은 0부터 시작하므로 그에 맞게 값 교정
				
				int index = Integer.parseInt(st.nextToken())-1;
				int num = Integer.parseInt(st.nextToken());		
				int different = num - arr[index];
				update(0, n-1, 1, index, different);
				
				arr[index] = num;
				m--;
			}else {
				//상동
				int left = Integer.parseInt(st.nextToken())-1;
				int right = Integer.parseInt(st.nextToken())-1;			
				int sum =segmentSum(0, n-1, 1, left, right);
				System.out.println(sum);
				m--;
			}
		}
		
		//System.out.println(sb.toString());
	}
    
    // 트리 사이즈 구하기
	static int getTreeSize() {
		//2^-1 부터 시작하는 트리를 고려
		int h = (int)Math.ceil(Math.log(n)/Math.log(2)) +1;
		return (int)Math.pow(2, h)-1;
	}
    // 초기값 설정
	static int init(int start, int end, int node) {
		if(start == end) {
			return tree[node] = arr[start];
		}
		int mid = (start+end)/2;		
		return tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1);
	}
	
    
	static void update(int start, int end, int node, int index, long different) {
		if(start <= index && index <= end) {
			tree[node] += different;
		}else {
			return;		
		}
		if(start == end) {
			return;
		}
		int mid = (start+end)/2;
		update(start, mid, node*2, index, different);
		update(mid+1, end, node*2+1, index, different);
		
	}
	
    // 구간 합 구하기
	static int segmentSum(int start, int end, int node, int l, int r) {	
		if(r < start || l> end ) {
			return 0;
		}
		if(l <= start && end <= r ) {
			return tree[node];
		}
		int mid = (start+end)/2;	
		return segmentSum(start, mid, node*2, l, r) + segmentSum(mid+1, end, node*2+1, l, r);  
	}
}
