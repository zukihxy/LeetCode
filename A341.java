package LeetCode;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class A341 {
	public interface NestedInteger {

		// @return true if this NestedInteger holds a single integer, rather
		// than a nested list.
		public boolean isInteger();

		// @return the single integer that this NestedInteger holds, if it holds
		// a single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger();

		// @return the nested list that this NestedInteger holds, if it holds a
		// nested list
		// Return null if this NestedInteger holds a single integer
		public List<NestedInteger> getList();
	}

	public class NestedIterator implements Iterator<Integer> {
		// 10ms, not good enough!
		// private Stack<NestedInteger> stack = new Stack<NestedInteger>();
		// private int next;
		// public NestedIterator(List<NestedInteger> nestedList) {
		// push(nestedList);
		// }
		//
		// @Override
		// public Integer next() {
		// return next;
		// }
		//
		// @Override
		// public boolean hasNext() {
		// if (stack.isEmpty())
		// return false;
		// NestedInteger ni = stack.pop();
		// if (ni.isInteger()) {
		// next = ni.getInteger();
		// return true;
		// } else {
		// push(ni.getList());
		// return hasNext();
		// }
		// }
		//
//		 private void push(List<NestedInteger> nestedList) {
//		 for (int i = nestedList.size()-1; i >= 0; i --)
//		 stack.push(nestedList.get(i));
//		 }
//		
//		// this version is faster because it do not involve recursion, 9ms
//		Stack<NestedInteger> stack = new Stack<>();
//		public NestedIterator(List<NestedInteger> nestedList) {
//			push(nestedList); // if do not involve function call, it will be 8ms
//		}
//
//		@Override
//		public Integer next() {
//			return stack.pop().getInteger();
//		}
//
//		@Override
//		public boolean hasNext() {
//			while (!stack.isEmpty()) {
//				NestedInteger curr = stack.peek();
//				if (curr.isInteger()) {
//					return true;
//				}
//				stack.pop();
//				push(curr.getList());
//			}
//			return false;
//		}
		
		// this version is 7ms, with iterator
		NestedInteger nextInt;
	    Stack<Iterator<NestedInteger>> stack;

	    public NestedIterator(List<NestedInteger> nestedList) {
	        stack = new Stack<Iterator<NestedInteger>>();
	        stack.push(nestedList.iterator());
	    }

	    @Override
	    public Integer next() {
	        return nextInt != null ? nextInt.getInteger() : null; //Just in case
	    }

	    @Override
	    public boolean hasNext() { // actually similar thought
	        while (!stack.isEmpty()) {
	            if (!stack.peek().hasNext()) stack.pop();
	            else if ((nextInt = stack.peek().next()).isInteger()) return true;
	            else stack.push(nextInt.getList().iterator());
	        }
	        return false;
	    }
	}
}
