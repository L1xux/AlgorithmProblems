import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


/**
 * 
 * @author mr938
 *	Given the root of a binary tree, split the binary tree into two subtrees by removing one edge such 
 *	that the product of the sums of the subtrees is maximized.
 *	Return the maximum product of the sums of the two subtrees. Since the answer may be too large, return it modulo 109 + 7.
 *	(Note that you need to maximize the answer before taking the mod and not after taking it.)
 */

/*
 * 1. 바이너리 트리에서 하나의 edge를 제거해서 쪼개진 두 개의 subtrees의 곱셈이 최대가 되게 하라. 
 * 2. Maximize S1 * S2 (S is a subtree) 
 * 3. 	A. dfs로 tree의 전체합을 구할 수 있다. 
 * 		B. dfs로 구해진 tree에서 (node - child node) * child node를 candidate로 둔다. (child node는 left와 right를 의미한다.)
 * 
 * 4. dfs로 각 노드를 한번 씩 travesal한다. 또한 candidate 구할 때 각 노드를 한번 씩 방문하므로 time complexity는 O(N)므로 충분히 통과할 수 있다.
 * 
 */


class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { 
		this.val = val;
	}
	
	TreeNode(int val, TreeNode left, TreeNode right){
		this.val = val;
		this.left = left;
		this.right= right;
	}
}

public class MaximumProductofSplittedBinaryTree_1339 {
	private static final int MOD = (int)(Math.pow(10, 9)) + 7;
	
	public static long dfs(TreeNode root) {
		if(root == null)
			return 0;
		
		long subtree = dfs(root.left) + dfs(root.right);
		
		root.val+=subtree; 
		
		return root.val;
	}
	
	public static long getMiximumValue(TreeNode now, int rootVal, long candidate) {
		if(now == null)
			return candidate;
		
		candidate = Math.max(candidate, getMiximumValue(now.left, rootVal, candidate));
		candidate = Math.max(candidate, getMiximumValue(now.right, rootVal, candidate));
		
		candidate = Math.max(candidate, ((rootVal - now.val) * (long)now.val));
		
		return candidate;
	}
	
    public static int solve(TreeNode root) {
        dfs(root);
		return (int)(getMiximumValue(root, root.val, 0) % MOD);
    }
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		TreeNode root = new TreeNode();
		root.val = 1;
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(4);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(6);
		
		bw.write(solve(root) + "\n");
		
		bw.flush();
		
		br.close();
		bw.close();
	}
}

