package me.bjtmastermind.jtuples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class NamedTuple {
	private String name;
	private LinkedHashMap<String, Object> namedtuple;
	
	public NamedTuple(NamedTupleTemplate template, Object... values) throws Exception {
		if(values.length != template.keyCount) {
			throw new Exception("Value argument count is not equal to template argument count.");
		}
		this.name = template.name;
		this.namedtuple = new LinkedHashMap<>();
		for(int i = 0; i < template.keyCount; i++) {
			this.namedtuple.put(template.keys[i], values[i]);
		}
	}
	
	public boolean containsAllKeys(String... keys) {
		ArrayList<Boolean> check = new ArrayList<>();
		for(String key : keys) {
			for(String tupleKey : this.namedtuple.keySet()) {
				if(tupleKey.equals(key)) {
					check.add(this.namedtuple.containsKey(key));
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
				for(Object tupleValue : this.namedtuple.values()) {
					if(tupleValue.equals(value)) {
						check.add(this.namedtuple.containsValue(value));
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
		return this.namedtuple.containsKey(key);
	}
	
	public boolean containsValue(Object value) {
		return this.namedtuple.containsValue(value);
	}

	public Object get(String key) {
		return this.namedtuple.get(key);
	}

	public int indexOfKey(String key) {
		int index = 0;
		for(String tupleKey : this.namedtuple.keySet()) {
			if(tupleKey.equals(key)) {
				return index;
			} else {
				index++;
			}
		}
		return -1;
	}
	
	public int indexOfValue(Object value) {
		int index = 0;
		for(Object tupleValue : this.namedtuple.values()) {
			if(tupleValue.equals(value)) {
				return index;
			} else {
				index++;
			}
		}
		return -1;
	}

	public boolean isEmpty() {
		return this.namedtuple.isEmpty();
	}
	
	public Set<String> keySet() {
		return this.namedtuple.keySet();
	}

	public int lastIndexOfKey(String key) {
		int index = this.namedtuple.size() - 1;
		for(String tupleKey : this.namedtuple.keySet()) {
			if(tupleKey.equals(key)) {
				return index;
			} else {
				index--;
			}
		}
		return -1;
	}
	
	public int lastIndexOfValue(Object value) {
		int index = namedtuple.size() - 1;
		for(Object tupleValue : this.namedtuple.values()) {
			if(tupleValue.equals(value)) {
				return index;
			} else {
				index--;
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

	public int size() {
		return namedtuple.size();
	}
	
	public LinkedHashMap<String, Object> toHashMap() {
		LinkedHashMap<String, Object> outMap = new LinkedHashMap<>();
		for(String key : this.namedtuple.keySet()) {
			outMap.put(key, this.namedtuple.get(key));
		}			
		return outMap;
	}
	
	@Override
	public String toString() {
		String out = this.name + "(";
		int i = 0;
		for(String key : this.namedtuple.keySet()) {
			if(i >= this.namedtuple.size() - 1) {
				if(this.namedtuple.get(key) instanceof String) {
					out += key + "=";
					out += "\"";
					out += this.namedtuple.get(key) + "\"";
				} else {
					out += key + "=" + this.namedtuple.get(key);
				}
			} else {
				if(this.namedtuple.get(key) instanceof String) {
					out += key + "=";
					out += "\"";
					out += this.namedtuple.get(key) + "\", ";
				} else {
					out += key + "=" + this.namedtuple.get(key) + ", ";
				}
			}
			i++;
		}
		return out + ")";
	}
	
	public Collection<Object> values() {
		return this.namedtuple.values();
	}
}
