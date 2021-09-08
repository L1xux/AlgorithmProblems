
import java.util.*;
import java.io.*;


public class Steven {
    private static int max = 1;
    	static class Point{
    	int num, distance;
    	
    	Point(){
    		
    	}
    	
    	Point(int num, int distance){
    		this.num = num;
    		this.distance = distance;
    	}
    	
    }
    
    public static boolean findCentroid(int now, int distance, Point last, boolean[] visited, List<Integer>[] lEdges, List<Integer> res) {
    	if(now == last.num) {
    		return true;
    	}
    	
    	visited[now] = true;
    	
    	for(Integer next : lEdges[now]) {
    		if(!visited[next] && findCentroid(next, distance + 1, last, visited, lEdges, res)) {
    			if(max % 2 == 1 && max / 2 == distance - 1) {
    				res.add(now);
    			} else if(max % 2 == 0 && max / 2 == distance || max / 2 == distance - 1){
    				res.add(now);
    			}
    			
    			return true;
    		}
    	}
    	
    	
    	return false;
    }
    
    public static void findTheLastPoint(int now, int distance, Point point, boolean[] visited, List<Integer>[] lEdges) {
    	visited[now] = true;
    	
    	if(max < distance) {
    		point.num = now;
    		point.distance = distance;
    		max = distance;
    	}
    	
    	for(Integer next : lEdges[now]) {
    		if(!visited[next])
    			findTheLastPoint(next, distance + 1, point, visited, lEdges);
    	}
    }
    
	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
   		List<Integer>[] lEdges = new List[n];
        	
    	for(int j = 0 ; j < n ; j++) {
       		lEdges[j] = new ArrayList<>();
       	}
        	
        for(int j = 0 ; j < n-1 ; j++) {
        	lEdges[edges[j][0]].add(edges[j][1]);
       		lEdges[edges[j][1]].add(edges[j][0]);
        }

    	Point start = new Point();
    	Point last = new Point();
    	
    	List<Integer> res = new ArrayList<>();
    	if(n > 2) {
    		max = 1;
    		findTheLastPoint(edges[0][0], 1, start, new boolean[n], lEdges);
    		start.distance = 0;

    		max = 1;
    		findTheLastPoint(start.num, 1, last, new boolean[n], lEdges);
    		
    		findCentroid(start.num, 1, last, new boolean[n], lEdges, res);
    	} else if(n == 2){
    		res.add(0);
    		res.add(1);
    	} else {
    		res.add(0);
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

