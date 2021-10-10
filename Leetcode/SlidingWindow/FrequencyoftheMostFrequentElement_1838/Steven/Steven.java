import java.util.*;
import java.io.*;

public class Steven {
    public static int maxFrequency(int[] nums, int k) {
    	Arrays.sort(nums);
    	
        int res = 0;
    	
        int l = 0, r = 0;
    	long lSum = 0, rSum = 0;
    	
    	for(r = 0 ; r < nums.length ; r++) {
    		rSum+=nums[r];
    		
    		while(l < r && nums[r] * (r - l + 1) - (rSum - lSum) > k) {
    			lSum+=nums[l];
    			l++;
    		}
    		
    		res = Math.max(res,  r - l + 1);
    	}
    	
    	return res;
    }
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int L = Integer.parseInt(br.readLine());
		
		int[] nums = new int[L];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < L ; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int K = Integer.parseInt(br.readLine());
		
		bw.write(maxFrequency(nums, K) + "\n");
		
		bw.flush();
		
		br.close();
		bw.close();
	}
}

