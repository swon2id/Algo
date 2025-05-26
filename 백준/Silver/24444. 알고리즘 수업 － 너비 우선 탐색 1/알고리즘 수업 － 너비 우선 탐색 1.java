import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        
        ArrayList<Integer>[] adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjList[u].add(v);
            adjList[v].add(u);
        }
        
        for (int i = 1; i <= N; i++) {
            Collections.sort(adjList[i]);
        }
        
        int[] visitOrder = new int[N + 1];
        bfs(adjList, visitOrder, R);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(visitOrder[i]).append('\n');
        }
        System.out.print(sb);
    }
    
    static void bfs(ArrayList<Integer>[] adjList, int[] visitOrder, int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[adjList.length];
        int order = 1;
        
        visited[start] = true;
        visitOrder[start] = order++;
        queue.offer(start);
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int next : adjList[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    visitOrder[next] = order++;
                    queue.offer(next);
                }
            }
        }
    }
}