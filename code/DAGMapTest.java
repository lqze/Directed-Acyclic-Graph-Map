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
		Key Z = new Key();
		Key EZ = new Key();
		Key EZEZ = new Key();
		Key SQUEEZY = new Key();
		String v = "woo";

		myGraph.put(A,"a");
		myGraph.put(B,"b");
		myGraph.put(C,"c");
		myGraph.put(D,"d");
		myGraph.put(Z,"z");
		myGraph.put(EZ,"ez");
		myGraph.put(EZEZ,"ezez");
		myGraph.put(SQUEEZY,"squeezy");

		myGraph.addDependency(A,B);
		myGraph.addDependency(B,D);
		myGraph.addDependency(A,C);
		myGraph.addDependency(C,D);
		myGraph.addDependency(A,Z);
		myGraph.addDependency(Z,D);
		myGraph.addDependency(SQUEEZY,A);
		myGraph.addDependency(SQUEEZY,EZ);
		myGraph.addDependency(SQUEEZY,Z);
		myGraph.addDependency(EZEZ,Z);
		myGraph.addDependency(EZ,B);

		System.out.println(myGraph.getMaxFlow(SQUEEZY,D));
	}

}
