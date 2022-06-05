package me.bjtmastermind.jtuples;

public class NamedTupleTemplate {
	String name;
	String[] keys;
	int keyCount;
	
	public NamedTupleTemplate(String name, String... keys) {
		this.name = name;
		this.keys = keys;
		this.keyCount = keys.length;
	}
}
