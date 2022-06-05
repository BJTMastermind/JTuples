package test.bjtmastermind.jtuples;

import java.util.ArrayList;

import me.bjtmastermind.jtuples.NamedTuple;
import me.bjtmastermind.jtuples.NamedTupleTemplate;
import me.bjtmastermind.jtuples.Tuple;

public class Test {

	public static void main(String[] args) throws Exception {
		Tuple tupleTest = new Tuple("String 1", 59, 99.99f);
		System.out.println(tupleTest);
			
		NamedTupleTemplate color = new NamedTupleTemplate("color", "r", "g", "b");
		
		NamedTuple rgb = new NamedTuple(color, 255, 127, 63);
		System.out.println(rgb);
		
		ArrayList<Tuple> arrayTest = new ArrayList<>();
		arrayTest.add(new Tuple(1, 2, 3));
		arrayTest.add(new Tuple(4, 5, 6));
		arrayTest.add(new Tuple(7, 8, 9));
		System.out.println(arrayTest);
		
		ArrayList<NamedTuple> newArrayTest1 = new ArrayList<>();
		newArrayTest1.add(new NamedTuple(color, 1, 2, 3));
		newArrayTest1.add(new NamedTuple(color, 4, 5, 6));
		newArrayTest1.add(new NamedTuple(color, 7, 8, 9));
		System.out.println(newArrayTest1);
	}

}
