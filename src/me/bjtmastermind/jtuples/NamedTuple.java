package me.bjtmastermind.jtuples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.TreeMap;

@SuppressWarnings("rawtypes")
public class NamedTuple {
	private String name;
	private List<TreeMap<String, Object>> namedtuple;
	
	public NamedTuple() {
		this.name = "";
		this.namedtuple = new ArrayList<>();
	}
	
	private NamedTuple(String name, ArrayList<TreeMap<String, Object>> array) {
		this.name = name;
		this.namedtuple = array;
	}
	
	public boolean containsAllKeys(String... keys) {
		ArrayList<Boolean> check = new ArrayList<>();
		for(String key : keys) {
			for(int i = 0; i < this.namedtuple.size(); i++) {
				TreeMap<String, Object> map = this.namedtuple.get(i);
				for(String tupleKey : map.keySet()) {
					if(tupleKey.equals(key)) {
						check.add(this.namedtuple.get(i).containsKey(key));
					}
				}
			}
		}
		if(check.size() == keys.length) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean containsAllValues(Object... values) {
		ArrayList<Boolean> check = new ArrayList<>();
		for(Object value : values) {
			for(int i = 0; i < this.namedtuple.size(); i++) {
				TreeMap<String, Object> map = this.namedtuple.get(i);
				for(Object tupleValue : map.values()) {
					if(tupleValue.equals(value)) {
						check.add(this.namedtuple.get(i).containsValue(value));
					}
				}
			}
		}
		if(check.size() == values.length) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean containsKey(String key) {
		for(int i = 0; i < namedtuple.size(); i++) {
			TreeMap<String, Object> map = namedtuple.get(i);
			for(Object obj : map.keySet()) {
				if(obj.equals(key)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean containsValue(Object value) {
		for(int i = 0; i < namedtuple.size(); i++) {
			TreeMap<String, Object> map = namedtuple.get(i);
			for(Object obj : map.values()) {
				if(obj.equals(value)) {
					return true;
				}
			}
		}
		return false;
	}

	public Object get(String key) {
		for(int i = 0; i < namedtuple.size(); i++) {
			TreeMap<String, Object> map = namedtuple.get(i);
			for(Object obj : map.keySet()) {
				if(obj.equals(key)) {
					return map.get(obj);
				}
			}
		}
		return null;
	}

	public int indexOfKey(String key) {
		int index = 0;
		for(int i = 0; i < namedtuple.size(); i++) {
			TreeMap<String, Object> map = namedtuple.get(i);
			for(Object obj : map.keySet()) {
				if(obj.equals(key)) {
					return index;
				} else {
					index++;
				}
			}
		}
		return -1;
	}
	
	public int indexOfValue(Object value) {
		int index = 0;
		for(int i = 0; i < namedtuple.size(); i++) {
			TreeMap<String, Object> map = namedtuple.get(i);
			for(Object obj : map.values()) {
				if(obj.equals(value)) {
					return index;
				} else {
					index++;
				}
			}
		}
		return -1;
	}

	public boolean isEmpty() {
		return namedtuple.isEmpty();
	}

	public Iterator iterator() {
		return namedtuple.iterator();
	}
	
	public ArrayList<String> keySet() {
		ArrayList<String> set = new ArrayList<>();
		for(int i = 0; i < this.size(); i++) {
			set.addAll(this.namedtuple.get(i).keySet());
		}
		return set;
	}

	public int lastIndexOfKey(String key) {
		int index = namedtuple.size() - 1;
		for(int i = namedtuple.size() - 1; i >= 0; i--) {
			TreeMap<String, Object> map = namedtuple.get(i);
			for(Object obj : map.keySet()) {
				if(obj.equals(key)) {
					return index;
				} else {
					index--;
				}
			}
		}
		return -1;
	}
	
	public int lastIndexOfValue(Object value) {
		int index = namedtuple.size() - 1;
		for(int i = namedtuple.size() - 1; i >= 0; i--) {
			TreeMap<String, Object> map = namedtuple.get(i);
			for(Object obj : map.values()) {
				if(obj.equals(value)) {
					return index;
				} else {
					index--;
				}
			}
		}
		return -1;
	}
	
	public Tuple merge(NamedTuple mergeWith) {
		List<NamedTuple> toMerge = (List<NamedTuple>) Arrays.asList(this, mergeWith);
		List<Object> merged = new ArrayList<>();
		for(NamedTuple nt : toMerge) {
			for(Object value : nt.values()) {
				merged.add(value);
			}
		}
		return new Tuple(merged);
	}

	public ListIterator tupleIterator() {
		return namedtuple.listIterator();
	}

	public ListIterator tupleIterator(int arg0) {
		try {
			return namedtuple.listIterator(arg0);
		} catch(IndexOutOfBoundsException e) {
			throw e;
		}
	}

	public int size() {
		return namedtuple.size();
	}
	
	public TreeMap<String, Object> toHashMap() {
		TreeMap<String, Object> outMap = new TreeMap<>();
		for(int i = 0; i < this.namedtuple.size(); i++) {
			for(String key : this.namedtuple.get(i).keySet()) {
				outMap.put(key, this.namedtuple.get(i).get(key));
			}			
		}
		return outMap;
	}
	
	@Override
	public String toString() {
		String out = this.name + "(";
		for(int i = 0; i < namedtuple.size(); i++) {
			TreeMap<String, Object> map = namedtuple.get(i);
			for(Object obj : map.keySet()) {
				if(i >= namedtuple.size() - 1) {
					if(map.get(obj) instanceof String) {
						out += obj + "=";
						out += "\"";
						out += map.get(obj) + "\"";
					} else {
						out += obj + "=" + map.get(obj);
					}
				} else {
					if(map.get(obj) instanceof String) {
						out += obj + "=";
						out += "\"";
						out += map.get(obj) + "\", ";
					} else {
						out += obj + "=" + map.get(obj) + ", ";
					}
				}
			}		
		}
		return out += ")";
	}
	
	public ArrayList<Object> values() {
		ArrayList<Object> values = new ArrayList<>();
		for(int i = 0; i < this.namedtuple.size(); i++) {
			for(Object value : this.namedtuple.get(i).values()) {
				values.add(value);
			}
		}	
		return values;
	}
	
	public static class with {
		private String name;
		private ArrayList<TreeMap<String, Object>> array;
		
		public with(String name, String key, Object value) {
			this.name = name;
			this.array = new ArrayList<>();
			with(key, value);
		}
		
		public with with(String key, Object value) {
			TreeMap<String, Object> item = new TreeMap<>();
			item.put(key, value);
			array.add(item);
			return this;
		}
		
		public NamedTuple end() {
			return new NamedTuple(name, array);
		}
	}
}
