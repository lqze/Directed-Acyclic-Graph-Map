import CITS2200.*;

/**
 * DAG Map Assignment Interface and Class
 * For CITS2200. Project 1.
 * @author Caleb Fetzer 21384976	
 * @author Reece Notargiacomo 21108155
 */

/**
 * DirectedAcyclicGraph interface
 *   - Directed Edges (one way)
 *   - No cycles
 */
public interface DAGMap<K,V> { 

	/**
	*Standard map operation:
	*Adds the vertex key to the graph (with no edges) and maps key to value
	*@param key the new vertex added to the graph
	*@param value the label of the vertex
	*@throws IllegalArgumentException if key is null, or is already in the graph
	**/ 
	public void put(K key, V value) throws IllegalArgumentException;

	/**
	 * Standard map operation
	 * Gives the value corresponding to the given key
	 * @param key the vertex to return the valu
	 * @return the value corresponding to key
	 * @throws IllegalArgumentException if they key does not exist in the DAG
	 **/
	 public V get(K key) throws IllegalArgumentException;


	/**
	*Standard map operation:
	*Removes the vertex key from the graph, as well as its label, and any associated edges
	*@param key the vertex to be removed
	*@throws IllegalArgumentException if key is not a vertex in the graph
	**/
	public void remove(K key) throws IllegalArgumentException;

	/**
	*DAG operation: adds a directed edge between two vertices, provided 
	*that no cycle is created
	*@param requirement the vertex at the start of the edge
	*@param dependent the vertex at the end of the edge
	*@throws IllegalArgumentException if either requirement or dependent are not 
	*elements of the graph, or if the new edge would create a cycle
	**/
	public void addDependency(K requirement, K dependent) throws IllegalArgumentException;

	/**
	*DAG operation: removes an edge between two vertices, if it exists
	*@param requirement the vertex at the start of the edge
	*@param dependent the vertex at the end of the edge
	*@throws IllegalArgumentException if either requirement or dependent are not 
	*vertices in the graph
	**/
	public void removeDependency(K requirement, K dependent) throws IllegalArgumentException;

	/**
	*Tests whether there are any vertices defined in the graph
	*@return true if and only if there are no vertices in the graph
	**/
	public boolean isEmpty();

	/**
	*Tests whether a key is defined in the map, using the equals method
	*@param key the key to be tested
	*@return true if and only if the key is a vertex of the graph
	**/
	public boolean containsKey(K key);

	/**
	*Tests whether there is some vertex in the graph that has a label equal to value
	*@param value the value to be tested
	*@return true if and only if there is at least one vertex in the graph with a 
	*label equal to value
	**/
	public boolean containsValue(V value);

	/**
	*Tests whether key1 is a requirement for key2 (or is key2 is dependent on key1)
	*This is defined by either there being an edge from key1 to key2, 
	*or there being some other vertex v that is dependent on key1, where there is an 
	*edge from v to key2
	*@param key1 the requirement vertex
	*@param key2 the dependent vertex
	*@return true if and only if key1 is a requirement for key2. If either key is not 
	*an element of the graph, return false.
	**/   
	public boolean isDependent(K key1, K key2);

	/**
	*Creates a semi-deep clone of the DAGMap, by cloning the keys (vertices) but not 
	*the values.
	*@return A DAGMap that is equal to this map, but with cloned vertices
	**/
	public Object clone();

	/**
	*Produces a iterator that is guaranteed to process the elements in some 
	*topologically sorted order
	*where each call to next will return the next vertex
	*That is, the iterator will never return a dependent vertex until all of the 
	*requirements of the vertex have been returned
	*@return an iterator that will process the labels of the graph in topologically 
	*sorted order
	**/ 
	public Iterator<K> iterator();

	/**
	*Tests whether this is equal to some object: The Object must be an implementation of 
	*DAGMap 
	*and the two DAGMaps are equal if they have equal sets of keys; equal sets of values;
	*equal keys map to equal values; and there is a dependency (not just an edge) between 
	*two keys in one graph if 
	*and only if there is a dependency between the two equal keys in the second graph;
	*(Note that equal DAGMap's will not necessarily have the same behaviour with respect to 
	*the removeDependency operation).
	*@param o the object to be tested
	*@return true if and only this is equal to o 
	**/
	public boolean equals(Object o);

	/**
	*Returns the set of vertices in the DAG  
	*@return the set of vertices in the graph
	**/ 
	public Set<K> getKeySet();

	/**
	*Returns the set of keys that are immediately dependent on the given key 
	*(that is, there are edges from key to exactly the vertices in the returned set)
	*@param key the vertex on which the returned set must be dependent
	*@return the set of vertices dependent on key
	*@throws IllegalArgumentException if key is not a vertex of the DAG
	**/ 
	public Set<K> getSuccessors(K key) throws IllegalArgumentException;

	/**
	*Returns the set of keys that are immediate requirements for the given key 
	*(that is, there is an edge from every vertex, and only these vertices, in the 
	*returned set to key)
	*@param key the vertex on which the returned set must be requirements
	*@return the set of vertices required for key
	*@throws IllegalArgumentException if key is not a vertex of the DAG
	**/ 
	public Set<K> getPredecessors(K key) throws IllegalArgumentException;

