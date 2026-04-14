import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int T;
    static int M, N, K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int count;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int t = 0; t < T; t++){
            count = 0;
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
        
            map = new int[N][M];
            visited = new boolean[N][M];
        
            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
            
                map[y][x] = 1;
            }
        
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(map[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        sb.deleteCharAt(sb.lastIndexOf("\n"));
        
        System.out.println(sb);
    }
    private static void dfs(int x, int y) {
        visited[x][y] = true;
        
        for(int i = 0; i < 4; i++){
            int nX = x + dx[i];
            int nY = y + dy[i];
            
            if (nX < 0 || nY < 0 || nX >= N || nY >= M || visited[nX][nY]) {
                continue;
            }
            
            if (map[nX][nY] == 1) {
                dfs(nX, nY);
            }
        }
    }
}