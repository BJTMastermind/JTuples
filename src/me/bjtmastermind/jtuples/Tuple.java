package me.bjtmastermind.jtuples;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@SuppressWarnings("rawtypes")
public class Tuple {
	private List<Object> tuple;
	
	public Tuple(Object... values) {
		this.tuple = new ArrayList<>();

		for(int i = 0; i < values.length; i++) {
			this.tuple.add(values[i]);
		}
	}
	
	Tuple(List<Object> array) {
		this.tuple = array;
	}

	public boolean contains(Object arg0) {
		try {
			tuple.contains(arg0);
			return true;
		} catch(ClassCastException | NullPointerException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean containsAll(Collection arg0) {
		try {
			tuple.containsAll(arg0);
			return true;
		} catch(ClassCastException | NullPointerException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public int count(Object value) {
		int count = 0;
		for(int i = 0; i < tuple.size(); i++) {
			if(tuple.get(i).equals(value)) {
				count++;
			}
		}
		return count;
	}

	public Object get(int index) {
		try {
			return tuple.get(index);
		} catch(IndexOutOfBoundsException e) {
			e.printStackTrace();
			return "";
		}
	}

	public int indexOf(Object arg0) {
		try {
			return tuple.indexOf(arg0);
		} catch(ClassCastException | NullPointerException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public boolean isEmpty() {
		return tuple.isEmpty();
	}

	public Iterator iterator() {
		return tuple.iterator();
	}

	public int lastIndexOf(Object arg0) {
		try {
			return tuple.lastIndexOf(arg0);
		} catch(ClassCastException | NullPointerException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public ListIterator tupleIterator() {
		return tuple.listIterator();
	}

	public ListIterator tupleIterator(int arg0) {
		try {
			return tuple.listIterator(arg0);
		} catch(IndexOutOfBoundsException e) {
			e.printStackTrace();
			return null;
		}
	}

	public int size() {
		return tuple.size();
	}
	
	@Override
	public String toString() {
		String out = "(";
		for(int i = 0; i < tuple.size(); i++) {
			if(i >= tuple.size() - 1) {
				if(tuple.get(i) instanceof String) {
					out += "\"";
					out += tuple.get(i) + "\"";
				} else {
					out += tuple.get(i);
				}
			} else {
				if(tuple.get(i) instanceof String) {
					out += "\"";
					out += tuple.get(i) + "\", ";
				} else {
					out += tuple.get(i) + ", ";
				}
			}			
		}
		return out += ")";
	}
}
