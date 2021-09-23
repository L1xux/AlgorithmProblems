import java.util.*;
import java.io.*;

public class Steven {
	private static int res = 0; 
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		 
		TreeNode() {}
		 
		TreeNode(int val) { this.val = val; }
		 
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;   
		}
	}
	
	
	public static int solve(TreeNode now) {
		int left = 0;
		int right = 0;
		
		if(now.left != null) {
			left = solve(now.left);
			left = now.val == now.left.val ? left : 0;
		}
			
		if(now.right != null) {
			right = solve(now.right);
			right = now.val == now.right.val ? right : 0;
		}
		
		res = Math.max(res, left + right);
		
		return Math.max(left, right) + 1;
	}
	
	public static int longestUnivaluePath(TreeNode root) {
		if(root == null)
			return 0;
		
		res = 0;
		solve(root);
		
		return Math.max(res, 0);
	}
	
	
	public static void main(String[] args) throws Exception	{
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(4);
		root.left.left.left = new TreeNode(4);
		root.left.right.right = new TreeNode(4);
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(5);
		
		System.out.println(longestUnivaluePath(root));
	}
}

