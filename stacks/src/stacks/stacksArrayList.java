package stacks;

import java.util.ArrayList;
import java.util.Iterator;

public class stacksArrayList <T> extends ArrayList<T>{

	public ArrayList<T> listOfObjects = new ArrayList<T>();
	
	public void push(T e) {
		this.listOfObjects.add(e);
	}
	
	public T pop() {
		T lastItem = listOfObjects.get(listOfObjects.size() - 1);
		listOfObjects.remove(lastItem);
		return lastItem;
	}
	
	public Iterator<T> iterator(){
		return listOfObjects.iterator();
	}
	
	public static void main(String[] args)  {
		stacksArrayList<Integer> s = new stacksArrayList<Integer>();
		s.push(100);
		Iterator<Integer> it = s.listOfObjects.iterator();
		while (it.hasNext()) {
			Integer x = it.next();
			System.out.println(x);
		}
		System.out.println(s.pop());
	}
}
