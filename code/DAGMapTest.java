import java.util.*;
import java.lang.*;

public class DAGMapTest {

	public static void main(String[] args)
	{
		DirAcycGraph myGraph = new DirAcycGraph();
		Key node1 = new Key();
		Key node2 = new Key();

		node1.value = "myValue";
		node2.value = "myValue2";

		System.out.println(node1.value);
		System.out.println(node2.value);

		myGraph.put(node1,"myValue1");
		myGraph.put(node2,"myValue123");
	}

}