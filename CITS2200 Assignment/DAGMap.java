import CITS2200.*;

/**
 * DAG Map Assignment Interface and Class
 * @author Caleb Fetzer 21384976	
 * @author Reece Notargiacomo 21108155
 */

/**
 * DirectedAcyclicGraph interface
 *   - Directed Edges (one way)
 *   - No cycles
 */
public interface DirAcycGraph
{
	/**
	 * Describe Method here
	 * @param k, Key for ...
	 * @param v, Value for ...
	 * @return ...
	 */
	public void put (int k, value v);

	/**
	 * Standard map operation, gives the value corresponding to the given key
	 * @param k, the vertex to return the value
	 * @return the value corresponding to key
	 * 
	 */
	public get ( int k);

	
	/**
	 * Describe Method here
	 */
	public void remove (int k);

	/**
	 * DAG operation: adds a directed edge between two vertices, provided no cycle is created
	 * @param kReq - the vertex at the start of the edge
	 * @param kDep - the vertex at the end of the edge
	 **/	
	public void addDependency (int kReq, int kDep ){
	}

	/**
	 * DAG operation: removes an edge between two vertices, if it exists
	 * @param kReq - the vertex at the start of the edge
	 * @param kDep - the vertex at the end of the edge
	 **/
	public void removeDependency (int kReq, int kDep) {
	}
	
	/**
	 * Tests whether there are any vertices defined in the graph
	 * @return true if and only if there are no vertices in the graph
	 **/
	public boolean isEmpty() {
		// return verticesVariable == null; 
	}

	/**
	 * Tests whether a key is defined in the map, using the equals method
	 * @param k - the key to be tested
	 * @return - true if and only if the key is a vertex of the graph
	 **/
	public boolean containsKey (int k) {
	}

	/** 
	 * @param val, value to be tested
	 * @return true if and only if there is at least one vertex in the graph with a label equal to value
	 **/
	public boolean containsValue (int val) {
	}


	/**
	 * Tests whether kOne is a requirement for kTwo (or is kTwo dependent on kOne).	
	 * This is defined by either there being an edge from kOne to kTwo, or there being
	 * some other vertex v that is dependent on kOne, where there is an edge from v to kTwo.
	 * @param kOne - the requirement vertex
	 * @param kTwo - the dependent vertex
	 * @return true if and only if kOne is a requirement for kTwo. If either key is not an element,
	 * of the graph, return false.
	 **/
	public boolean isDependent (int kOne, int kTwo) {
	}

	/**
	 * Creates a semi-deep clone of the DAGMap, by cloning the keys (vertices) but not the values.
	 * @return - A DAGMap that is equal to the map, but with cloned vertices
	 **/
	public Object clone() {
		// return clonedMap;
	}
	
	public void set ();

}

/**
 * DAGMap implementation of DirAcycGraph Interface
 */
public static class DAGMap implements DirAcycGraph
{
	/**
	 * Code here
	 */
}
