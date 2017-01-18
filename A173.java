package LeetCode;

import java.util.Stack;

public class A173 {
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
//	  my solution: seem to be ok but hard to implement
//	  private TreeNode troot;
//	    private String last = "";
//	    private boolean isLeaf;
//
//	    /** @return whether we have a next smallest number */
//	    public boolean hasNext() {
//	        
//	    }
//
//	    /** @return the next smallest number */
//	    public int next() {
//	        if (last == "") {
//	            TreeNode n = troot;
//	            while (n.left != null) {
//	                n = n.left;
//	                last += "0";
//	                isLeaf = true;
//	            }
//	            return n.val;
//	        } else if (isLeaf && last.endsWith("0")) {
//	            last = last.substring(0, last.length()-1);
//	            isLeaf = true;
//	        } else if (isLeaf && last.endsWith("1")) {
//	            last = last.substring(0, last.lastIndexOf("0"));
//	            isLeaf = false;
//	        } else if (!isLeaf) {
//	        	// find the first node that is the left child of its parent
//	        }
//	    }
	private Stack<TreeNode> stack = new Stack<TreeNode>();
    
//    public BSTIterator(TreeNode root) {
//        pushAll(root);
//    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tmpNode = stack.pop();
        pushAll(tmpNode.right);
        return tmpNode.val;
    }
    
    private void pushAll(TreeNode node) {
        for (; node != null; stack.push(node), node = node.left);
    }
}