	/**
	*The width of a DAG is the minimum number of paths required to cover it
	*A path is a sequence (v(1),v(2),..,v(n)) where for each i greater than 1, 
	*v(i) is dependent on v(i-1): 
	*This method should aim to return the minimum number of sequences such that 
	*every vertex appears in at least one sequence (but potentially more): 
	*for example the width of an empty DAGMap is 0, and if there are n vertices 
	*with no requirements, then the width will be at least n
	*@return the width of the DAGMap
	**/ 
	public int getWidth();

	/**
	*Returns the length of the longest possible path through the DAGMap
	*A path is a sequence (v(1),v(2),..,v(n)) where for each i greater than 1, 
	*v(i) is dependent on v(i-1)
	*@return the length of the longest possible path in the DAGMap
	**/ 
	public int getLongestPath();

	/**
	 *Gets the maximum flow between two vertices in the DAG; The maximum flow is the 
	 *maximum number of paths through the DAG that do not share a vertex.
	 *@param source the start vertex
	 *@param sink the end vertex
	 *@return The maximum flow through the DAG
	 **/
	 public int getMaxFlow(K source, K sink);
	
	/**
	*Returns a multi-line String representation of the DAGMap
	*The representation should fist present the mapping in the form<br>
	*<code> key : value</code><br>
	*one per line, where the order of the pairs is not important
	*Then, the representation should give the set of dependencies 
	*to completely describe the graph
	*<code> key1 : key2</code><br>
	*@return a String representation of the DAGMap
	**/
	public String toString();
	
}
}

/**
 * DAGMap implementation of DirAcycGraph Interface
 */
public static class DirAcycGraph implements DAGMap {

	/**
	 * DAG operation: adds a directed edge between two vertices, provided no cycle is created
	 * @param kReq - the vertex at the start of the edge
	 * @param kDep - the vertex at the end of the edge
	 **/	
	public void addDependency (K kReq, K kDep ){
		if (!notCycle) {
		}
	}

	/**
	 * DAG operation: removes an edge between two vertices, if it exists
	 * @param kReq - the vertex at the start of the edge
	 * @param kDep - the vertex at the end of the edge
	 **/
	public void removeDependency (K kReq, K kDep) {
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
	public boolean containsKey (K key) {
		if( key != null) 
	}

	/** 
	 * @param val, value to be tested
	 * @return true if and only if there is at
	 * least one vertex in the graph with a label equal to value
	 **/
	public boolean containsValue (int val) {
	}


	/**
	 * Tests whether kOne is a requirement for kTwo (or is kTwo dependent on kOne).	
	 * This is defined by either there being an edge from kOne to kTwo, or there being
	 * some other vertex v that is dependent on kOne, where there is an edge from v to kTwo.
	 * @param kOne - the requirement vertex
	 * @param kTwo - the dependent vertex
	 * @return true if and only if kOne is a requirement for kTwo. 
	 * If either key is not an element,
	 * of the graph, return false.
	 **/
	public boolean isDependent (int kOne, int kTwo) {
	}

	/**
	 * Creates a semi-deep clone of the DAGMap, by cloning the keys (vertices) 
	 * but not the values.
	 * @return - A DAGMap that is equal to the map, but with cloned vertices
	 **/
	public Object clone() {
		// return clonedMap;
	}
	
	/**
	 * Produces an iterator that is guaranteed to process the elements
	 * in some topologically sorted order, where each call to next will 
	 * return the next vertex. That is, the iterator will never return a dependent
	 * vertex until all of the requirements of the vertex have been returned.
	 * @return an iterator that will process the labels of the graph in
	 * topologically sorted order.
	 **/
	public Iterator iterator() {
		public boolean hasNext() {
		}
		
		public next() {
		}
	}

	/**
	 *@param o - the object to be tested
	 *@return true if and only this is equal to
	 **/
	public boolean equals(Object o) {
	}

	/** 
	 *@return the set of vertices in the graph
	 **/
	public getKeySet() throws IllegalArgument {
	}

	/**
	 *@param the vertex on which the returned set must be dependent
	 *@return the set of vertices dependent on key
	 *@exception IllegalArgumentException - if key is not a vertex of DAG
	 **/
	public getDependents(K key) throws IllegalArgument {
	}

	/**
	 *@param key the vertex on which the returned set must meet the requirements
	 *@return the set of vertices required for the key
	 *@exception IllegalArgumentException if key is not a vertex of the DAG
	 **/
	public getRequirements(K key) throws IllegalArgument {
	}

	
	/**
	 *@return the width of the DAGMap
	 **/
	public int getWidth() {
	}

	/**
	 *@return the length of the longest possible path in the DAGMap
	 **/
	public int getLongestPath(){ 
	}

	/**
	 *@param source - the start vertex
	 *@param sink - the end vertex
	 *@return the maximum flow through the DAG
	 */
	public int getMaxFlow(int source, int sink) {
	}

	/**
	 *@override toString in class Object
	 *@return a String representation of the DAGMap
	 */
	public String toString() {
	}
		

}
