package solution;
import java.io.*;
import java.util.*;
public class segment {
	static int n;
	static int[] treeNode;
	static LinkedList<Integer>[] node;
	public static void treeConst(int[] arr, int n) {
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		node = new LinkedList[n+1];
		for(int i = 1; i <= n; i++) {
			node[i] = new LinkedList<>();
		}
		//구간 합 트리로 입력 된 상태
		for(int i = 1; i <= n; i++) {
			treeNode[i] = sc.nextInt();
		}
		for(int i = 0; i < n; i++) {
			
		}
	}
}
