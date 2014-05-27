import java.util.*;
import java.lang.*;

public class DAGMapTest {

	public static void main(String[] args)
	{
		DirAcycGraph myGraph = new DirAcycGraph();
		Key node1 = new Key();
		Key node2 = new Key();
		Key node3 = new Key();

		myGraph.put(node1,"myValue1");
		myGraph.put(node2,"myValue123");
		myGraph.put(node3,"myValue3");

		myGraph.addDependency(node1,node2);
		myGraph.addDependency(node2,node3);

		System.out.println(myGraph.isDependent(node1,node3));
	}

}