import java.io.*;
import java.util.*;

class Polyomino{
	char alpha;
	Set<Polyomino> degree;
	Set<Polyomino> children;
	
	boolean isVisited;
	
	Polyomino(){}
	
	Polyomino(char alpha){
		this.alpha = alpha;
		degree = new HashSet<Polyomino>();
		children = new HashSet<Polyomino>();
	}
}

public class Steven {
	private static int[] NR = new int[] {0, 0, 1, -1};
	private static int[] NC = new int[] {1, -1, 0, 0};
	
	private static int R, C;
	
	public static void dfs(int nr, int nc, char[][] map, Map<Character, Polyomino> polyominoes, boolean[][] visited) {
		if(visited[nr][nc])
			return;
		visited[nr][nc] = true;
		
		for(int i = 0 ; i < 4 ; i++) {
			int nextR = nr + NR[i];
			int nextC = nc + NC[i];
			
			if(nextR < 0 || nextR >= R || nextC < 0 || nextC >= C)
				continue;
			
			if(map[nr][nc] == map[nextR][nextC])
				dfs(nextR, nextC, map, polyominoes, visited);
			if(i == 2 && map[nr][nc] != map[nextR][nextC]) {
				polyominoes.get(map[nextR][nextC]).children.add(polyominoes.get(map[nr][nc]));
				polyominoes.get(map[nr][nc]).degree.add(polyominoes.get(map[nextR][nextC]));
			}
		}
	}
	
	public static String solve(char[][] map, Map<Character, Polyomino> polyominoes) {
		boolean[][] visited = new boolean[R][C];
		
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				if(!visited[i][j])
					dfs(i, j, map, polyominoes, visited);
			}
		}
		
		Iterator<Character> itrC = polyominoes.keySet().iterator();
		Queue<Polyomino> queue = new LinkedList<>();
		
		while(itrC.hasNext()) {
			Polyomino polyomino = polyominoes.get(itrC.next());
			
			if(polyomino.degree.size() == 0) {
				queue.offer(polyomino);
			}
		}
		
		if(queue.isEmpty()) { 
			return "-1";
		}
		
		String res = "";
		while(!queue.isEmpty()) {
			Polyomino now = queue.poll();
			
			res+=now.alpha;
			
			now.isVisited = true;
			
			Iterator<Polyomino> itrP = now.children.iterator();
			while(itrP.hasNext()) {
				Polyomino polyomino = itrP.next(); 
				
				if(polyomino.isVisited)
					return "-1";
				
				queue.add(polyomino);
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) throws Exception{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int T = in.nextInt();
		in.nextLine();
		
		for(int t = 1 ; t <= T ; t++) {
			StringTokenizer st = new StringTokenizer(in.nextLine());
			
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			char[][] map = new char[R][C];
			Map<Character, Polyomino> polyominoes = new HashMap<>();
			
			for(int i = 0 ; i < R ; i++) {
				char[] line = in.nextLine().toCharArray();
				for(int j = 0 ; j < C ; j++) {
					map[i][j] = line[j];
					polyominoes.put(map[i][j], new Polyomino(map[i][j]));
				}
				
			}
	
			bw.write("Case #" + t + ": " + solve(map, polyominoes) + "\n");
		}
		
		in.close();
		bw.close();
	}
}

