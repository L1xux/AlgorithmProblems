import java.util.*;
import java.io.*;

public class Steven {
	private static class Vertex{
		int n;
		double possibility;
		int time;
		
		Vertex(int n, double possibility, int time){
			this.n = n;
			this.possibility = possibility;
			this.time = time;
		}
	}
	
    public static double frogPosition(int n, int[][] edges, int t, int target) {
    	List<Integer>[] tree = new ArrayList[n+1];
        
        for(int i = 0 ; i <= n ; i++) {
        	tree[i] = new ArrayList<>();
        }
        
        for(int i = 0 ; i < n - 1 ; i++) {
        	tree[edges[i][0]].add(edges[i][1]);
        	tree[edges[i][1]].add(edges[i][0]);
        }
        
        tree[1].add(0);
        
        Vertex start = new Vertex(1, 1, 0);
        Queue<Vertex> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        
        q.offer(start);
        visited[0] = visited[1] = true;
       
        
        while(!q.isEmpty()) {
        	Vertex now = q.poll();
        	int nowVertex = now.n;
        	double nowPoss = now.possibility;
        	int nowTime = now.time;
        	
        	if(nowVertex == target) {
        		if(nowTime < t && tree[nowVertex].size() - 1 == 0) {
        			return nowPoss;
        		} if(nowTime < t && tree[nowVertex].size() - 1 > 0) {
        			return 0;
        		} if(nowTime == t) {
            		return nowPoss;
            	}
        	}
        	
        	for(int nextVertex : tree[nowVertex]) {
        		if(!visited[nextVertex]) {
            		double nextPoss = (1.0 / (tree[nowVertex].size() - 1)) * nowPoss;
            		
            		visited[nextVertex] = true;
            		q.offer(new Vertex(nextVertex, nextPoss, nowTime + 1));
        		}
        	}
        }
        
    	return 0;
    }
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[][] edges = new int[n-1][2];
		
		StringTokenizer st = new StringTokenizer("");
		
		for(int i =  0 ; i < n - 1 ; i++) {
			st = new StringTokenizer(br.readLine());
			
			edges[i][0] = Integer.parseInt(st.nextToken());
			edges[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int t = Integer.parseInt(br.readLine());
		int target = Integer.parseInt(br.readLine());
		
		bw.write(frogPosition(n, edges, t, target) + "\n");
		
		bw.flush();
		
		br.close();
		bw.close();
	}
}
