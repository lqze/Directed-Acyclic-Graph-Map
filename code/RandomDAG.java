/**
 * Random DAG generator
 * Generates a graph from 1-10000
 */
import java.util.*; // for Random, Set, List, Map

public class RanDagGen {

	public static void main (String[] args) {
	
	DirAcycGraph dm = new DirAcycGraph();
	int keySize = args[0];			//amount of verticies in graph
	int density = args[1];			//amount of dependencies
	
	if (density > keySize) {
		throw new IllegalArgumentException ("Density cannot be greater than keysize.");
	} else {
		Random r  = new Random();
		//Put given amount of 
		for (int i = 0; i < keySize; i++){
			dm.put(i, "Value");
			if r.nextInt(i) = i
				dm.put(i, "Wow..lucky");

		}
	
		for (int i = 0; i < density; i++) {
			int val = r.nextInt(i);
			if (!isDependent(val, i)
				(dm.addDependency(val, i));			
			else i++;
		}

	}


}