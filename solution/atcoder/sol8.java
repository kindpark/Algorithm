package atcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class sol8 {
    // 상 하 좌 우 대각선 을 위한 변수
    static int[] mx = {1, -1, 0, 0, 1, -1, -1, 1};
    static int[] my = {0, 0, 1, -1, -1, -1, 1, 1};
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int count = 0;
            map = new char[h+1][w+1];
            for(int i=1; i<=h; i++){
                String st1 = br.readLine();
                for(int j=1; j<=w; j++){
                    map[i][j] = st1.charAt(j-1);
                }
            }
            
            boolean[][] visited = new boolean[h+1][w+1];
            for(int i=1; i<=h; i++){
                for(int j=1; j<=w; j++){
                    if(!visited[i][j] && map[i][j]=='#'){
                        count++;
                        bfs(map,w,h,i,j,visited);
                    }
                }
            }
        
        System.out.println(count);
    }
    static void bfs(char[][] map, int w, int h, int x, int y, boolean[][] visited){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y));
        visited[x][y] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int i=0; i<8; i++){
                int px = node.x + mx[i];
                int py = node.y + my[i];

                if(px>0 && py>0 && px<=h && py<=w){
                    if(!visited[px][py] && map[px][py]=='#'){
                        visited[px][py] = true;
                        queue.add(new Node(px,py));
                    }
                }
            }
        }
    }

    static class Node{
        int x,y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
