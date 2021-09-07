
import java.util.*;
import java.io.*;


public class Steven {
    public static int bfs(int n, int start, List<Integer>[] lEdges) {
    	Queue<Integer> q = new LinkedList<>();
    	
    	
    	boolean[] visited = new boolean[n];
    	int[] height = new int[n];
    	
    	q.add(start);
    	visited[start] = true;
    	
    	while(!q.isEmpty()) {
    		int now = q.poll();
    		
    		for(Integer next : lEdges[now]) {
    			if(!visited[next]) {
    				visited[next] = true;
    				height[next] = height[now] + 1;
    				q.add(next);
    			}
    		}
    	}
    	
    	int res = height[0];
    	for(int i = 1 ; i < n ; i++) {
    		res = Math.max(res, height[i]);
    	}
    	
    	return res;
    }
	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
    	int[] candidates = new int[n];
    	int min = Integer.MAX_VALUE;
    	
		for(int i = 0 ; i < n ; i++) {
    		List<Integer>[] lEdges = new List[n];
        	
    		for(int j = 0 ; j < n ; j++) {
        		lEdges[j] = new ArrayList<>();
        	}
        	
        	for(int j = 0 ; j < n-1 ; j++) {
        		lEdges[edges[j][0]].add(edges[j][1]);
        		lEdges[edges[j][1]].add(edges[j][0]);
        	}
        	
        	candidates[i] = bfs(n, i, lEdges);
        	min = Math.min(min, candidates[i]);
		}

		List<Integer> res = new ArrayList<Integer>();
		for(int i = 0 ; i < n ; i++) {
			if(candidates[i] == min)
				res.add(i);
		}
    	
    	return res;
    }
    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int[][] edges = new int[N-1][2];
		
		for(int i = 0 ; i < N-1 ; i++) {
			st = new StringTokenizer(br.readLine());
			
			edges[i][0] = Integer.parseInt(st.nextToken());
			edges[i][1] = Integer.parseInt(st.nextToken());
		}
		
		List<Integer> res = new ArrayList<>();
		res = findMinHeightTrees(N, edges);
		
		for(Integer num : res) {
			bw.write(num + " ");
		}
		
		bw.write("\n");
		
		bw.flush();
		
		br.close();
		bw.close();
	}

}

