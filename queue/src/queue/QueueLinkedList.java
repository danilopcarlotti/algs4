package queue;

public class QueueLinkedList <T>{

	Node first = null;
	Node last = null;
	
	public class Node {
		T item;
		Node next;
	}
	
	public boolean isEmpty() {
		return (first == null);
	}
	
	public void enqueue(T newItem) {
		Node oldlast = last;
		last = new Node();
		last.item = newItem;
		last.next = null;
		if (isEmpty()) {
			first = last;
		}
		else {
			oldlast.next = last;
		}
	}
	
	public T dequeue() {
		if (isEmpty()) throw new IllegalArgumentException();
		Node oldfirst = first;
		first = first.next;
		if (isEmpty()) {
			last = null;
		}
		return oldfirst.item;
	}
	
	public static void main(String[] args) {
		

	}

}
