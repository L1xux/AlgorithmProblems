import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class HeightofBinary_2458_Steven {
	
	public static int setHeightFromBottomToNode(TreeNode now, int[] leftHeights, int[] rightHeights) {
		if(now == null) {
			return 0;
		}
		
		int leftHeight = setHeightFromBottomToNode(now.left, leftHeights, rightHeights);
		leftHeights[now.val] = leftHeight;
		
		int rightHeight = setHeightFromBottomToNode(now.right, leftHeights, rightHeights);
		rightHeights[now.val] = rightHeight;
		
		return 1 + Math.max(leftHeight, rightHeight);
	}
	
	
	public static void solve(TreeNode now, int[] heights, int[] leftHeights, int[] rightHeights, int height, int maximum) {
		if(now == null) {
			return;
		}
		
		heights[now.val] = maximum;
		
		solve(now.left, heights, leftHeights, rightHeights, height + 1, Math.max(height + rightHeights[now.val], maximum));
		solve(now.right, heights, leftHeights, rightHeights, height + 1, Math.max(height + leftHeights[now.val], maximum));
	}
	
	public static int[] treeQueries(TreeNode root, int[] queries) {
		int[] leftHeights = new int[100001];
		int[] rightHeights = new int[100001];
		int[] heights = new int[100001];
		
		setHeightFromBottomToNode(root, leftHeights, rightHeights);
		solve(root.left, heights, leftHeights, rightHeights, 1, rightHeights[root.val]);
		solve(root.right, heights, leftHeights, rightHeights, 1, leftHeights[root.val]);
		
		int N = queries.length;
		int[] res = new int[N];
		
		for(int i = 0 ; i < N ; i++) {
			res[i] = heights[queries[i]];
 		}
		
	
		return res;
    }
	
	public static void main(String[] args) {
		// Input: root = [1,3,4,2,null,6,5,null,null,null,null,null,7], queries = [4]
		// Output: [2]
		
		// Input: root = [5,8,9,2,1,3,7,4,6], queries = [3,2,4,8]
		// Output: [3,2,3,2]
		
		TreeNode root = new TreeNode(5);
		int[] queries = {8, 2, 4};
		
		root.left = new TreeNode(8);
		root.left.left = new TreeNode(2);
		root.left.left.left = new TreeNode(4);
		root.left.left.right = new TreeNode(6);
		root.left.right = new TreeNode(1);
		root.right = new TreeNode(9);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(7);
		
		System.out.println("Result: " + Arrays.toString(treeQueries(root, queries)));

	}

}
