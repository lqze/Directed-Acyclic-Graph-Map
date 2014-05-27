import java.util.*;
import java.lang.*;

public class DAGMapTest {

	public static void main(String[] args)
	{
		DirAcycGraph myGraph = new DirAcycGraph();
		Key A = new Key();
		Key B = new Key();
		Key C = new Key();
		Key D = new Key();
		Key E = new Key();
		Key F = new Key();
		Key Z = new Key();
		Key Y = new Key();
		Key X = new Key();
		Key HI = new Key();
		String v = "woo";

		myGraph.put(A,"a");
		myGraph.put(B,"b");
		myGraph.put(C,"c");
		myGraph.put(D,"d");
		myGraph.put(E,"e");
		myGraph.put(F,"f");
		myGraph.put(X,"x");
		myGraph.put(Z,"z");
		myGraph.put(Y,"y");
		myGraph.put(HI,"hey");

		myGraph.addDependency(A,B);
		myGraph.addDependency(B,D);
		myGraph.addDependency(A,C);
		myGraph.addDependency(C,E);
		myGraph.addDependency(E,F);
		myGraph.addDependency(Z,E);
		myGraph.addDependency(X,Z);
		myGraph.addDependency(Y,X);
		myGraph.addDependency(F,HI);

		System.out.println(myGraph.getLongestPath());
	}

}