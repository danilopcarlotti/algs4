package stacks;

public class stacksLinkedList <T>{

	private Node first = null;
	
	public class Node {
		T item;
		Node next;
	}
	
	public boolean isEmpty() {
		return (first == null);
	}
	
	public void push(T newItem) {
		Node old = new Node();
		old.item = newItem;
		old.next = first;
		first = old;
	}
	
	public T pop() {
		if (this.isEmpty()){
			 throw new IllegalArgumentException();
		}
		T lastItem = first.item;
		first = first.next;
		return lastItem;
	}
	
	public static void main(String[] args) {
		stacksLinkedList<Integer> S = new stacksLinkedList<Integer>();
		S.push(100);
		System.out.println(S.isEmpty());
		System.out.println(S.pop());
		System.out.println(S.isEmpty());
	}

}
