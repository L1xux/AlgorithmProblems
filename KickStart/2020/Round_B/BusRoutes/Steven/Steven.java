
public class Steven {
	private static int N;
	private static long D;
	
	public static long solve(long[] map) {
		List<Long> list = new ArrayList<Long>();
		
		list.add(D);
		
		for(int i = N-1 ; i >= 0 ; i--) {
			long val = (list.get((N-1) - i) / map[i]) * map[i];
			list.add(val);
		}
		
		return list.get(list.size()-1);
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = in.nextInt();
		in.nextLine();
		
		for(int t = 1 ; t <= T ; t++) {
			StringTokenizer st = new StringTokenizer(in.nextLine());
			
			N = Integer.parseInt(st.nextToken());
			D = Long.parseLong(st.nextToken());
			
			long[] map = new long[N];
			
			st = new StringTokenizer(in.nextLine());
			
			for(int i = 0 ; i < N ; i++) {
				map[i] = Long.parseLong(st.nextToken());
			}
			
			bw.write("Case #" + t + ": " + solve(map) + "\n");
		}
		
		bw.flush();
		
		in.close();
		bw.close();
	}
}

