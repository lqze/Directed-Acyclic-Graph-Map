import java.util.*;
import java.lang.*;

public class DAGMapDemo {

	public static void main(String[] args)
	{
		System.out.println("Creating graph");
		DirAcycGraph myGraph = new DirAcycGraph();
		Key A = new Key();
		Key B = new Key();
		Key C = new Key();
		Key D = new Key();
		Key E = new Key();
		Key F = new Key();
		Key Z = new Key();

		System.out.println();
		System.out.println("Add keys to graph");

		myGraph.put(A,"a");
		myGraph.put(B,"b");
		myGraph.put(C,"c");
		myGraph.put(D,"d");
		myGraph.put(Z,"z");
		myGraph.put(E,"e");
		myGraph.put(F,"f");
		System.out.println(myGraph.toString());


		System.out.println();
		System.out.println("Add dependencies between keys");

		myGraph.addDependency(A,B);
		myGraph.addDependency(B,C);
		myGraph.addDependency(C,D);
		myGraph.addDependency(D,E);
		myGraph.addDependency(F,C);
		myGraph.addDependency(Z,F);
		myGraph.addDependency(A,Z);
		System.out.println(myGraph.toString());

		System.out.println();
		System.out.println("Cloning graph");

		DirAcycGraph newGraph = myGraph.clone();

		// testing clone and equals functions
		System.out.println();
		System.out.println("Are graphs the same: "+myGraph.equals(newGraph));


		System.out.println();
		System.out.println("Remove node from new graph");
		newGraph.remove(E);

		// testing clone and equals functions
		System.out.println();
		System.out.println("Are graphs the same: "+myGraph.equals(newGraph));

		// testing getMaxFlow
		System.out.println();
		System.out.print("Possible sequences from node A to node C: ");
		System.out.println(myGraph.getMaxFlow(A,C));

		System.out.print("Get longest path in graph: ");
		System.out.println(myGraph.getLongestPath());

		System.out.print("Get width of graph: ");
		System.out.println(myGraph.getWidth());

		System.out.println("Graph contains key D: "+myGraph.containsKey(D));
		System.out.println("Graph contains value \"z\": "+myGraph.containsValue("z"));
	}

}